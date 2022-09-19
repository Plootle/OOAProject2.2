import java.util.Random;

public class Blinker extends Creatures {
    // Move randomly to any room in any floor
    // START on random room in floor 4
    // Wont move if in room with adventurer
    private int spawn[];
    
    public int[] spawn_loc()
    {
        Room r = new Room();
        Random rn = new Random();
        int room_num = rn.nextInt(9);
        int temp_room[][] = r.room4();   
   
        //System.out.println("the room number is " + room_num);

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
