import java.awt.*;

public class Map {
    int[][] setup = {
            {1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1},
            {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2}


    };
    Tile[][] map = new Tile[setup.length][setup[0].length];
    Player player;

    public void update(){
        int spawnRow = -1;
        int spawnCol = -1;
        for(int row = 0; row<setup.length; row++) {
            for (int col = 0; col < setup[row].length; col++) {
                if(setup[row][col]==0){
                    spawnRow = -row;
                    spawnCol = -col;
                }
            }
        }


        for(int row = 0; row<setup.length; row++){
            int currentCol = spawnCol;
            for(int col = 0; col<setup[row].length; col++){
                Tile currentTile = null;
                switch(setup[row][col]){
                    case 0:  player = new Player(spawnRow,currentCol ); currentTile = player; break;
                    case 1: currentTile = null; break;
                    case 2: currentTile = new Tile(spawnRow,currentCol); break;
                    case 9: currentTile = new Exit(spawnRow,currentCol); break;
                }
                map[row][col] = currentTile;
                currentCol++;
            }
            spawnRow++;
        }
    }

    public void move(){
        player.move();
        for(int row = 0; row<setup.length; row++){
            for(int col = 0; col<setup[row].length; col++){
                if(!( map[row][col] instanceof Player) &&  map[row][col] != null){
                    map[row][col].move(player);
                }
            }
        }

    }

    public void paint(Graphics g){
        for(int row = 0; row<setup.length; row++) {
            for (int col = 0; col < setup[row].length; col++) {
                if(map[row][col] != null)
                map[row][col].paint(g);
            }
        }
    }

    /*
        {0,1,1,1,1,1,9},
        {2,2,2,2,2,2,2}

        {0,1,1,1,1,1,9},
        {2,1,2,1,2,1,2}


        {2,2,2,2,2,2,2},
        {2,0,1,1,1,1,2},
        {2,2,2,2,2,1,2},
        {2,1,1,1,1,1,2},
        {2,1,2,2,2,2,2},
        {2,1,1,1,1,9,2},
        {2,2,2,2,2,2,2},
     */


}
