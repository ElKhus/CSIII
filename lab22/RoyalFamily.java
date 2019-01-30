import java.util.Scanner;
import java.io.File;

public class RoyalFamily
{
	public static void main(String[] args)
	{
		//Define a variable to store the root node
		TNode<String> root = null;
		
		//TODO: SETUP TREE DATA
		//1. Use Scanner to read the data.txt file
		//2. The first line in data.txt is the root node
		//3. For each line in data.txt in the format A > B
		//		- *find* the A node
		//		- add B as a child of A
		
		//TODO: test printPath method
		TNode<String> child = find(root, "Princess Beatrice of York");
		String path = getPath( child );
		System.out.println(path);
	}
	
	/**
	 *	@return node if its data matches name, or return a child node with data that matches name
	 */
	public static TNode<String> find(TNode<String> node, String name)
	{
		//use recursion to check this node and all of its children to see if their data matches the specified name
		return null;
	}
	
	/**
	 *	@return a String containing the path from the root node to the specified node, separeated by ->
	 */
	public static String getPath(TNode<String> node)
	{
		//use recursion to concatenate the getPath of this node's parent with this node's data
		return null;
	}
}