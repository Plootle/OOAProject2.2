import java.util.Random;

public class Compass{

    int f = 0, r = 0, c = 0; // floor, row, column
    // instances equivalent to center room in each floor
    int[] F1 = {1,1,1};
    int[] F2 = {2,1,1};
    int[] F3 = {3,1,1};
    int[] F4 = {4,1,1};
    int direction = 0;
    boolean cre_check = true;
    
    Random rn = new Random();
    
    public void get_Direction(Adventures a)
    {
        // call to get_Adventurer_Location(a); will give us a random location
        get_Adventurer_Location(a);

        // decides direction adventurer goes based on get_Adventurer_Location
        if (direction == 0)
            Down();
        else if (direction == 1)
            North();
        else if (direction == 2)
            East();
        else if (direction == 3)
            South();
        else if (direction == 4)
            West();
        else if (direction == 5)
            Up(); 

        int[] loc_change = {f,r,c};
        //System.out.println(direction);
        // Passes location to checkValid to see if its within our map
        if(checkValid(loc_change) == true)
        {
            a.set_location(loc_change);
            //System.out.println(a.getName() + " current location: " + f + r + c);
        }
        else // goes here when direction given was not a valid location withing our map
        {
            //System.out.println("RE-ROLL");
            get_Direction(a);
        }
    }
    
    // Checks if in center of room to go up or down a floor
    // Generates room to go to
    public void get_Adventurer_Location(Adventures a)
    {
        int[] adv_loc = a.get_location();
        f = adv_loc[0];
        r = adv_loc[1];
        c = adv_loc[2];
        int[] temp = {f,r,c};
        
        // Checks if in center room to allow access to up or down (if floor 2 and 3)
        // if floor 1, allows to go down + NESW
        // if floor 4, allows to go up+ NESW
        // otherwise NESW
        if(F1[0] == temp[0] && F1[1] == temp [1] && F1[2] == temp[2])
            direction = rn.nextInt(6);
        else if(F2[0] == temp[0] && F2[1] == temp [1] && F2[2] == temp[2])
            direction = rn.nextInt(6);
        else if(F3[0] == temp[0] && F3[1] == temp [1] && F3[2] == temp[2])
            direction = rn.nextInt(6);
        else if(F4[0] == temp[0] && F4[1] == temp [1] && F4[2] == temp[2])
            direction = rn.nextInt(6);
        else
            direction = rn.nextInt(4) + 1;
    }
    
    public void Up()
    {
        f -= 1;
    }
    
    public void North()
    {
        r -= 1;
    }

    public void East()
    {
        c += 1;
    }

    public void South()
    {
        r += 1;
    }

    public void West()
    {
        c -= 1;
    }

    public void Down()
    {
        f += 1;
    }

    /*
     * Validates the location adventurer is atttemting to go through
     * if all values are withing our grid, returns true to get_Direction
     * else get_Direction will re-roll the values until a valid position is obtained
     */
    public boolean checkValid(int[] loc_change)
    {
        if(f >= 1 && f <= 4 && r >= 0 && r <= 2 && c >= 0 && c <= 2) //check floor is valid
            return true;
        else
            return false;
    }
}