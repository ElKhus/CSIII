import mayflower.*;
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog extends Actor
{
    // instance variables - replace the example below with your own
    private Picture [] frames; 
    private int currentFrame;
    private Timer animationTimer;
    /**
     * Constructor for objects of class Dog
     */
    public Dog()
    {
        Picture p = new Picture("img/dog/Jump (1).png");
        int currentframe = 0;
        setPicture(p);
        frames = new Picture [8];
        animationTimer= new Timer();
        for( int i= 0; i<8;i++)
        {
            frames [i] = new Picture ("img/dog/Jump ("+ (i+1) + ").png");
            frames[i].resize(100,87);
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void update()
    {
        if( animationTimer.hasTimePassed(70))
        {
            animationTimer.reset();
            currentFrame= (currentFrame % frames.length);
            setPicture (frames [currentFrame]);
            currentFrame++;
         }
    }
}
