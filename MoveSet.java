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

    // fights are ints for return, so it is possible to remove creature after
    public int fight(Creatures c, Adventures a)
    {
        if(a.get_roll() < c.get_roll()) // adventurer lost
        {
            a.set_hp(a.get_hp() - 1);
            return 0;
        }
        else if(a.get_roll() > c.get_roll()) // creature lost 
            return 1;
        return 2; // tie 
    }

    public int fight( Creatures c, Brawler a)
    {
        if(a.fight_roll() < c.get_roll()) // adventurer lost
        {
            a.set_hp(a.get_hp() - 1); // creature lost 
            return 0;
        }
        else if(a.get_roll() > c.get_roll())
            return 1;
        return 2; // tie 
    }
    
    public int fight( Creatures c, Sneaker a)
    {
        if(a.dodge() == 1) // fight
        {
            if(a.get_roll() < c.get_roll()) // adventurer lost
            {
                a.set_hp(a.get_hp() - 1); 
                return 0;
            }
            else if(a.get_roll() > c.get_roll()) // creature lost 
                return 1;
        }
        return 2; // tie 
    }

    public void traverse(Adventures a)
    {
        Compass compass = new Compass();
        compass.get_Direction(a);
        // System.out.println(a.get_location());
    }

    public void treasure(Adventures a)
    {
        if (a.get_roll() >= 10)
            a.set_treasure(a.get_treasure() + 1);
    }
}