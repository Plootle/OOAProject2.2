import java.util.Random;

public class Orbiter extends Creatures {
    // Circle outer rooms
    // Wont move if in room with adventurer
    // Starts in an outer room on any of the four levels

    public String getName()
    {
        return "Orbiter";
    }

    //roll 1-4 for floor and 1-8 for room
    private int spawn[];
    private int move[];
    
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

        for(int i = 0; i < temp_room.length; i++)
        {
            if(i == room_num)
                spawn = temp_room[i];
        }
        return spawn;
    }

    public int[] special_move(int[] loc)
    {   
        //System.out.println("Orbiter Moved");
        int f = 0;
        //int[] cre_loc = cre.get_location();
        f = loc[0];

        Room room = new Room();
        int room_num = 0;
        int temp_room[][] = {{0}};
        Random rn = new Random();

        room_num = rn.nextInt(8);

        //prevents the room number from being 4 (center)
        if (room_num >= 4)
            room_num += 1; 
        
        //create the rooms
        if (f == 1)
            temp_room = room.room1();
        if (f == 2)
            temp_room = room.room2();
        if (f == 3)
            temp_room = room.room3(); 
        if (f == 4)
            temp_room = room.room4();

        for(int i = 0; i < temp_room.length; i++)
        {
            if(i == room_num)
                move = temp_room[i];
        }
        return move;
    }
}
