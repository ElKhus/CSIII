import mayflower.*;
/**
 * Write a description of class PieceActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PieceActor extends Actor
{
    // instance variables - replace the example below with your own
    private Game curr;
    private int roww;
    private int coll;

    /**
     * Constructor for objects of class PieceActor
     */
    public PieceActor(Game game, int row, int col)
    {
        // initialise instance variables
        curr= game;
        roww= row;
        coll= col;
        setPicture("image/empty.png");
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void update()
    {
        
    }
}
