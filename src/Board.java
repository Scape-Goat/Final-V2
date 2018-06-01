import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Board extends JPanel implements ActionListener {

    Map map;
    Timer timer;
    public Board() {
        setPreferredSize(new Dimension(600, 600));
        setBackground(Color.black);
        timer = new Timer(1000/60, this);
        map = new Map();
        map.update();
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);

        if(STATS.isEnd()){

        }
        else if(STATS.isMenu()){
            g.setColor(Color.WHITE);
            printSimpleString("Press Enter", getWidth(), 0, getHeight()/2, g);
        }
        else{
            map.paint(g);
        }
    }


    public void actionPerformed(ActionEvent e) {
        map.move();
        repaint();
    }
    private void printRainbowString(String s, int width, int XPos, int YPos, Graphics g2d){

        Color red = new Color(255,80,80);
        Color magenta = new Color(255, 0, 255);
        Color purple = new Color(153, 102, 255);
        Color blue = new Color(51, 102, 255);
        Color turquoise = new Color(0, 255, 153);
        Color green = new Color(51, 204, 51);
        Color yellow = new Color(255, 255, 0);
        Color orange = new Color(255, 153, 51);
        Color[] colors = {red, magenta, purple, blue, turquoise, green, yellow, orange};

        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;

        String[] letters = new String[s.length()];
        for(int i = 0; i<letters.length; i++)
            letters[i] = s.substring(i,i+1);
        for(int i = 0; i<letters.length; i++) {
            g2d.setColor(colors[i%colors.length]);
            g2d.drawString(letters[i], start + XPos + (int) g2d.getFontMetrics().getStringBounds(s.substring(0, i), g2d).getWidth(), YPos  + (int)(g2d.getFontMetrics().getStringBounds(s, g2d).getHeight()/4));
        }
//

    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }


}