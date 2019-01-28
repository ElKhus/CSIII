import mayflower.*;

public class PieceActor extends Actor
{
    //INSTANCE VARIABLES
    private TicTacToe now;
    private int roast;//then
    private int cappu;//there

    //CONSTRUCTOR
    public PieceActor(TicTacToe game, int row, int col) 
    {
        //Initialize instance variables here
        now = game;
        roast = row;
        cappu = col;

        //Set this Actor's image. Blank pieces should display the empty.png image!
        setPicture("image/empty.png");
    }

    //METHODS
    /*
     *  Checks if this piece is clicked using the isClicked() method
     *  If it is clicked then:
     *      1. Check if the game is over. No pieces can be played if the game is over.
     *      1. Check if this is an empty piece. Pieces cannot be played on top of other pieces.
     *      2. Make this PieceActor display the current player's piece.
     *      3. Tell the game to put the current player's piece in the correct row,col using the addPiece() method.
     *      3. Tell the game it is the next player's turn using the nextPlayer() method.
     */
    public void update()
    {
        if(isClicked())
        {
            if(!now.isGameOver() && now.getPiece(roast,cappu) == null)
            {
                setPicture((now.getCurrentPlayer()== TicTacToePiece.X)?"img/x.png":"img/o.png");
                now.addPiece(roast,cappu);
                if(!now.isGameOver())
                {
                    now.nextPlayer();
                }
                
                // if(now.getCurrentPlayer() == TicTacToePiece.X)
                // {
                    // setPicture("img/x.png");
                // }
                // else if(now.getCurrentPlayer() == TicTacToePiece.O)
                // {
                    // setPicture("img/o.png");
                // }
                // now.addPiece(roast,cappu);
                // now.nextPlayer();
            }
        }
    }
}