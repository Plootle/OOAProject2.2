public class Room {
    // The Facility’s center Rooms are labeled 0-1-1, 1-1-1, 2-1-1, 3-1-1, and 4-1-1  

    public int[][] room1(){
        int room1[][] = {
            {1,0,0}, {1,0,1}, {1,0,2},      // 0 1 2        0 -> 1,0,0
            {1,1,0}, {1,1,1}, {1,1,2},      // 3 4 5        4 -> 1,1,1
            {1,2,0}, {1,2,1}, {1,2,2}};     // 6 7 8        7 -> 1,2,1
        return room1;
    }
    public int[][] room2(){
        int room2[][] = {
            {2,0,0}, {2,0,1}, {2,0,2},      
            {2,1,0}, {2,1,1}, {2,1,2},
            {2,2,0}, {2,2,1}, {2,2,2}};
        return room2;
    }

    public int[][] room3(){
        int room3[][] = {
            {3,0,0}, {3,0,1}, {3,0,2},
            {3,1,0}, {3,1,1}, {3,1,2},
            {3,2,0}, {3,2,1}, {3,2,2}};
        return room3;
    }

    public int[][] room4(){
        int room4[][] = {
            {4,0,0}, {4,0,1}, {4,0,2},
            {4,1,0}, {4,1,1}, {4,1,2},
            {4,2,0}, {4,2,1}, {4,2,2}};
        return room4;
    }    
}

//need to print out the rooms (Display everything?)