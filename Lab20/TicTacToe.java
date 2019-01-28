
//*****************************************************************
//*****************************************************************
//TODO: copy your TicTacToe.java file from Lab19 over this file! **
//*****************************************************************
//*****************************************************************


public class TicTacToe implements ITicTacToe
{
    //INSTANCE VARIABLES
    private TicTacToePiece currentPlayer;
    private TicTacToePiece board[][];

    //CONSTRUCTORS
    public TicTacToe() 
    {
        //Initialize instance variables here
        currentPlayer = TicTacToePiece.X;
        board = new TicTacToePiece[3][3];
    }

    //METHODS
    /*
     *	Return the current player's piece (X or O)
     */
    public TicTacToePiece getCurrentPlayer()
    {
        return currentPlayer;
    }

    /*
     *	Change the current player from X to O, or from O to X
     */
    public void nextPlayer()
    {
        if(currentPlayer == TicTacToePiece.X)
        {
            currentPlayer = TicTacToePiece.O;
        }
        else
        {
            currentPlayer = TicTacToePiece.X;
        }
    }

    /*
     *	Add the specified piece to the board at the specified row,col and return true
     *	If there is already a piece at that location, do not add the piece and return false
     */
    public boolean addPiece(int row, int col)
    {
        if(board[row][col] == null)
        {
            board[row][col] = getCurrentPlayer();
            return true;
        }
        return false;
    }

    /*
     *	Return the piece that is located at the specified row, col
     *	If there is no piece at that location, return null
     */
    public TicTacToePiece getPiece(int row, int col)
    {
        if(board[row][col] == TicTacToePiece.X)
        {
            return TicTacToePiece.X;
        }
        else if(board[row][col] == TicTacToePiece.O)
        {
            return TicTacToePiece.O;
        }
        return null;
    }

    /*
     *	Return true if there is at least 1 empty space left on the board
     *	Return false if all spaces have a piece in them
     */
    public boolean hasEmptySpace()
    {
        boolean now = false;
        for(int i = 0; i < 3; i++)
        {
            for(int r = 0; r < 3; r++)
            {
                if(getPiece(i,r) == null)
                {
                    now = true;
                }
            }
        }
        return now;
    }

    /*	Return null if there is no winner
     *	Return the appropriate TicTacToePiece (X or Y) if there is a winner.
     *	Hint: use the helper methods: checkRowsForWinner(), checkColsForWinner(), and checkDiagsForWinner()
     */
    public TicTacToePiece getWinner()
    {
         TicTacToePiece winner = null;
         
         if(isGameOver() == true && hasEmptySpace() == true)
         {
             if(checkRowsForWinner() != null)
             {
                 winner = checkRowsForWinner();
             }
             else if(checkColsForWinner() != null)
             {
                 winner = checkColsForWinner();
             }
             else if(checkDiagsForWinner() != null)
             {
                 winner = checkDiagsForWinner();
             }
         }
         return winner;
    }

    /*
     *	Return true if there is a winner or if there are no empty spaces left on the board
     *	Otherwise, return false
     */
    public boolean isGameOver()
    {
         if(checkRowsForWinner() != null ||  checkColsForWinner() != null ||  checkDiagsForWinner() != null || hasEmptySpace() != true)
         {
             return true;
         }
         return false;
    }

    //HELPER METHODS
    /*
     *	If a, b, and c are all the same TicTacToe piece, then return that piece
     *	Otherwise, return null
     */
    private TicTacToePiece checkForWinner(TicTacToePiece a, TicTacToePiece b, TicTacToePiece c)
    {
        return (a ==b && b == c)?a:null;
    }

    /*
     *	Use the checkForWinner() helper method to check each of the 3 rows for a winner
     *	Return the first non-null winner that is found (starting from row 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkRowsForWinner()
    {
        TicTacToePiece winner = null;

        for(int i = 0; i < 3; i++)
        {
            winner = checkForWinner(board[i][0], board[i][1], board[i][2]);
            if(winner != null)
            {
                break;
            }
        }
        return winner;
    }

    /*
     *	Use the checkForWinner() helper method to check each of the 3 columns for a winner
     *	Return the first non-null winner that is found (starting from column 0)
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkColsForWinner()
    {
        TicTacToePiece winner = null;

        for(int i = 0; i < 3; i++)
        {
            winner = checkForWinner(board[0][i], board[1][i], board[2][i]);
            if(winner != null)
            {
                break;
            }
        }
        return winner;
    }

    /*
     *	Use the checkForWinner() helper method to check both of the diagonals for a winner
     *	Check the top left -> bottom right diagonal first
     *	Check the top right -> bottom left diagonal second
     *	Return the first non-null winner that is found
     *	If no non-null winners are found, return null
     */
    private TicTacToePiece checkDiagsForWinner()
    {
        TicTacToePiece winner = null;
        
        if(checkForWinner(board[0][0], board[1][1], board[2][2]) != null)
            {
                winner = checkForWinner(board[0][0], board[1][1], board[2][2]);
            }
        else if(checkForWinner(board[2][0], board[1][1], board[0][2]) != null)
            {
                winner = checkForWinner(board[2][0], board[1][1], board[0][2]);
            }
        return winner;
    }

}


