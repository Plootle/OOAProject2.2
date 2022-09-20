public class Thief extends Adventures {
    // gets +1 to finding treasure and +1 to fighting

    public String getName()
    {
        return "Thief";
    }

    public int get_roll()
    {
        MoveSet roll = new MoveSet();
        return roll.dice()+1;
    }
}
