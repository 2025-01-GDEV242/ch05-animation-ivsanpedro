import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Class BoxBall - a graphical ball that rebounds from four walls of its containing box. The ball has the ability to move. 
 * Details of movement are determined by the ball itself.
 *
 * This movement can be initiated by repeated calls to the "move" method.
 * 
 * @author Michael Kölling (mik)
 * @author David J. Barnes
 * @author Bruce Quig
 *
 * @version 2016.02.29
 */

public class BoxBall
{
    //private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    //private final int bottom = 450;      // y position of ground
    private int bottom;
    private int top;
    private int left;
    private int right;
    private Canvas canvas;
    
    private int ySpeed;                // initial downward speed, set by the constructor
    private int xSpeed;                //set by the constructor

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param bottomWall  the position of the bottom (where the wall will bounce)
     * @param topWall  the position of the top wall (where the wall will bounce)
     * @param rightWall  the position of the right (where the wall will bounce)
     * @param leftWall  the position of the left (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int bottomWall, int topWall, int rightWall, int leftWall,  int vSpeed, int hSpeed, Canvas drawingCanvas)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        bottom = bottomWall;
        top = topWall;
        right = rightWall;
        left = leftWall;
        canvas = drawingCanvas;
        xSpeed = hSpeed;
        ySpeed = vSpeed;
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /** 
     * this is where the ball needs to check for bouncing
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        yPosition += ySpeed;
        xPosition +=2;
        
        //This is where you update position based on xSpeed and ySpeed

        // check if it has hit the ground
        if (yPosition >= (bottom - diameter) && ySpeed > 0) {
            yPosition = (int)(bottom - diameter);
            ySpeed = -ySpeed; 
        }
        //check if hits the top
        if (yPosition <= (top - diameter) && ySpeed > 0) {
            yPosition = (int)(top - diameter);
            ySpeed += ySpeed; 
        }
        //check if it hits the right wall
        if (xPosition >= (right + diameter) && xSpeed > 0) {
            xPosition = (int)(right + diameter);
            xSpeed = -xSpeed; 
        }
        //check if it hits the left wall
        if (xPosition <= (left + diameter) && ySpeed > 0) {
            xPosition = (int)(left + diameter);
            xSpeed = -xSpeed; 
        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}

