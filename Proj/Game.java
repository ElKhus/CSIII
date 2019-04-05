
/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game implements IGame
{
    // instance variables - replace the example below with your own
    private Piece board[][];
    private Piece currentPlayer;
    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        // initialise instance variables
        board = new Piece [4][4];
        currentPlayer = Piece.one;
    }

    public Piece getCurrentPlayer()
    {
        return currentPlayer;
    }
    public boolean addPiece(int row, int col)
    {
        if(board[row][col] ==null)
        {
            board[row][col] = getCurrentPlayer();
            return true;
        }
        return false;
    }
    
    public Piece getPiece(int row, int col);
    
    public boolean hasEmptySpace();
    
    public boolean isGameOver();
    
    public Piece getLargestValue();
    
}
