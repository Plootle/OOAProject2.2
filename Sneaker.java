import java.util.Random;

public class Sneaker extends Adventures {
    // gets a 50% chance to avoid fighting
    public String getName()
    {
        return "Sneaker";
    }

    // function for giving Sneaker a chance to avoid a fight.
    public int dodge()
    {
        Random rn = new Random();
        return rn.nextInt(2);
    }
}
