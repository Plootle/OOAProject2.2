import java.util.Random;

public class Orbiter extends Creatures {
    // Circle outer rooms
    // Wont move if in room with adventurer
    // Starts in an outer room on any of the four levels

    //roll 1-4 for room
    //roll 1-8 for location
    private int spawn[];
    
    public int[] spawn_loc()
    {
        Room r = new Room();
        int floor = 0;
        int room_num = 0;
        int temp_room[][] = {{0}};
        Random rn = new Random();

        floor = rn.nextInt(4) + 1;
        room_num = rn.nextInt(8);
        
        if (room_num >= 4)
            room_num += 1;

        // System.out.println("the floor number is " + floor);
        // System.out.println("the room number is " + room_num);

        if (floor == 1)
            temp_room = r.room1();
        if (floor == 2)
            temp_room = r.room2();
        if (floor == 3)
            temp_room = r.room3(); 
        if (floor == 4)
            temp_room = r.room4();   

        for(int i=0; i < temp_room.length; i++)
        {
            if(i == room_num)
                spawn = temp_room[i];
        }

        // for(int i=0; i <spawn.length; i++)
        //     System.out.print(spawn[i]);
        return spawn;
    }
}
