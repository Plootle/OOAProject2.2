import java.util.Random;

public class Creatures {
   //Here, we are able to take advantage of inheritance because 
   //the creatures subclasses are derived from here
   private int spawn_loc[];
   public String getName() {return "";}
   private boolean alive = true;
   private int location[];

   public int[] get_location()
   {
      // System.out.print("Prev Location: ");
      // for(int i = 0; i < location.length; i++)
      // {
      //    System.out.print(location[i]);
      // }
      // System.out.println("");
      return location;
   }

   public void set_location(int new_loc[])
   {
      location = new_loc;
   }

   // Function used to check if creature is alive. Used for deleting after a loss with an adventurer
   public Boolean is_Alive()
   {
      return alive;
   }

   // Call for when they lose a fight
   public void has_Died()
   {
      alive = false;
   }
   
   // Spawn mechanic used at the beginning of the game.
   // Creature will be given a random floor and room within our map to begin
   public int[] spawn_loc()
   {
      Room r = new Room();
      int floor = 0;
      int room_num = 0;
      int temp_room[][] = {{0}};
      Random rn = new Random();

      floor = rn.nextInt(4) + 1;
      room_num = rn.nextInt(8);
      
      // System.out.println("the floor number is " + floor);
      // System.out.println("the room number is " + room_num);

      if (floor == 1)
         temp_room = r.room1();
      if (floor == 2)
         temp_room = r.room2();
      if (floor == 3)
         temp_room = r.room3(); 
      if (floor == 4)
         temp_room = r.room4();   

      for(int i=0; i < temp_room.length; i++)
      {
         if(i == room_num)
               spawn_loc = temp_room[i];
      }

      // for(int i = 0; i <spawn_loc.length; i++)
      //    System.out.print(spawn_loc[i]);
      return spawn_loc;
   }

   

   public int get_roll()
   {
      MoveSet roll = new MoveSet();
      return roll.dice();
   }
}