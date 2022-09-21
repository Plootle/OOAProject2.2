import java.util.ArrayList;
import java.util.Random;

public class MoveSet {
    /*
     * Based on our UML this will bet where we traverse the map, 
     * take fights, find treasure,  and decide outcomes
     */ 

    //roll two 6 sided dice to determine damage
    //roll two 6 sided dice to find treasure (10 or higher)
    public int dice()
    {
        int dice = 0;
        int answer = 0;
        Random rn = new Random();

        for(int i = 0; i < 2; i++)
        {
            answer = rn.nextInt(6) + 1;
            dice += answer;
        }
        return dice;
    }

    /*
     * Adventurer Checks current room
     */

    public int check_Room(Adventures a, ArrayList<Creatures> creatures)
    {
        Creatures c = new Creatures();
        Boolean interaction = false;
        int[] aTemp = a.get_location();
        int aF = aTemp[0];
        int aR = aTemp[1];
        int aC = aTemp[2];
        int cF;
        int cR;
        int cC;

        // check all creatues 
        for(int i = 0; i < creatures.size(); i++)
        {
            c = creatures.get(i);
            int[] cTemp = c.get_location();
            cF = cTemp[0];
            cR = cTemp[1];
            cC = cTemp[2];

            // if same room, attempt fight
            if(aF == cF && aR == cR && aC == cC)
            {
                interaction = true;
                int result = fight(c, a);
                if(result == 0) // if adventurer loses fight
                {
                    return 0;
                }
            }
        }
        if (interaction == false)
            return 1;
        return 2;// tie occured
    }

    // Creature checks the current room
    public int check_Room(Creatures c, ArrayList<Adventures> adventurers)
    {
        Adventures a = new Adventures();
        
        int[] cTemp = c.get_location();
        int cF = cTemp[0];
        int cR = cTemp[1];
        int cC = cTemp[2];
        int aF;
        int aR;
        int aC;
        Boolean interaction = false;
        // loop through all adventurers
        for(int i = 0; i < adventurers.size(); i++)
        {
            a = adventurers.get(i);
            int[] aTemp = a.get_location();
            aF = aTemp[0];
            aR = aTemp[1];
            aC = aTemp[2];
            // if in same room, attemp fight
            if(aF == cF && aR == cR && aC == cC)
            {
                interaction = true;
                int result =fight(c, a);
                if(result == 1) // if creature loses fight
                {
                    return 1;
                }
            }
        }
        if (interaction == false)
            return 0;
        return 2;// tie occured
    }


    
    // fights are ints for return, so it is possible to remove creature after
    public int fight(Creatures c, Adventures a)
    {
        
        Brawler brawler = new Brawler();
        Sneaker sneaker = new Sneaker();
        Thief thief = new Thief();
        
        // if the brawler fights
        if(a.getName() == "Brawler")
        {
            if(brawler.fight_roll() < c.get_roll()) // adventurer lost
            {
                a.set_hp(a.get_hp() - 1); // creature lost 
                return 0;
            }
            else if(brawler.get_roll() > c.get_roll())
            {
                c.has_Died();
                return 1;
            }
            
        }
        //if the sneaker fights or avoids a fight
        else if (a.getName() == "Sneaker")
        {
            if(sneaker.dodge() == 1) // fight
            {
                if(a.get_roll() < c.get_roll()) // adventurer lost
                {
                    a.set_hp(a.get_hp() - 1); 
                    return 0;
                }
                else if(a.get_roll() > c.get_roll()) // creature lost 
                {
                    c.has_Died();
                    return 1;
                }
            }
        }
        //if the Thief fights
        else if(a.getName() == "Thief")
        {
            if(thief.get_roll() < c.get_roll()) // adventurer lost
            {
                a.set_hp(a.get_hp() - 1); // creature lost 
                return 0;
            }
            else if(thief.get_roll() > c.get_roll())
            {
                c.has_Died();
                return 1;
            }
            
        }
        //runner fights
        else
        {
            if(a.get_roll() < c.get_roll()) // adventurer lost
            {
                a.set_hp(a.get_hp() - 1); // creature lost 
                return 0;
            }
            else if(a.get_roll() > c.get_roll())
            {
                c.has_Died();
                return 1;
            }
        }
        return 2; // tie 
    }

    public void traverse(Adventures a)
    {
        Compass compass = new Compass();
        compass.get_Direction(a);
        // System.out.println(a.get_location());
    }

    public void c_traverse(Creatures c, ArrayList<Adventures> adventures)
    {
        
        if(c.getName() == "Orbiter")
        {
            Orbiter orbiter = new Orbiter();
            orbiter.set_location(orbiter.special_move(c.get_location()));
            c.set_location(orbiter.get_location());
            // int[] temp = c.get_location();
            // for(int i = 0; i < temp.length; i++)
            // {
            //     System.out.print(temp[i]);
            // }
            // System.out.println("");
            // System.out.println(c.get_location());
        }
            
        if(c.getName() == "Blinker")
        {
            Blinker blinker = new Blinker();
            blinker.set_location(blinker.special_move(c.get_location()));
            c.set_location(blinker.get_location());
        }

        if(c.getName() == "Seeker")
        {
            Seeker seeker = new Seeker();
            seeker.set_location(seeker.special_move(c.get_location(), adventures));
            c.set_location(seeker.get_location());
        }
    }

    public void treasure(Adventures a)
    {
        if (a.get_roll() >= 10)
            a.set_treasure(a.get_treasure() + 1);
    }

    public void update_Creatures_Alive(ArrayList<Creatures> creatures)
    {
        Creatures c = new Creatures();
        for(int i =0; i < creatures.size(); i++)
            {
                c = creatures.get(i);
                if(c.is_Alive() == false)
                creatures.remove(creatures.get(i));
            }
    }
}