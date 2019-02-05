import java.util.Scanner;
import java.io.File;

public class RoyalFamily
{
    public static void main(String[] args)
    {
        //Define a variable to store the root node
        TNode<String> root = null;
        try
        {
            File text= new File("data.txt");
            Scanner s = new Scanner(text);
            String str= s.nextLine();
            root=new TNode<String> (str);
            str= s.nextLine();
            while(str!= "")
            {
                String[] cc= str.split(" > ");
                TNode<String> node= find (root, cc[0]);
                node.addChild(new TNode<String>(cc[1]));
                str= s.nextLine();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        //TODO: SETUP TREE DATA
        //1. Use Scanner to read the data.txt file
        //2. The first line in data.txt is the root node
        //3. For each line in data.txt in the format A > B
        //      - *find* the A node
        //      - add B as a child of A
        // Scanner s= new Scanner("data.txt");
        // root= new TNode<String>(s.nextLine());
        //TODO: test printPath method
        TNode<String> child = find(root, "Princess Beatrice of York");
        String path = getPath( child );
        System.out.println(path);
    }
    
    /**
       *  @return node if its data matches name, or return a child node with data that matches name
     */
    public static TNode<String> find(TNode<String> node, String name)
    {
        if(node.getData().equals(name))
        {
            return node;
        }
        for(TNode<String>child: node.getChildren())
        {
            TNode<String> str= find(child,name);
            if(str!= null)
            {
                return str;
            }
        }
        return null;
    }
    
    /**
     *  @return a String containing the path from the root node to the specified node, separeated by ->
     */
    public static String getPath(TNode<String> node)
    {
        //use recursion to concatenate the getPath of this node's parent with this node's data
        String str= node.getData();
        TNode<String> par = node.getParent();
        while(par!=null)
        {
            str= par.getData()+ " -> " +str;
            par= par.getParent();
        }
        return str;
    }
}