 /**
 * @(#)Cat.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends Actor {
    private int score;
    private int life;
    public Cat() {
    	setPicture("img/cat.png");
    	score= 0;
    	life = 3;
    }
    public void update()
    {
    	Keyboard kb = getKeyboard();
    	
    	int x = getX();
    	int y = getY();
    	int w = getWidth();
    	int h = getHeight();
    	
    	int leftEdge = w / 2;
    	int topEdge = h / 2;
    	int rightEdge = 800 - w / 2;
    	int bottomEdge = 600 - h / 2 - 28;
    	//System.out.println (score);
    	if(kb.isKeyPressed("up") && y > topEdge)
    	{
    		move(10, "North");
    	}
    	if(kb.isKeyPressed("down") && y < bottomEdge)
    	{
    		move(10, "South");
    	}
    	if(kb.isKeyPressed("left") && x > leftEdge)
    	{
    		move(10, "West");
    	}
    	if(kb.isKeyPressed("right") && x < rightEdge)
    	{
    		move(10, "East");
    	}
    }
    public void increaseScore (int amount)
    {
        score= score+amount;
    }
    public int getScore()
    {
     return score;   
    }
    public void decreaseLives (int count)
    {
        life = life-count;
        if (life == 0)
        {
            Stage s = getStage();
    	    s.removeActor ( this);
        }
    }
    public int getLife()
    {
     return life;   
    }
}
