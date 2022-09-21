import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    // The Facility’s center Rooms are labeled 0-1-1, 1-1-1, 2-1-1, 3-1-1, and 4-1-1  
    // Our Room.Java file is a good example of cohesion due to its design.
    // It's design is soley focused on creating the rooms and displaying them.
    public int[][] room0()
    {
        int room0[][] = {{0,1,1}};
        return room0;
    }

    public int[][] room1(){
        int room1[][] = {
            {1,0,0}, {1,0,1}, {1,0,2},      // 0 1 2        0 -> 1,0,0
            {1,1,0}, {1,1,1}, {1,1,2},      // 3 4 5        4 -> 1,1,1
            {1,2,0}, {1,2,1}, {1,2,2}};     // 6 7 8        7 -> 1,2,1
        return room1;
    }
    public int[][] room2(){
        int room2[][] = {
            {2,0,0}, {2,0,1}, {2,0,2},      
            {2,1,0}, {2,1,1}, {2,1,2},
            {2,2,0}, {2,2,1}, {2,2,2}};
        return room2;
    }

    public int[][] room3(){
        int room3[][] = {
            {3,0,0}, {3,0,1}, {3,0,2},
            {3,1,0}, {3,1,1}, {3,1,2},
            {3,2,0}, {3,2,1}, {3,2,2}};
        return room3;
    }

    public int[][] room4(){
        int room4[][] = {
            {4,0,0}, {4,0,1}, {4,0,2},
            {4,1,0}, {4,1,1}, {4,1,2},
            {4,2,0}, {4,2,1}, {4,2,2}};
        return room4;
    }    

    public void Display(ArrayList<Creatures> creatures, ArrayList<Adventures> adventurer)
    {
        Display_Helper(room0(), creatures, adventurer);
        System.out.println("");
        Display_Helper(room1(), creatures, adventurer);
        Display_Helper(room2(), creatures, adventurer);
        Display_Helper(room3(), creatures, adventurer);
        Display_Helper(room4(), creatures, adventurer);
        
        
    }

    public void Display_Helper(int[][] room, ArrayList<Creatures> creatures, ArrayList<Adventures> adventurer)
    {
        Adventures a = new Adventures();
        Creatures c = new Creatures();
        ArrayList<Character> advInitials = new ArrayList<Character>();
        ArrayList<Character> creInitials = new ArrayList<Character>();
        
        int count = 0;
        for(int i = 0; i < room.length; i++)
        {
            int[] space = room[i];
            //int f = space[0];
            //int r = space[1];
            //int c = space[2];
            
            advInitials.clear();
            creInitials.clear();
            // Prints Room in format (Floor-Row-Column)
            for(int j=0; j < room[i].length; j++)
            {
                if(j == room[i].length-1)
                    System.out.print(space[j] + ": ");
                else
                    System.out.print(space[j] + "-");
                
                count++;
            }
            
            // creates list of all Adventurers in room, saves initials
            for(int j=0; j < adventurer.size(); j++)
            {
                a = adventurer.get(j);
                char advInitial = a.getName().charAt(0);
                if(Arrays.equals(a.get_location(), space))
                {
                    advInitials.add(advInitial);
                }
                
            }

            // creates list of all Creatures in room, saves initials
            for(int j=0; j < creatures.size(); j++)
            {
                c = creatures.get(j);
                char creInitial = c.getName().charAt(0);
                if(Arrays.equals(c.get_location(), space))
                {
                    creInitials.add(creInitial);
                }
                
            }

            

            // Print Adventurers Initials
            if(advInitials.size() == 0)
                System.out.print("-:");
            else
            {
                for(int j=0; j < advInitials.size(); j++)
                {
                    System.out.print(advInitials.get(j));
                }
                System.out.print(":");
            }

            //Print Creatures Initials
            if(creInitials.size() == 0)
                System.out.print("- ");
            else
            {
                for(int j=0; j < creInitials.size(); j++)
                {
                    System.out.print(creInitials.get(j));
                }
                System.out.print(" ");
            }


            if(count == 9)
            {
                System.out.println("");
                count = 0;
                
            }   
        }
    }
}

//need to print out the rooms (Display everything?)