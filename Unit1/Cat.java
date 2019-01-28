import mayflower.*;
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Cat
     */
    public Cat()
    {
        setPicture("img/cat.png");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void update()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        int xw = x+ w/2;
        int xwL = x- w/2;
        int yh = y+ h/2;
        int yhD = y - h/2;
        Keyboard kb = getKeyboard();
        System.out.println("yh = "+yh+" yhD = "+ yhD);
        if( kb.isKeyPressed("up")&& yhD > 0)
        {
            move(5,"North");
        }
        if( kb.isKeyPressed("down")&& yh < 570)
        {
            move(5,"South");
        }
        if( kb.isKeyPressed("left")&& xwL > 0)
        {
            move(5,"West");
        }
        if( kb.isKeyPressed("right")&& xw < 800)
        {
            move(5,"East");
        }
    }
}
