import java.awt.*;

public class Player extends Tile {
    public Player(int row, int col){
        super(row, col);

        width = 30;
        height = 30;
    }

    public void paint(Graphics g){
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,width,height);
    }
}
