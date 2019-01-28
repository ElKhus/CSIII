/**
 * @(#)Dog.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Dog extends Actor {

    public Dog() {
    	setPicture("img/dog.png");
    }
    
    public void update()
    {
    	Actor[] touching= getTouching();
    	for ( Actor a : touching)
    	{
    	    if(a instanceof Cat)
    	    {
    	        Cat c = (Cat) a;
    	        Stage s = getStage();
    	        c.setPosition(400, 300);
    	        c.decreaseLives(1);
    	    }
    	}
    }
    
}