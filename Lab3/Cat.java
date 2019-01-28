/**
 * @(#)Cat.java
 *
 *  Lab 3 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends Actor 
{
    private Picture [] frames; 
    private int currentFrame;
    private Timer animationTimer;
    public Cat() 
    {
        //Create a Picture object from the specified image file
        Picture p = new Picture("img/cat/Walk (1).png");
        int currentframe = 0;
        //Set this Actor's image to the Picture object p
        setPicture(p);
        frames = new Picture [10];
        animationTimer= new Timer();
        for( int i= 0; i<10;i++)
        {
            frames [i] = new Picture ("img/cat/Walk ("+ (i+1) + ").png");
            frames[i].resize(100,87);
        }
    }
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