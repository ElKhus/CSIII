/**
 * @(#)Cat.java
 *
 *	Lab 5 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends MovableAnimatedActor 
{
	Animation walk;
	
    public Cat() 
    {
    	walk = new Animation(50, new String[] {
    		"img/cat/Walk (1).png",
    		"img/cat/Walk (2).png",
    		"img/cat/Walk (3).png",
    		"img/cat/Walk (4).png",
    		"img/cat/Walk (5).png",
    		"img/cat/Walk (6).png",
    		"img/cat/Walk (7).png",
    		"img/cat/Walk (8).png",
    		"img/cat/Walk (9).png",
    		"img/cat/Walk (10).png"
    	});
    	walk.resize(100, 87);
    	setAnimation(walk);
    }
    
    public void update()
    {
    	super.update();
    }
    
    
}