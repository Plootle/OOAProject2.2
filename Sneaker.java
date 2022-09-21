import java.util.Random;

public class Sneaker extends Adventures {
    // gets a 50% chance to avoid fighting
    public String getName()
    {
        return "Sneaker";
    }

    public int dodge()
    {
        Random rn = new Random();
        return rn.nextInt(2);
    }
}
