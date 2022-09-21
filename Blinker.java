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

    /*
    * Blinkers special movement is being able to teleport to any room in any floor
    */
    public int[] special_move(int[] loc)
    {
        //System.out.println("Blinker Moved");
        Room room = new Room();
        int f = 0;
        int room_num = 0;
        int temp_room[][] = {{0}};
        Random rn = new Random();

        f = rn.nextInt(4) + 1;
        room_num = rn.nextInt(8);

        // Take floor from Room into a variable
        if (f== 1)
            temp_room = room.room1();
        if (f == 2)
            temp_room = room.room2();
        if (f == 3)
            temp_room = room.room3(); 
        if (f == 4)
            temp_room = room.room4();   

        // Obtain and set room for Blinker
        for(int i = 0; i < temp_room.length; i++)
        {
            if(i == room_num)
                move = temp_room[i];
        }
        return move;
    }
}
