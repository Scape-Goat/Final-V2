import java.awt.*;

public class Tile implements Move,Paint {
    int x,y,width=150,height=30;
    public Tile(int row, int column){
        x=(column*width)+285;
        y=(row*height)+285;
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,width,height);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x,y,width,height);
        g.setColor(Color.white);
        g.drawRect(x,y,width,height);
    }

    public void move(Player player){
        x -= player.getDx();
        y -= player.getDy();
    }
}
