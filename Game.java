public class Game {
    public static void main(String args[])
    {
        int tWin=0;
        int aWin=0;
        int cWin=0;
        Engine game = new Engine();
        for(int i = 1; i <= 30; i ++)
        {
            
            System.out.println("Game: " + i);
            int run = game.Engine1();
            if(run ==1)
                tWin++;
            if(run == 2)
                aWin++;
            if(run == 3)
                cWin++;
        }
        System.out.println("Summary: ");
        System.out.println("Times all treasure was found: " + tWin);
        System.out.println("Times all adventurers died: " + aWin);
        System.out.println("Times all creatures died: " + cWin);
    } 
}