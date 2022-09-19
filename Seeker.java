import java.util.Random;

public class Seeker extends Creatures {
    // seek to move into adjacent room of adventurers
    // can start anywhere in floor
    // will not move if adventurer is in adjacent room or in same room

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
        
        System.out.println("the floor number is " + floor);
        System.out.println("the room number is " + room_num);

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

        for(int i=0; i <spawn.length; i++)
            System.out.print(spawn[i]);
        return spawn;
    }
}
