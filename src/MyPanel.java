import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private int xLoc = 0; private int yLoc = 0;
    private int xVel = 2; private int yVel = 2;
    private Ball[] myBalls;
    private boolean rightX = true; private boolean rightY = true;
    public MyPanel(){
        setBackground(Color.GREEN);
        myBalls = new Ball[5];
        for (int i = 0; i<myBalls.length; i++) {
            myBalls[i] = new Ball();
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
//        System.out.println("Hi");
        for (Ball hi: myBalls) {
            hi.drawBall(g,this);
//
        }
       Ball.bounceBalls(myBalls);
//        g.setColor(Color.RED);
//        g.fillOval(xLoc,yLoc,20,20);
//        xLoc += xVel;
//        yLoc += yVel;
//        if (yLoc+20>getHeight()) yVel *=-1;
//        if (xLoc>getWidth()) xVel *=-1;
//        if (yLoc<0) yVel *=-1;
//        if (xLoc+20<0) xVel *=-1;

        g.setColor(Color.RED);
//
//        g.fill3DRect(50, 50, 250, 250, false);
        try {
            Thread.sleep(5);
        }
        catch (Exception e){
            System.out.println(e);
        }
        repaint();
    }
}
