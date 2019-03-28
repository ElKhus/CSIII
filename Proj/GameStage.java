import mayflower.*;
import java.awt.Color;

/**
 * Write a description of class GameStage here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameStage
{
    // instance variables - replace the example below with your own
    private Game game;
    private Text current;
    private Text isOver;
    /**
     * Constructor for objects of class GameStage
     */
    public GameStage()
    {
        setBackground("img/Background.png");
        
        game= new Game();
        current= new Text("2048", Color.BLACK);
        addActor(current,0,0);
        isOver = new Text("", Color.BLACK);
        addActor(isOver, 0, 25);
        for(int i=0; i<4;i++)
        {
            for(int j=0; j<4;j++)
            {
                addActor(new PieceActor(game,i,j), 150+105*i, 150+j*105);
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void update()
    {
        if(game.isGameOver())
        {
            isOver.setText("Game Over!");
        }
    }
}
