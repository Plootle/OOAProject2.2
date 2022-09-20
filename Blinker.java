import java.util.Random;

public class Blinker extends Creatures {
    // Move randomly to any room in any floor
    // START on random room in floor 4
    // Wont move if in room with adventurer

    public String getName()
    {
        return "Blinker";
    }

    private int spawn[];
    private int move[];
    
    public int[] spawn_loc()
    {
        Room r = new Room();
        Random rn = new Random();
        int room_num = rn.nextInt(9);
        int temp_room[][] = r.room4();   

        for(int i=0; i < temp_room.length; i++)
        {
            if(i == room_num)
                spawn = temp_room[i];
        }
        return spawn;
    }

    public int[] special_move()
    {
        Room r = new Room();
        int floor = 0;
        int room_num = 0;
        int temp_room[][] = {{0}};
        Random rn = new Random();

        floor = rn.nextInt(4) + 1;
        room_num = rn.nextInt(8);

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
                move = temp_room[i];
        }
        return move;
    }
}
