import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class Ball {
    private int size;
    private Color color;
    private int speedX, speedY;
    private int x, y;

    public Ball(int x, int y){
        this.x = x; this.y = y; size = 10; speedX = 5; speedY = 5; color = Color.BLUE;
    }

    public Ball(){
         size = randomInt(10,50); this.x = randomInt(0,450-size); this.y = randomInt(0,450-size); speedX = randomInt(-10,10); speedY = randomInt(-10,10); color = new Color(randomInt(0,255),randomInt(0,255),randomInt(0,255));
    }

    public void drawBall(Graphics g, MyPanel thing){
        g.setColor(color);
        g.fillOval(x,y,size,size);
        x += speedX;
        y += speedY;
        if (y+size>thing.getHeight()) {
            speedY = randomInt(-10,-1);
            speedX = randomInt(-10,10);
        }
        if (x+size>thing.getWidth()){
            speedX = randomInt(-10,-1);
            speedY = randomInt(-10,10);
        }
        if (y<0){
            speedY = randomInt(1,10);
            speedX = randomInt(-10,10);
        }
        if (x<0){
            speedX = randomInt(1,10);
            speedY = randomInt(-10,10);
        }
    }

//    public void move(){
//        x += speedX;
//        y += speedY;
//        if (y+20>thing.getHeight()) speedY *=-1;
//        if (x>thing.getWidth()) speedX *=-1;
//        if (y<0) speedY *=-1;
//        if (x+20<0) speedX *=-1;
//    }
    public static void bounceBalls(Ball[] ballsToCheck){
        for (Ball hi: ballsToCheck)
            for (Ball bye: ballsToCheck){
                if (hi!=bye){
                    // check all corners
                    // top left
//                    if(checkTopLeft(hi, bye));
                }
            }
    }

    private static void checkTopLeft(Ball ball1, Ball ball2){
//        if (ball1.x + ball1.size <= ball2.x - ball2.size <= ball1.x + ball1.x - ball1.size)
    }

    private static int randomInt(int num1, int num2) {
        int x = num1;
        int y = num2;
        if (x > y) {
            int r = (x - y) + 1;
            return (int) (Math.random() * r) + y;
        }
        int r = (y - x) + 1;
        return (int) (Math.random() * r) + x;
    }

}