
/**
 * Write a description of class IGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IGame
{
    public boolean addPiece(int row, int col);
    
    public Piece getPiece(int row, int col);
    
    public boolean hasEmptySpace();
    
    public boolean isGameOver();
    
    public Piece getLargestValue();
    
    
}
