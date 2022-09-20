public class Seeker extends Creatures {
    // seek to move into adjacent room of adventurers
    // will not move if adventurer is in adjacent room or in same room
    public String getName()
    {
        return "Seeker";
    }

    //might actually go in the engine? 
    //if name == seeker
    //move only if an adjacent room has an adventurer
    //compare adventurer loaction with creature location and its adjacent rooms
    //(or flip) compare creature and its adj rooms to adventurer on its turn
}
