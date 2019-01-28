/**
 * @(#)Cat.java
 *
 *  Lab 4 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends AnimatedActor 
{
    private Animation walk;
    
    public Cat() 
    {
        String [] walkie=new String [10];
        String s = new String("img/cat/Walk (1).png");
        setPicture(s);
        
        for(int i=0;i<10;i++)
        {
            walkie[i]=new String ("img/cat/Walk ("+(i+1)+").png");
            
        }
        walk= new Animation (50, walkie);
        walk.resize(100,87);
        walk.setTransparency(50);
        setAnimation(walk);
    }
    
    public void update()
    {
        super.update();
        
    }
    
    
}