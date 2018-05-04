import java.awt.*;

public class Player extends Tile {
    int dy = 0, dx = 0, spawnX, spawnY;
    public Player(int row, int col){
        super(row, col);
        spawnX = x;
        spawnY = y;
        //width = 30;
        //height = 30;
    }

    public void move(){
        if(Game.isUp()){
            dy = -5;
        }
        else if(Game.isDown()){
            dy = 5;
        }
        else{
            dy=0;
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
        g.fillRect(spawnX,spawnY,width,height);
    }

    public int getDy() {
        return dy;
    }

    public int getDx() {
        return dx;
    }
}
