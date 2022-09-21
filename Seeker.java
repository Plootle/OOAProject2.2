import java.util.ArrayList;

public class Seeker extends Creatures {
    // seek to move into adjacent room of adventurers
    // will not move if adventurer is in adjacent room or in same room
    
    public String getName()
    {
        return "Seeker";
    }

    private int move[];

    // Move into adjacent room of adventurers
    public int[] special_move(int[] loc, ArrayList<Adventures> adventures)
    {   
        Adventures a =new Adventures();
        int north[] = {loc[0], loc[1] -1, loc[2]};
        int south[] = {loc[0], loc[1] +1, loc[2]};
        int west[] = {loc[0], loc[1], loc[2] -1};
        int east[] = {loc[0], loc[1], loc[2] +1};
        
        int[] adv_loc = a.get_location();
       
        for(int i = 0; i < adventures.size(); i++)
        {
            a = adventures.get(i);
            adv_loc = a.get_location();
            
            if(north[0] == adv_loc[0] && north[1] == adv_loc[1] && north[2] == adv_loc[2])
            {
                //System.out.println("Seeker Moved North");
                move = adv_loc;
                return move;
            }
            if(east[0] == adv_loc[0] && east[1] == adv_loc[1] && east[2] == adv_loc[2])
            {
                //System.out.println("Seeker Moved East");
                move = adv_loc;
                return move;
            }
            if(south[0] == adv_loc[0] && south[1] == adv_loc[1] && south[2] == adv_loc[2])
            {
                //System.out.println("Seeker Moved South");
                move = adv_loc;
                return move;
            }
            if(west[0] == adv_loc[0] && west[1] == adv_loc[1] && west[2] == adv_loc[2])
            {
                //System.out.println("Seeker Moved West");
                move = adv_loc;
                return move;
            }    
        }   
        // System.out.println("Seeker DID NOT MOVE");
        return loc;
    }
}
