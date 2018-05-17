import java.awt.*;

public class Player extends Tile {
    int dy = 0, dx = 0, spawnX, spawnY;
    boolean canJump = true, jumping = false, falling = false;
    public Player(int row, int col){
        super(row, col);
        spawnX = x;
        spawnY = y;
        width = 30;
        height = 30;
    }

    public void move(Tile[][] map){
        Tile[] tiles = new Tile[map.length*map[0].length];
        int count = 0;
        for(Tile[] row: map) {
            for (Tile tile : row) {
                tiles[count] = tile;
                count++;
            }
        }
        for(Tile tile: tiles) {
            if (tile != null && !(tile instanceof Player))
                if (tile.getBounds().intersects(getBounds())) {
                    falling = false;
                    break;
                } else {
                    falling = true;
                }
        }

        if(Game.isJumping() && canJump){
            canJump = false;
            jumping = true;
            dy = -20;
        }
        else if(jumping){
            dy+=1;
            for(Tile[] row: map)
                for(Tile tile: row)
                    if(tile!=null && !(tile instanceof Player))
                        if(tile.getBounds().intersects(getBounds())){
                          jumping = false;
                          canJump = true;
                          break;
                        }
        }
        else if(falling) {
            dy += 1;
            System.out.println(dy);
        }
        else{
            dy = -1;
        }

        if(Game.isLeft()){
            dx = -5;
        }
        else if(Game.isRight()){
            dx = 5;
        }
        else{
            dx=0;
        }
        spawnY -= dy;
        spawnX -= dx;
    }

    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,width,height);
        g.drawRect(spawnX,spawnY,width,height);
    }

    public int getDy() {
        return dy;
    }

    public int getDx() {
        return dx;
    }
}
