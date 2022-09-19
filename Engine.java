import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Engine {
    public static void main(String args[])
    {
        Thief thief = new Thief();
        Brawler brawler = new Brawler();
        Runner runner = new Runner();
        Sneaker sneaker = new Sneaker();
        Orbiter orbiter= new Orbiter();
        Blinker blinker = new Blinker();
        Seeker seeker = new Seeker();   
        
        ArrayList<Adventures> adventures = new ArrayList<Adventures>();
        ArrayList<Creatures> creatures = new ArrayList<Creatures>();
        int treasure = 0;
        
        adventures.add(thief);
        adventures.add(brawler);
        adventures.add(sneaker);
        adventures.add(runner);
        creatures.add(blinker);
        creatures.add(blinker);
        creatures.add(blinker);
        creatures.add(blinker);
        creatures.add(orbiter);
        creatures.add(orbiter);
        creatures.add(orbiter);
        creatures.add(orbiter);
        creatures.add(seeker);
        creatures.add(seeker);
        creatures.add(seeker);
        creatures.add(seeker);
        
        seeker.spawn_loc();
        boolean end_condition = false;
        while (end_condition == false)
        {
            //run the turns
            // compare the locations of the creature and the adventurers
            // if( a location == c location)
                // loop through creature list in case of multiple entities in same room.
                // fight() (does it return 0, 1, or 2?) (0 - adv lost) (1 - cre lost) (2 - tie)
                // if hp == 0
                    //remove adventurer from ArrayList

            // else move
                // if( a location == c location)
                    // loop through creature list in case of multiple entities in same room.
                    // fight() (does it return 0, 1, or 2?) (0 - adv lost) (1 - cre lost) (2 - tie)
                    // if hp == 0
                        //remove adventurer from ArrayList
                // else if (adventurer turn)
                    // if (a.get_roll() >= 10)
                        // treasure++;
        //^ same logic for creature 

            for(int i =0; i < adventures.size(); i++)
            {
                // decide valid location within floor to move
            }

            //check if the game ends
            if(treasure == 10)
            {
                System.out.println("All treasure has been found!");
                end_condition = true;
            }
            if (creatures.size() == 0)
            {
                System.out.println("All creatures have been slain!");
                end_condition = true;
            }
            if (adventures.size() == 0)
            {
                System.out.println("All adventurers have been slain... :(");
                end_condition = true;
            }
        }
    }
}
