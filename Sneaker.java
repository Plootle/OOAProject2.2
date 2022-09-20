import java.util.Random;

public class Sneaker extends Adventures {
    // gets a 50% chance to avoid fighting

    public int dodge()
    {
        Random rn = new Random();
        return rn.nextInt(2)+1;
    }

    public String getName()
    {
        return "Sneaker";
    }
}
