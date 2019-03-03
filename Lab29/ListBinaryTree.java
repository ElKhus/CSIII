import java.util.List;
import java.util.ArrayList;

public class ListBinaryTree <E>
{
    protected List<E> list;
    private int size;
    public ListBinaryTree() 
    {
        list = new ArrayList<E>();
    }

    //add data to this Complete Binary Tree
    public void add(E data)
    {
        list.add(data);
    }

    //Add all the elements from the provided list to this Complete Binary Tree
    public void addAll(List<E> data)
    {
        for(E e : data)
        {
            list.add(e);
            size++;
        }
    }
    
    //Return the size of this tree
    public int size()
    {
        for(E e: list)
        {
            size++;
        }
        return size;
    }

    public String preorder()
    {
        String fullLine = new String();
        fullLine= preorderHelper(0,"");
        fullLine= "[" +fullLine+ "]";
        return fullLine;
    }

    private String preorderHelper(int index, String ret)
    {
        ret+=getValueAt(index);
        int leftie= getLeftIndex(index);
        if(leftie != -1)
        {
            ret+= ", " + preorderHelper(leftie, "");
        }
        int rightie= getRightIndex(index);
        if(rightie != -1)
        {
            ret+= ", " + preorderHelper(rightie, "");
        }
        return ret;
    }

    public String inorder()
    {
        String fullLine = new String();
        fullLine= inorderHelper(0, "");
        fullLine= "[" + fullLine+ "]";
        return fullLine;
    }

    private String inorderHelper(int index, String ret)
    {
        int leftie= getLeftIndex(index);
        if(leftie != -1)
        {
            ret+=inorderHelper(leftie, "")+", ";
        }
        ret+=getValueAt(index);
        int rightie= getRightIndex(index);
        if(rightie != -1)
        {
            ret+= ", " + inorderHelper(rightie, "");
        }
        return ret;
    }

    public String postorder()
    {
        String fullLine= new String();
        fullLine= postorderHelper(0, "");
        fullLine= "[" +fullLine+"]";
        return fullLine;
    }

    private String postorderHelper(int index, String ret)
    {
        int leftie= getLeftIndex(index);
        if(leftie != -1)
        {
            ret+=postorderHelper(leftie, "")+", ";
        }
        int rightie= getRightIndex(index);
        if(rightie != -1)
        {
            ret+=postorderHelper(rightie, "")+", ";
        }
        ret+=getValueAt(index);
        return ret;
    }

    //return the value stored at the specified index
    //or null if the index is out of bounds
    public E getValueAt(int index)
    {
        if(index>=0 && index<list.size())
        {
            return list.get(index);
        }
        return null;
    }

    //return the index of the parent of the node located at the specified index
    //if index is out of bounds, return -1
    //if the node at the specified index does not have a parent, return -1
    public int getParentIndex(int index)
    {
        if(index>0 && index<list.size())
        {
            int parent= (int) Math.floor((index-1)/2);
            return parent;
        }
        return -1;
    }

    //return the index of the left child of the node at the specified index
    //if there is no left child, return -1
    public int getLeftIndex(int parentIndex)
    {
        int leftChild = (parentIndex*2)+1;
        if(leftChild>0 && leftChild<list.size())
        {
            return leftChild;
        }
        return -1;
    }

    //return the index of the right child of the node at the specified index
    //if there is no right child, return -1
    public int getRightIndex(int parentIndex)
    {
        int rightChild = (parentIndex*2)+2;
        if(rightChild>0 && rightChild<list.size())
        {
            return rightChild;
        }
        return -1;
    }

    //a useful utility function to swap two nodes in the tree
    //swap the values located at indexA and indexB
    public void swap(int indexA, int indexB)
    {
        E a= getValueAt(indexA);
<<<<<<< HEAD
        E b = getValueAt(indexB);
=======
        E b= getValueAt(indexB);
>>>>>>> c681976ecd1bc66e1f74321665d8130441d8856a
        list.set(indexA, b);
        list.set(indexB, a);
    }

}