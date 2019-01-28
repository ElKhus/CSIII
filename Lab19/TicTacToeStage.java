import mayflower.*;
import java.awt.Color;

//Find the Mayflower documentation here: http://mrmaycs.com/mayflower/

public class TicTacToeStage extends Stage
{
    //INSTANCE VARIABLES
    private TicTacToe game;
    private Text now;
    private Text then;
    //CONSTRUCTOR
    public TicTacToeStage() 
    {
        setBackground("img/background.png");
        
        game = new TicTacToe();
        now = new Text("Tic Tac Toe", Color.WHITE);
        addActor(now, 0, 0);
        //Add a label to the top of the screen that displays the name of the game
        then = new Text("", Color.WHITE);
        
        addActor(then, 0, 25);
        
        //TODO: Add a "blank" PieceActor to each of the 9 spots of the TicTacToe board
        //      Each PieceActor needs a reference to the TicTacToe object
        for (int i=0; i<3 ; i++)
        {
            for (int r= 0 ; r<3 ; r++)
            {
                addActor(new PieceActor (game,i, r),150+ 105*i, 150+r*105);
            }
        }
    }
    
    //METHODS
    /*
     *  Check if the game is over
     *      If the game is over, display the text "Game Over!" on the screen
     *      If there is a winner, display the text "X wins!" or "O wins!" on the screen
     *      If there is not a winner, display the text "Tie Game!" on the screen
     *  If the game is NOT over
     *      Display the current player's turn on the screen: "It is X's turn" or "It is O's turn"
     */
    public void update()
    {
        if(game.isGameOver())
        {   
            now.setText("Game Over");
            if(game.getWinner() != null)
            {
                then.setText(game.getWinner().name() + "wins!");
            }
        }
        else
        {
            then.setText(game.getCurrentPlayer().name() + "'s turn");
        }
    }
}