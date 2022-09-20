import java.util.Random;

public class Compass{

    int f = 0, r = 0, c = 0;
    int[] F1 = {1,1,1};
    int[] F2 = {2,1,1};
    int[] F3 = {3,1,1};
    int[] F4 = {4,1,1};
    int direction = 0;
    boolean cre_check = true;
    
    Random rn = new Random();
    
    public void get_Direction(Adventures a)
    {
        get_Adventurer_Location(a);

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
        if(checkValid(loc_change) == true)
        {
            a.set_location(loc_change);
            System.out.println(a.getName() + " current location: " + f + r + c);
        }
        else
        {
            //System.out.println("RE-ROLL");
            get_Direction(a);
        }
    }
    
    public void get_Adventurer_Location(Adventures a)
    {
        int[] adv_loc = a.get_location();
        f = adv_loc[0];
        r = adv_loc[1];
        c = adv_loc[2];
        int[] temp = {f,r,c};
        
        // center room
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

    public void get_Creature_Direction(Creatures cre)
    {
        get_Creature_Location(cre);

        if (direction == 1)
            North();
        else if (direction == 2)
            East();
        else if (direction == 3)
            South();
        else if (direction == 4)
            West();

        int[] loc_change = {f,r,c};
        //System.out.println(direction);
        if(checkValid(loc_change) == true)
        {
            cre.set_location(loc_change);
            System.out.println(cre.getName() + " current location: " + f + r + c);
        }
        else
        {
            //System.out.println("RE-ROLL");
            get_Creature_Direction(cre);
        }
    }

    public void get_Creature_Location(Creatures cre)
    {
        int[] cre_loc = cre.get_location();
        f = cre_loc[0];
        r = cre_loc[1];
        c = cre_loc[2];
        int[] temp = {f,r,c};

        // orbiter interaction with center room
        if(cre.getName() == "Orbiter" && F1[0] == temp[0] && F1[1] == temp [1] && F1[2] == temp[2])
            cre_check = false;
        else if(cre.getName() == "Orbiter" && F2[0] == temp[0] && F2[1] == temp [1] && F2[2] == temp[2])
            cre_check = false;
        else if(cre.getName() == "Orbiter" && F3[0] == temp[0] && F3[1] == temp [1] && F3[2] == temp[2])
            cre_check = false;
        else if(cre.getName() == "Orbiter" && F4[0] == temp[0] && F4[1] == temp [1] && F4[2] == temp[2])
            cre_check = false;
        else
            direction = rn.nextInt(4) + 1;

        // I think the seeker searching for adventureres would go in its file
        // and not here
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

    public boolean checkValid(int[] loc_change)
    {
        if(f >= 1 && f <= 4 && r >= 0 && r <= 2 && c >= 0 && c <= 2) //check floor is valid
            return true;
        else if (cre_check == false)
            return false;
        else
            return false;
    }
}