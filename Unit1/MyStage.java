import mayflower.*;
/**
 * Write a description of class MyStage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStage extends Stage
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class MyStage
     */
    public MyStage() 
    {
        // initialise instance variables
        setBackground("img/bluebonnets.jpg");
        Cat a = new Cat();
        addActor(a, 400, 300);
        Dog b = new Dog();
        addActor(b, 200, 150);
        Yarn c = new Yarn();
        addActor(c,600, 150);
        Yarn d = new Yarn();
        addActor(d, 200, 450);
        Yarn e = new Yarn();
        addActor(e,600, 450);
    }

    public void update()
    {
        
    }
}
