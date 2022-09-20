public class Adventures 
{
    // well divide each type of adventurer into a subclasses
    // adventurers have
    
    /*
    * Dice roll mechanic for fighting - Brawlers get +2
    * Encounter chance - Sneakers have 50% to not fight
    * Move mechanic (moving between rooms, fighting, treasure hunting) - Runners get 2 moves
    * 3 HP
    */
   
   private int hp = 3;
   private int treasure = 0;
   private boolean alive = true;
   private int location[] = {0,1,1};
   public String getName() {return "";}
   public int get_hp()
   {
      return hp;
   }

   public void set_hp(int new_hp)
   {
      hp = new_hp;
   } 

   public int get_treasure()
   {
      return treasure;
   }

   public void set_treasure(int new_treasure)
   {
      treasure = new_treasure;
   }

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

   public Boolean is_Alive()
   {
      if(hp == 0)
         alive = false;
      return alive;

   }
   public int get_roll()
   {
      MoveSet roll = new MoveSet();
      return roll.dice();
   }
} 