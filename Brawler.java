public class Brawler extends Adventures {
    // Brawler gets +2 on dice rolls
    public int fight_roll(){
        MoveSet roll = new MoveSet();
        return roll.dice()+2;
    }
}
