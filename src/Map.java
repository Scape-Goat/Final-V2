import java.awt.*;

public class Map {
    int[][] setup = {
            {0,1,1,1,1,1,1},
            {2,2,2,2,2,2,2}
    };
    Tile[][] map = new Tile[setup.length][setup[0].length];

    public void update(){
        int spawnRow = -1;
        for(int row = 0; row<setup.length; row++) {
            for (int col = 0; col < setup[row].length; col++) {
                if(setup[row][col]==0){
                    spawnRow = -row;
                }
            }
        }


        for(int row = 0; row<setup.length; row++){
            for(int col = 0; col<setup[row].length; col++){
                Tile currentTile = null;
                switch(setup[row][col]){
                    case 0:  currentTile = new Player(spawnRow,col ); break;
                    case 1: currentTile = null; break;
                    case 2: currentTile = new Tile(spawnRow,col); break;
                    case 9: currentTile = new Tile(spawnRow,col); break;
                }
                map[row][col] = currentTile;
            }
            spawnRow++;
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


}
