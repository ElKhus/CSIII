import java.util.List;
import java.util.LinkedList;
import java.lang.Math;
public class Amazons implements IAmazons
{
    //INSTANCE VARIABLES
    private Piece[][] board;
    private Piece currentPlayer;

    //CONSTRUCTORS
    public Amazons()
    {
        
        //initialize instance variables
        board= new Piece[10][10];
        currentPlayer = Piece.BLACK;
        board[7][0]= Piece.WHITE;
        board[7][10]= Piece.WHITE;
        board[10][3]= Piece.WHITE;
        board[10][7]= Piece.WHITE;
        board[0][3]= Piece.BLACK;
        board[0][]= Piece.BLACK;
        board[][]= Piece.BLACK;
        board[][]= Piece.BLACK;
        //currentPlayer = Piece.WHITE;
        //currentPlayer = Piece.ARROW;
        //setup the board to its initial state
    }

    //METHODS       
    /**
     *  Return the current turn holder's Piece, Piece.BLACK or Piece.WHITE
     */
    public Piece getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     *  Setter for currentPlayer instance variable
     */
    //AHHHHH
    public void setCurrentPlayer(Piece piece)
    {
        currentPlayer= piece;
    }

    /**
     *  Change the currentPlayer
     *      Piece.BLACK -> Piece.WHITE
     *      Piece.WHITE -> Piece.BLACK
     */
    public void nextPlayer()
    {
        if(currentPlayer == Piece.BLACK)
        {
            currentPlayer= Piece.WHITE;
        }
        else
        {
            currentPlayer= Piece.BLACK;
        }
    }

    /**
     *  Return the piece that is on the board at the specified Point
     *      Piece.BLACK, Piece.WHITE, or Piece.ARROW
     */
    public Piece getPiece(Point p)
    {
        if(board[p.getRow()][p.getCol()] == Piece.BLACK)
        {
            return Piece.BLACK;
        }
        else if(board[p.getRow()][p.getCol()]==Piece.WHITE)
        {
            return Piece.WHITE;
        }
        else if(board[p.getRow()][p.getCol()]==Piece.ARROW)
        {
            return Piece.ARROW;
        }
        return null;
    }

    public void setPiece(Piece piece, Point p)
    {
        if(board[p.getRow()][p.getCol()]==null)
        {
            board[p.getRow()][p.getCol()]=piece;
        }
    }

    /**
     *  Move the piece located at Point from to Point to
     */
    public void move(Point from, Point to)
    {
        Piece ph = getPiece(from);
        board[from.getRow()][from.getCol()]=null;
        board[to.getRow()][to.getCol()]=ph;
    }

    /**
     *  Add an arrow to Point p
     */
    public void arrow(Point p)
    {
        board[p.getRow()][p.getCol()]=Piece.ARROW;
    }

    /**
     *  Return true if there is no piece at Point p
     */
    public boolean isEmpty(Point p)
    {
        if(board[p.getRow()][p.getCol()]==null)
        {
            return true;
        }
        return false;
    }

    /**
     *  Return a List of Points that form a straigh line between Point from and Point to
     *  This line can be horizontal, vertical, or diagonal
     *  If there is no straight line between from and to, return an empty List
     */
    public List<Point> getPath(Point from, Point to)
    {
        List<Point>list = new LinkedList<Point>();
        if ((from.getRow()==to.getRow()) &&((from.getCol()==to.getCol())))
        {
            int pc=from.getCol();
            int pr=from.getRow();
            Point p= new Point(pr, pc);
            list.add(p);
        }
        else if((from.getRow()==to.getRow())&&(from.getCol()!=to.getCol()))
        {
            if(from.getCol()-to.getCol()>0)
            {
                int ph= from.getCol();
                while (to.getCol()-1 != ph)
                {
                    Point p= new Point(from.getRow(),ph);
                    list.add(p);
                    ph--;
                }
            }
            if(from.getCol()-to.getCol()<0)
            {
                int ph= from.getCol();
                while (to.getCol()+1 != ph)
                {
                    Point p= new Point(from.getRow(),ph);
                    list.add(p);
                    ph++;
                }
            }
        }
        else if((from.getCol()==to.getCol())&& (from.getRow()!=to.getRow()))
        {
            if(from.getRow()-to.getRow()>0)
            {
                int ph= from.getRow();
                while (to.getRow()-1 != ph)
                {
                    Point p= new Point(ph,from.getCol());
                    list.add(p);
                    ph--;
                }
            }
            if(from.getRow()-to.getRow()<0)
            {
                int ph= from.getRow();
                while (to.getRow()+1 != ph)
                {
                    Point p= new Point(ph,from.getCol());
                    list.add(p);
                    ph++;
                }
            }
        }
        else if((Math.abs((to.getCol()-from.getCol())/(to.getRow()-from.getRow())))==1)
        {
            //slopes are opposite of logic
            //int slope=(Math.abs((to.getCol()-from.getCol())/(to.getRow()-from.getRow())));
            int pc=from.getCol();
            int pr=from.getRow();
            if((from.getRow()>to.getRow())&&(from.getCol()>to.getCol()))
            {
                while((to.getRow()-1!=pr)&&(to.getCol()-1!= pc))
                {
                    Point p= new Point(pr, pc);
                    list.add(p);
                    pr--;
                    pc--;
                }
            }
            if((from.getRow()<to.getRow())&&(from.getCol()<to.getCol()))
            {
                while((to.getRow()+1!=pr)&&(to.getCol()+1!= pc))
                {
                    Point p= new Point(pr, pc);
                    list.add(p);
                    pr++;
                    pc++;
                }
            }
            if((from.getRow()>to.getRow())&&(from.getCol()<to.getCol()))
            {
                while((to.getRow()-1!=pr)&&(to.getCol()+1!= pc))
                {
                    Point p= new Point(pr, pc);
                    list.add(p);
                    pr--;
                    pc++;
                }
            }
            if((from.getRow()<to.getRow())&&(from.getCol()>to.getCol()))
            {
                while((to.getRow()+1!=pr)&&(to.getCol()-1!= pc))
                {
                    Point p= new Point(pr, pc);
                    list.add(p);
                    pr++;
                    pc--;
                }
            }

        }

        return list;
    }

    /**
     *  Return true if all of the Points on path are empty EXCLUDING the first Point
     *  Return false if the path is size 1
     *  Return false if path is the empty List
     */
    public boolean isPathEmpty(List<Point> path)
    {
        if(path.size()>1)
        {
            int tester= 0;
            for(int i=1; i<path.size();i++)
            {
                if(isEmpty(path.get(i))==false)
                {
                    tester++;
                }
            }
            if (tester==0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     *  Return a List of the Points that contain pieces that match the specified piece (Piece.BLACK, Piece.WHITE)
     */
    public List<Point> getPieces(Piece piece)
    {
        List<Point>list = new LinkedList<Point>();
        for(int r=0; r<10;r++)
        {
            for(int c=0; c<10;c++)
            {
                if(board[r][c]==piece)
                {
                    Point p= new Point(r, c);
                    list.add(p);
                }
            }
        }
        return list;
    }

    /**
     *  Return a List of Moves that are legal for the point located at Point from
     *  Return the empty List if there is no piece at Point from or if the Piece is an arrow
     *  Do not worry about the currentPlayer.
     */
    public List<Move> getLegalMoves(Point from)
    {
        List<Move>list = new LinkedList<Move>();
        if(((board[from.getRow()][from.getCol()])==Piece.WHITE)||((board[from.getRow()][from.getCol()])==Piece.BLACK))
        {
            for(int r=0; r<10; r++)
            {
                for(int c=0; c<10; c++)
                {
                    for(int rr=0; rr<10; rr++)
                    {
                        for(int cc=0; cc<10; cc++)
                        {
                            Point dest= new Point(r,c);
                            Point arro= new Point(rr,cc);
                            List<Point>fromDest = new LinkedList<Point>();
                            List<Point>destArro = new LinkedList<Point>();
                            fromDest=getPath(from,dest);
                            destArro=getPath(dest,arro);
                            if((isPathEmpty(fromDest)&&(isPathEmpty(destArro))))
                            {
                                Move movew= new Move(from,dest,arro);
                                list.add(movew);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    /**
     *  Return a List of Moves that are legal for pieces that match the specified piece (Piece.BLACK, Piece.WHITE)
     *  Do not worry about the currentPlayer
     *  Return the empty List if piece is an arrow
     */
    public List<Move> getLegalMoves(Piece piece)
    {
        List<Move>list = new LinkedList<Move>();
        if(((piece==Piece.WHITE)||(piece==Piece.BLACK)))
        {
            List<Point>loco = new LinkedList<Point>();
            List<Move>forOneP = new LinkedList<Move>();
            loco=getPieces(piece);
            for(int i=0; i<loco.size(); i++)
            {
                forOneP=(getLegalMoves(loco.get(i)));
                for(int b=0; b<forOneP.size();b++)
                {
                    list.add(forOneP.get(b));
                }
            }
        }
        return list;
    }

    /**
     *  Return true if the specified Move is a legal move
     *  Do not worry about the currentPlayer
     */
    public boolean isLegalMove(Move move)
    {
        int cols= move.getPiece().getCol();
        int rows= move.getPiece().getRow();
        List<Point>list = new LinkedList<Point>();
        list=getPath(move.getPiece(), move.getDestination());
        List<Point>arList = new LinkedList<Point>();
        arList=getPath(move.getDestination(), move.getArrow());
        if((board[rows][cols]==Piece.WHITE)||(board[rows][cols]==Piece.BLACK))
        {
            if(isPathEmpty(list))
            {
                if(isPathEmpty(arList))
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *  Return true if the piece at the specified Point has any legal moves
     *  Return false if there is no piece at the specified Point, or if that piece is an arrow
     *  Do not worry about the currentPlayer
     */
    public boolean hasMoves(Point piecePosition)
    {
        if(((board[piecePosition.getRow()][piecePosition.getCol()])==Piece.WHITE)||((board[piecePosition.getRow()][piecePosition.getCol()])==Piece.BLACK))
        {
            if(getLegalMoves(piecePosition).size()>0)
            {
                return true;
            }
        }
        return false;
    }

    /**
     *  If the game is over, return the piece that is the winner
     *  The winner is the piece that still has legal moves left
     *  If neither piece has any legal moves, return null
     *  If the game is not over, return null
     */
    public Piece getWinner()
    {
        if(isGameOver())
        {
            if(getLegalMoves(Piece.BLACK).size()>0)
            {
                return Piece.BLACK;
            }   
            else if(getLegalMoves(Piece.WHITE).size()>0)
            {
                return Piece.WHITE;
            }   
        }
        return null;
    }

    /**
     *  Return true if at least one of the pieces (Piece.BLACK, Piece.WHITE) has 0 legal moves left
     */

    public boolean isGameOver()
    {
        if((getLegalMoves(Piece.BLACK).size()==0)||(getLegalMoves(Piece.WHITE).size()==0))
        {
            return true;
        }
        return false;
    }

    /**
     *  Return a new instance of an Amazons object with the same state as *this* object
     *  The copy should contain all the same Pieces in all the same places and the same currentPlayer
     */
    public Amazons copy()
    {
        return null;
    }
}

