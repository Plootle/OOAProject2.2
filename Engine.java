import java.util.ArrayList;

public class Engine {
    public int Engine1()
    {
        //int turnCount = 0;
        int tresCount = 0;
        Room room = new Room();
        MoveSet move = new MoveSet();
        Thief thief = new Thief();
        Brawler brawler = new Brawler();
        Runner runner = new Runner();
        Sneaker sneaker = new Sneaker();

        // here is a good example of identity, where we establish our two
        // sides and fill them with unique entities and have each entity
        // store their own stats such as location, treasure, and health.
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
        creatures.add(seeker1);
        creatures.add(seeker2);
        creatures.add(seeker3);
        creatures.add(seeker4);

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
        }

        // This all represents round 0, where adventurers spawn
        // adventurers first move (go from 011 to 111)
        // System.out.println("RotLA Turn " + turnCount + ":");
        // room.Display(creatures, adventures);
        // adventurers first move (go from 011 to 111)
        for (int i = 0; i < adventures.size(); i++)
        {
            int [] temp_arr = {1, 1, 1};
            a = adventures.get(i);
            a.set_location(temp_arr);   
        }
        //turnCount++;

        // This shows adventurers going into the first floor
        // System.out.println("RotLA Turn " + turnCount + ":");
        // room.Display(creatures, adventures);
        
        boolean end_condition = false;
        while (end_condition == false)
        {
            int interact;
            //thiefs turn
            interact = move.check_Room(thief, creatures);
            if(thief.is_Alive())
            {
                interact = move.check_Room(thief, creatures);
                if (interact ==1 && thief.is_Alive() == true)
                {
                    move.traverse(thief);
                    interact = move.check_Room(thief, creatures);
                    if (interact ==1 && thief.is_Alive() == true)
                    {
                        move.treasure(thief);
                    }
                }
            }

            move.update_Creatures_Alive(creatures);

            // Brawler turn
            interact = move.check_Room(brawler, creatures);
            if(brawler.is_Alive())
            {
                interact = move.check_Room(brawler, creatures);
                if (interact ==1 && brawler.is_Alive() == true)
                {
                    move.traverse(brawler);
                    interact = move.check_Room(brawler, creatures);
                    if (interact ==1 && brawler.is_Alive() == true)
                    {
                        move.treasure(brawler);
                    }
                }
            }

            move.update_Creatures_Alive(creatures);

            // Sneakers turn
            interact = move.check_Room(sneaker, creatures);
            if(sneaker.is_Alive())
            {
                interact = move.check_Room(sneaker, creatures);
                if (interact ==1 && sneaker.is_Alive() == true)
                {
                    move.traverse(sneaker);
                    interact = move.check_Room(sneaker, creatures);
                    if (interact ==1 && sneaker.is_Alive() == true)
                    {
                        move.treasure(sneaker);
                    }
                }
            }

            move.update_Creatures_Alive(creatures);

            // Runner turn
            interact = move.check_Room(runner, creatures);
            if(runner.is_Alive())
            {
                interact = move.check_Room(runner, creatures);
                if (interact ==1 && runner.is_Alive() == true)
                {
                    move.traverse(runner);
                    interact = move.check_Room(runner, creatures);
                    if (interact ==1 && runner.is_Alive() == true)
                    {
                        move.treasure(runner);
                    }
                }
                
                interact = move.check_Room(runner, creatures);
                if (interact ==1 && runner.is_Alive() == true)
                {
                    move.traverse(runner);
                    interact = move.check_Room(runner, creatures);
                    if (interact ==1 && runner.is_Alive() == true)
                    {
                        move.treasure(runner);
                    }
                }
            }
            
            move.update_Creatures_Alive(creatures);
            
            

            // Creatures turn
            for(int i = 0; i < creatures.size(); i++)
            {
                c = creatures.get(i);
                if(c.is_Alive() == true)
                {
                    // if creature took fight and loses 
                    interact = move.check_Room(c, adventures);
                    if( interact== 1)
                    {
                        creatures.remove(creatures.get(i));
                    }
                    else if(interact == 0)
                    {
                        move.c_traverse(c, adventures);
                        interact = move.check_Room(c, adventures);
                    }
                }
            }

            move.update_Creatures_Alive(creatures);
            //System.out.println("");
            //turnCount++;
            // System.out.println("RotLA Turn " + turnCount + ":");
            // room.Display(creatures, adventures);
            
            
            //counting the treasure amount between all the adventurers
            tresCount = 0;
            for (int k = 0; k < adventures.size(); k++)
            {
                a = adventures.get(k);
                tresCount += a.get_treasure();
            }

            //check if the game ends
            if(tresCount >= 10)
            {
                System.out.println("All treasure has been found!");
                end_condition = true;
                return 1;
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
                System.out.println("All adventurers have been slain...");
                end_condition = true;
                return 2;
            }
            
            if (creatures.size() == 0)
            {
                System.out.println("All creatures have been slain!");
                end_condition = true;
                return 3;
            }
        }
        
        //System.out.println("total treasure " + tresCount);
        
        // int blinkerCount=0;
        // int seekerCount=0;
        // int orbiterCount=0;
        // for (int f = 0; f < creatures.size(); f++)
        // {
        //     c = creatures.get(f);
        //     if(c.getName() == "Blinker")
        //         blinkerCount++;
        //     if(c.getName() == "Seeker")
        //         seekerCount++;
        //     if(c.getName() == "Orbiter")
        //         orbiterCount++;
        // }
        
        

        // for(int i=0; i < adventures.size(); i++)
        // {
        //     a = adventures.get(i);
        //     System.out.println(a.getName() + " - " + a.get_treasure() + " Treasure(s) - " + a.get_hp() + " Health left");
        // }

        // System.out.println("\nBlinkers - " + blinkerCount + " Remaining");
        // System.out.println("Seekers - " + seekerCount + " Remaining");
        // System.out.println("Orbiters - " + orbiterCount + " Remaining");
        return 0;
    }
}
