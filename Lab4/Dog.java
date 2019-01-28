
/**
 * Write a description of class dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog extends AnimatedActor
{
    private Animation walk;
    /**
     * Constructor for objects of class dog
     */
    public Dog()
    {
        String [] walkie=new String [10];
        String s = new String("img/dog/Walk (1).png");
        setPicture(s);
        
        for(int i=0;i<10;i++)
        {
            walkie[i]=new String ("img/dog/Walk ("+(i+1)+").png");
            
        }
        walk= new Animation (50, walkie);
        walk.resize(100,87);
        setAnimation(walk);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void update()
    {
        super.update();
    }
}
