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
   
   // Here, we are able to take advantage of inheritance because 
   // the adventurer subclasses are derived from here
   
   private int hp = 3;
   private int treasure = 0;
   private boolean alive = true;
   private int location[] = {0,1,1};
   public String getName() {return "";}

   /*
    * Here we use some abstraction. Above are some private variables that
    * we are hiding and below we have some public variables that reduce 
    * the complexity of our program while increasing its efficiency.
    */
   
   public int get_hp()
   {
      return hp;
   }

   public void set_hp(int new_hp)
   {
      hp = new_hp;
      is_Alive();
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
      return location;
   }

   public void set_location(int new_loc[])
   {
      location = new_loc;
   }

   /*
    * This function helps track of active Adventurers in game
    * By setting their location to a space not within the map, we secure crreatures never attempt to fight with 
    * an adventurer that shouldn't be active
    */
   public Boolean is_Alive()
   {
      if(hp == 0)
      {
         alive = false;
         int[] deadlocation= {0,0,0};
         set_location(deadlocation);
      }
         
      return alive;

   }

   /*
   * This is an example of polymorphism because some of the 
   * adventurers have different abilities that deal with dice,
   * so this function occurs in several different forms.
   */
   public int get_roll()
   {
      MoveSet roll = new MoveSet();
      return roll.dice();
   }
} 