/**
 * @(#)MyStage.java
 *
 *	Lab 2 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;


public class MyStage extends Stage {
    private Cat cat;
    private Text scoreText;
    private Text lifeText;
    public MyStage() 
    {
    	setBackground("img/bluebonnets.jpg");
    	
    	cat= new Cat();
    	addActor(cat, 400, 300);
    	
    	Dog d = new Dog();
    	addActor(d, 200, 150);
    	
    	Yarn y1 = new Yarn();
    	addActor(y1, 600, 150);
    	
    	Yarn y2 = new Yarn();
    	addActor(y2, 200, 450);
    	
    	Yarn y3 = new Yarn();
    	addActor(y3, 600, 450);
    	
    	scoreText = new Text ("Score: ?");
    	addActor (scoreText, 0, 0);
    	
    	lifeText = new Text ("Lives: ?");
    	addActor (lifeText, 0 , 20);
    }
    
    public void update()
    {
        scoreText.setText ("score: " + cat.getScore());
        lifeText.setText ("Lives: " + cat.getLife());
    }
    
}