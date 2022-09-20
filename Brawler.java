public class Brawler extends Adventures {
    
    public String getName()
    {
        return "Brawler";
    }

    // Brawler gets +2 on dice rolls
    public int fight_roll(){
        MoveSet roll = new MoveSet();
        return roll.dice()+2;
    }
}
