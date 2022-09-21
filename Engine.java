import java.util.ArrayList;

public class Engine {
    public static void main(String args[])
    {
        int tresCount = 0;
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

        // adventurers first move (go from 011 to 111)
        for (int i = 0; i < adventures.size(); i++)
        {
            int [] temp_arr = {1, 1, 1};
            a = adventures.get(i);
            a.set_location(temp_arr);
        }
       
        boolean end_condition = false;
        while (end_condition == false)
        {
            //thiefs turn
            int interact = move.check_Room(thief, creatures);
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
            
            for(int i =0; i < creatures.size(); i++)
            {
                c = creatures.get(i);
                if(c.is_Alive() == false)
                creatures.remove(creatures.get(i));
            }

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

            for(int i =0; i < creatures.size(); i++)
            {
                c = creatures.get(i);
                if(c.is_Alive() == false)
                creatures.remove(creatures.get(i));
            }

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
            }

            if (creatures.size() == 0)
            {
                System.out.println("All creatures have been slain!");
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
                System.out.println("All adventurers have been slain...");
                end_condition = true;
            }
        }
        System.out.println("total treasure " + tresCount);
        for (int f = 0; f < creatures.size(); f++)
        {
            c = creatures.get(f);
            System.out.println(c.getName());
        }
    }
}
