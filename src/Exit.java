import java.awt.*;

public class Exit extends Tile {
    public Exit(int row, int col){
        super(row, col);
       // x += (width/2)-15;
        //width = 30;
        //height = 30;
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x,y,width,height);
    }
}
