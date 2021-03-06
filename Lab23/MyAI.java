import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyAI implements AI
{
    public String getName()
    {
        return "MinMaxTree";
    }

    //Return the best move myPiece can make using a MinMaxTree
    public Point getNextMove(TicTacToe game, TicTacToePiece myPiece)
    {
        //if game is over, return null
        if(game.isGameOver()){
            return null;
        }
        else{

            //Generate a MinMax tree using the TicTacToe game parameter
            Point move= null;
            TNode<MinMaxNode> tree =generateMinMaxTree(game,move);

            //Score the MinMax tree
            scoreMinMaxTree(tree,myPiece);
            
            //Create a list of MinMaxNodes from the children of the root of the
            //MinMax tree you just generated
            //if the root node has no children, return null
            List <MinMaxNode> childs = new LinkedList <MinMaxNode>();
            childs= tree.getChildrenData();
            if(childs.size()==0)
            {
                return null;
            }
            //Determine what the best (highest) score is among all of the
            //MinMax nodes in the list your just created
            int max=Integer.MIN_VALUE;
            for(MinMaxNode child: childs)
            {
                if (child.getScore()>max)
                {
                    max= child.getScore();
                }
            }
            //Create a list to hold all of the moves (Point objects) that 
            //are rated with the best score
            //loop through all of the children of the root of the MinMax 
            //tree and add the Point from the ones with the "best score" 
            //to the list of Points you just created
            List <Point> movies = new LinkedList <Point>();
            for(MinMaxNode kidkid: childs)
            {
                if (kidkid.getScore()==max)
                {
                    movies.add(kidkid.getMove());
                }
            }
            //return a random point from the list of Points
            int index = (int)(Math.random()*movies.size());
            return movies.get(index);
        }
    }

    //Generate a MinMaxTree consisting of a root node containing game,
    //and children nodes 
    //containing all possible moves the current player can make
    private TNode<MinMaxNode> generateMinMaxTree(TicTacToe game, Point move)
    {
        //make a copy of game (so you can modify the copy without changing game
        TicTacToe copy = game.copy();
        //if move is not null
        //  apply move to the copy (addPiece and nextPlayer)
        if(move!=null)
        {
            copy.addPiece(move.getRow(),move.getCol());
            copy.nextPlayer();
        }

        //Make a MinMaxNode with the copy and move
        MinMaxNode curState = new MinMaxNode(copy,move);
        //Make a TNode with the MinMaxNode you just created
        TNode<MinMaxNode>root = new TNode<MinMaxNode>(curState);
        //recursively call generateMinMaxTree for each legal move that 
        //the new current player can make on copy (every empty space is a legal move)
        //  add the TNode returned by the recursive generateMinMaxTree calls as a 
        //child to the TNode you created above
        List <Point> legalMoves = new LinkedList<Point>();
        legalMoves= copy.getEmptySpaces();
        for(Point poi:legalMoves)
        {
            root.addChild(generateMinMaxTree(copy,poi));
        }
        //return the TNode you created above
        return root;
    }

    //Generate a score for every node in the MinMaxTree (from the point of view 
    //of player)
    private void scoreMinMaxTree(TNode<MinMaxNode> root, TicTacToePiece player)
    {
        //get the MinMaxNode out of the root node
        MinMaxNode leNode = root.getData();
        //get the game out of the MinMaxNode
        TicTacToe joue= leNode.getGame();
        //if the game is over
        if(joue.isGameOver())
        {
            //use the setScore method to score the MinMaxNode based on who won
            //the game
            //      if player is the winner ->  10 points
            //      if the game is tied ->      0 points
            //      if player is the loser ->   -10 points
            TicTacToePiece winner = joue.getWinner();
            if(winner==null)
            {
                leNode.setScore(0);
            }
            else if(player==winner)
            {
                leNode.setScore(10);
            }
            else
            {
                leNode.setScore(-10);
            }
        }
        else
        {
            //if the game is not over
            //  recursively call scoreMinMaxTree on all of the root node's children
            //  determine the lowest and highest scores among all of the root node's 
            //  children
            //  if it is player's turn
            //      set this MinMaxNode's score to the highest score
            //  if it is NOT player's turn
            //      set this MinMaxNode's score to the lowest score
            for(TNode<MinMaxNode> child : root.getChildren())
            {
                scoreMinMaxTree(child,player);
            }
            List <TNode<MinMaxNode>> nodeKids = new LinkedList<TNode<MinMaxNode>>();
            nodeKids= root.getChildren();
            int max=nodeKids.get(0).getData().getScore();
            int min=nodeKids.get(0).getData().getScore();
            for(TNode<MinMaxNode> kid : nodeKids)
            {
                MinMaxNode kidData = kid.getData();
                if(kidData.getScore()>max)
                {
                    max=kidData.getScore();
                }
                if(kidData.getScore()<min)
                {
                    min= kidData.getScore();
                }
            }

            if(joue.getCurrentPlayer()==player)
            {
                leNode.setScore(max);
            }
            if(joue.getCurrentPlayer()!=player)
            {
                leNode.setScore(min);
            }
        }
    }
}

