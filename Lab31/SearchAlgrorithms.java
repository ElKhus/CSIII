import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class SearchAlgrorithms<E extends Comparable<E>>
{
    //INSTANCE VARIABLES
    private AdjacencyListGraph graph;
    private Set<E> visited;

    public SearchAlgrorithms(AdjacencyListGraph g)
    {
        
    }

    public List depthFirstSearch(E node)
    {
        // Create an array list of the DFS results
       
        // Reset the "visited" set - make a new Set
      
        // Create a stack for DFS
     
        // Push the current source node onto the stck
        

        // OUTER WHILE LOOP:
        // while the stack is not empty
        
        // Pop a node from the stack
        
        // If this node hasn't been visited, add it to the results list
        
        // Add this node to the visited set
        
        // Get all adjacent (neighbor) nodes of the popped node
        
        // IMPORTANT!  SORT the neighbors list!  Use a private method to do this.
        
        // If an adjacent node hasn't been visited, 
        // then push it onto the stack.

        // INNER WHILE LOOP: 
        // while the neighbors list isn't empty...
        
        // find the smallest neighbor - how do you know its the smallest neighbor?
        
        // If this node hasn't been visited, add it to the stack list
        // remove this smallest neighbor from the neighbors list
        
        // END INNER WHILE LOOP
        
        // END OUTER while loop
        
        // return the DFS results list
        return null;
        
    }

    public List breadthFirstSearch(E node)
    {
        // Create an array list of the BFS results
      
        // Reset the "visited" set - make a new Set

        // Create a queue for BFS

        // Enqueue (aka add) the current source node

        // OUTER WHILE LOOP
        // while the queue is not empty
        
        // dequeue (aka remove) the node at the front of the queue
        
        // If this node hasn't been visited, add it to the results list
        
        // Add this node to the visited set
        
        // Get all adjacent nodes of the dequeued node
        
        // If an adjacent node has not been visited,  
        // then add it to the visited set and enqueue it
            
        // IMPORTANT!  SORT the neighbors list!  Use a private method to do this.

        // INNER WHILE LOOP
        // while the neighbors list isn't empty
        
        // find the smallest neighbor - how do you know its the smallest neighbor?
        
        // If this node hasn't been visited, add it to the queue
        // remove this smallest neighbor from the neighbors list
        
        // END INNER WHILE LOOP
       
        // END OUTER WHILE LOOP
        
        // return the BFS results list
        return null;
    }

    /**
     *  Private method to sort the arraylist
     */
    private ArrayList<E> sort (ArrayList<E> list)
    {
        // Use your favorite sorting method you learned 
        // in AP Computer Science A to the sort the list.
        // Return this sorted list.  

        return null ;
    }
    
    
    
}
