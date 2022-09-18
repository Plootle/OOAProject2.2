import java.util.Random;

public class MoveSet {
    /*
     * Based on our UML this will bet where we traverse the map, take fights, find treasure,  and decide outcomes
     * 
     */


    // int get_location;
    // int set_location;

    //roll two 6 sided dice to determine damage
    //roll two 6 sided dice to find treasure (10 or higher)
    public int dice()
    {
        int dice = 0;
        int answer = 0;
        Random rn = new Random();

        for(int i = 0; i < 2; i++)
        {
            answer = rn.nextInt(6) + 1;
            dice += answer;
        }
        return dice;
    }

    public void fight( Creatures c, Adventures a)
    {
        // get dice roll for creature and adventurer and compare
        // maybe here we check if sneaker to avoid the fight?!?!?
    }

    public void traverse(Adventures a)
    {
        // this might get reworked. essentially this will either be what does ALL movement or have overload calls for creatures since they all move differently
    }

    public void treasure(Adventures a)
    {
        // Cake
    }

}
