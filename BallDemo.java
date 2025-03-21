import java.awt.Color;
import java.util.Random;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * @param numOfBalls number of balls to set bouncing in a box in the middle of the canvas
     */
    public void boxBounce(int numOfBalls){
        //set up the four walls as integer
        int top = 50; //draw top
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, top, 550, top);
        int bottom = 450; //draw bottom
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, bottom, 550, bottom);
        int right = 550; //draw right
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(right, 50, right, 450);
        int left = 50; //draw left
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(left, 50, left, 450);
        
        //create ball
        Random random = new Random ();
        // int height = random.nextInt(401)+50;
        // int width = random.nextInt(501)+50;
    
        
        // int height = random.nextInt(401)+50;
        // int width = random.nextInt(501)+50;
        // int speed = random.nextInt(16);
        // int speed2 = random.nextInt(16);
        //BoxBall ball = new BoxBall(width, height, 16, Color.BLUE, 450, 50, 550, 50, speed, speed2, myCanvas);
        //ball.draw();
        
        // while (true) {
            // myCanvas.wait(50);           // small delay
            // ball.move();
        // }
         
        BoxBall[] ball = new BoxBall[numOfBalls];
        for (int i=0; i<ball.length; i++){
            int height = random.nextInt(401)+50;
            int width = random.nextInt(501)+50;
            int speed = random.nextInt(16);
            int speed2 = random.nextInt(16);
            ball[i] = new BoxBall(width, height, 16, Color.BLUE, 450, 50, 550, 50, speed, speed2, myCanvas);
            ball[i].draw();
            ball[i].move();
        }
        // for (BoxBall b : ball) {
            // b.draw();
            // b.move();
        // }
        
    }
    
}
