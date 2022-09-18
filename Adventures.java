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
   
   
   private int hp =3;
   private int treasure = 0;
   
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

   public void set_treasure()
   {
      treasure++;
   }

   public int get_roll()
   {
      MoveSet roll = new MoveSet();
      return roll.dice();
   }
   
} 