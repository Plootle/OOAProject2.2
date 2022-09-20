import java.util.ArrayList;


public class Engine {
    public static void main(String args[])
    {
        int tresCount = 0;
        int temp_count=0;
        MoveSet move = new MoveSet();
        Thief thief = new Thief();
        Brawler brawler = new Brawler();
        Runner runner = new Runner();
        Sneaker sneaker = new Sneaker();

        Adventures a = new Adventures();
        Creatures c = new Creatures();

        Orbiter orbiter1 = new Orbiter();
        Seeker seeker1 = new Seeker();   
        Blinker blinker1 = new Blinker();
        
        Orbiter orbiter2 = new Orbiter();
        Seeker seeker2 = new Seeker();
        Blinker blinker2 = new Blinker();
        
        Orbiter orbiter3 = new Orbiter();
        Seeker seeker3 = new Seeker();
        Blinker blinker3 = new Blinker();

        Orbiter orbiter4 = new Orbiter();
        Seeker seeker4 = new Seeker();
        Blinker blinker4 = new Blinker();
        
        ArrayList<Adventures> adventures = new ArrayList<Adventures>();
        ArrayList<Creatures> creatures = new ArrayList<Creatures>();
        
        adventures.add(thief);
        adventures.add(brawler);
        adventures.add(sneaker);
        adventures.add(runner);
        
        creatures.add(blinker1);
        creatures.add(blinker2);
        creatures.add(blinker3);
        creatures.add(blinker4);
        creatures.add(orbiter1);
        creatures.add(orbiter2);
        creatures.add(orbiter3);
        creatures.add(orbiter4);
        // creatures.add(seeker1);
        // creatures.add(seeker2);
        // creatures.add(seeker3);
        // creatures.add(seeker4);

        for(int i = 0; i < adventures.size(); i++)
        {
            a = adventures.get(i);
            a.set_location(a.get_location());
            
            adventures.set(i, a);
        }
        
        for(int i = 0; i < creatures.size(); i++)
        {
            c = creatures.get(i);
            c.set_location(c.spawn_loc());
            
            creatures.set(i, c);
            //c.get_location();
        }

        // adventurers first move (go from 011 to 111)
        for (int i = 0; i < adventures.size(); i++)
        {
            int [] temp_arr = {1, 1, 1};
            a = adventures.get(i);
            a.set_location(temp_arr);
            a.get_location();
        }


        boolean end_condition = false;
        while (end_condition == false)
        {
            // move.traverse(thief);
            // move.traverse(brawler);
            // move.traverse(sneaker);

            // Loop for adventurers loop turn
            // for (int i = 0; i < adventures.size(); i++)
            // {
            //     a = adventures.get(i);
            //     if(a.is_Alive())
            //     {
            //         if(a.getName() == "Runner")
            //         {
            //             move.traverse(a);
            //             move.treasure(a);
            //             move.traverse(a);
            //             move.treasure(a);
            //         }
            //         else
            //         {
            //             move.traverse(a);
            //             move.treasure(a);
            //         }
                    
            //         //System.out.println(a.getName() + " location: " + a.get_location());
            //         //System.out.println(a.getName() + " got treasure: " + a.get_treasure());
            //     }
            // }

            // tresCount = 0;
            // for (int k = 0; k < adventures.size(); k++)
            // {
            //     a = adventures.get(k);
            //     tresCount += a.get_treasure();
            // }

            for(int i = 0; i < creatures.size(); i++)
            {
                c = creatures.get(i);
                move.c_traverse(c);
                
            }
            temp_count++;
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
            
            //System.out.println("Treasure count is: " + tresCount);
            //check if the game ends
            
            // if (creatures.size() == 0)
            // {
            //     System.out.println("All creatures have been slain!");
            //     end_condition = true;
            // }

            if (temp_count == 5)
            {
                end_condition = true;
            }

            if(tresCount >= 10)
            {
                System.out.println("Total " + tresCount);
                System.out.println("All treasure has been found!");
                end_condition = true;
            }

            int deadCount = 0;
            for(int i = 0; i < adventures.size(); i++)
            {
                a = adventures.get(i);
                if(a.is_Alive() == false)
                    deadCount++;
            }
            if (deadCount == 4)
            {
                System.out.println("All adventurers have been slain... :(");
                end_condition = true;
            }
        }
    }
}
