import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class Ball {
    private int size;
    private Color color;
    private int speedX, speedY;
    private int x, y;
    private boolean alreadyBounced = false;

    public Ball(int x, int y){
        this.x = x; this.y = y; size = 10; speedX = 5; speedY = 5; color = Color.BLUE; alreadyBounced = false;
    }

    public Ball(){
         size = randomInt(10,50); this.x = randomInt(0,450-size); this.y = randomInt(0,450-size); color = new Color(randomInt(0,255),randomInt(0,255),randomInt(0,255)); alreadyBounced = false;
         do{
             speedX = randomInt(-10,10);
         }while (speedX == 0);
         do{
            speedY = randomInt(-10,10);
         }while (speedY == 0);

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

   // public void move(){
   //     x += speedX;
   //     y += speedY;
   //     if (y+20>thing.getHeight()) speedY *=-1;
   //     if (x>thing.getWidth()) speedX *=-1;
   //     if (y<0) speedY *=-1;
   //     if (x+20<0) speedX *=-1;
   // }
  public void swapXSpeed(){
    speedX *=-1;
  }
  public void swapYSpeed(){
    speedY *=-1;
  }


  public void setXSpeed(int newSpeed){
        speedX = newSpeed;
  }
    public void setYSpeed(int newSpeed){
        speedY = newSpeed;
    }
    public int getSpeedX(){return speedX;} public int getSpeedY(){return speedY;}

//    private static boolean collides(int p1, int p2, int check){
//        return p1<=check && check<=p2;
//    }

    private int getCenterX(){
        return x+(size/2);
    }
    private int getCenterY(){
        return y+(size/2);
    }

    public static void bounceBalls(Ball[] ballsToCheck){
        for (Ball hi: ballsToCheck)
            for (Ball bye: ballsToCheck){
                if (!hi.equals(bye)){
                  // check the distance between the points
                  int distance = (int)Math.sqrt(Math.pow(hi.getCenterX() - bye.getCenterX(), 2)+(Math.pow(hi.getCenterY() - bye.getCenterY(), 2)));
                  if (distance<=(hi.getSize()+bye.getSize())/2){
                    // set the speed of the ball based on the direction the other ball is in. this is to prevent infinite bouncing possibly
                    if (hi.getCenterX()<bye.getCenterX()){
                      hi.setXSpeed(Math.abs(hi.getSpeedX())*-1);
                    }else{
                      hi.setXSpeed(Math.abs(hi.getSpeedX()));
                    }
                    
                    if (hi.getCenterY()<bye.getCenterY()){
                      hi.setYSpeed(Math.abs(hi.getSpeedY())*-1);
                    }else{
                      hi.setYSpeed(Math.abs(hi.getSpeedY()));
                    }
                  }
//                    if (collides(bye.getLeftX(), bye.getRightX(), hi.getLeftX())){
//                      if (collides(bye.getTopY(), bye.getBottomY(), hi.getTopY())){
//                          hi.swapXSpeed();
//                          hi.swapYSpeed();
//                      }else if(collides(bye.getTopY(), bye.getBottomY(), hi.getBottomY())){
//                          hi.swapXSpeed();
//                          hi.swapYSpeed();
//                      }
//                      }else if (collides(bye.getLeftX(), bye.getRightX(), hi.getRightX())){
//                        if (collides(bye.getTopY(), bye.getBottomY(), hi.getTopY())){
//                            hi.swapXSpeed();
//                            hi.swapYSpeed();
//                        }else if(collides(bye.getTopY(), bye.getBottomY(), hi.getBottomY())){
//                            hi.swapXSpeed();
//                            hi.swapYSpeed();
//                        }
//
//                      }
                    }
                }
            }

    public int getLeftX(){
       return x;
    }
    public int getRightX(){
      return x + size;
    }
    public int getTopY(){
      return y;
    }
  public int getBottomY(){
    return y + size;
  }
  public int getSize(){
    return size;
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
