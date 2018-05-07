import java.awt.*;

public class Saw extends Tile  {
    int drawX, drawY, xCenter, yCenter, speed = 0, orbitWidth = 0, orbitHeight = 0;
    float angle = 0;
    public Saw(int row, int column){
        super(row, column);
        x+=(width/2);
        y+=(height/2)+15;

        width = 30;
        height = 30;
    }

    public Saw(int row, int column, int speed, int orbitWidth, int orbitHeight, float startAngle){
        super(row, column);
        x+=(width/2);
        y+=(height/2)+15;
        width = 30;
        height = 30;
        xCenter = x;
        yCenter = y;
        this.speed = speed;
        this.orbitWidth = orbitWidth;
        this.orbitHeight = orbitHeight;
        angle = startAngle;
    }

    public void move(Player player){
        x-=player.getDx();
        y-=player.getDy();
        angle +=speed;
        drawX = (int) (orbitWidth * Math.sin(Math.toRadians( angle)))+x;
        drawY = (int) (orbitHeight *Math.cos(Math.toRadians( angle)))+y;
    }

    public void paint(Graphics g){
        g.setColor(Color.cyan);g.fillOval(drawX-width/2,drawY-height/2,width,height);
    }
}
