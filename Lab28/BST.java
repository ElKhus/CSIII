import java.util.List;
import java.util.LinkedList;
public class BST<E extends Comparable>
{
    private BNode<E> root;
    private int size;
    public BST() 
    {
        root = null;
    }

    //add data to this BST
    public void add(E data)
    {
        if(root!=null)
        {
            BNode<E> newnode= new BNode<E>(data);
            addHelper(root,newnode);
        }
        else
        {
            BNode<E> newnode= new BNode<E>(data);
        }
    }

    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
        int compNewToOld= addMe.getData().compareTo(node.getData());
        if(compNewToOld>=0)
        {
            if(node.hasRightChild())
            {
                addHelper(node.getRight(),addMe);
            }
            else 
            {
                BNode<E> newRight = new BNode<E>(addMe.getData());
                node.setRight(newRight);
            }
        }
        if(compNewToOld<0)
        {
            if(node.hasLeftChild())
            {
                addHelper(node.getLeft(),addMe);
            }   
            else
            {
                BNode<E> newLeft = new BNode<E>(addMe.getData());
                node.setLeft(newLeft);
            }
        }   
    }

    public void addAll(List<E> data)
    {
        for(int i=0; i<data.size(); i++)
        {
            add(data.get(i));
        }
    }

    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
        if(root.hasChildren()==false)
        {
            return 1;
        }
        return sizeHelper(root);
    }

    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        while(node.hasChildren())
        {
            if(node.hasRightChild())
            {
                size++;
                sizeHelper(node.getRight());
            }
            if(node.hasLeftChild())
            {
                size++;
                sizeHelper(node.getLeft());
            }
        }
        return size+1;
    }
    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String fullLine = new String();
        fullLine= preorderHelper(root, "");
        fullLine=fullLine.substring(0,fullLine.length()-1);
        fullLine= "["+fullLine+"]";
        return fullLine;
    }

    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {

        if(node.hasChildren())
        {
            ret+=node.getData()+",";
            if(node.hasLeftChild())
            {
                preorderHelper(node.getLeft(),ret);
            }
            if(node.hasRightChild())
            {
                preorderHelper(node.getRight(),ret);
            }
        }
        return ret;
    }

    //Return a string with the data of this BST in order
    public String inorder()
    {
        String fullLine = new String();
        fullLine= inorderHelper(root, "");
        fullLine=fullLine.substring(0,fullLine.length()-1);
        fullLine= "["+fullLine+"]";
        return fullLine; 
    }

    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {
        if(node.hasChildren())
        {
            if(node.hasLeftChild())
            {
                inorderHelper(node.getLeft(),ret);
            }
            ret+=node.getData()+",";
            if(node.hasRightChild())
            {
                inorderHelper(node.getRight(),ret);
            }
        }
        return ret;
    }

    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String fullLine = new String();
        fullLine= postorderHelper(root, "");
        fullLine=fullLine.substring(0,fullLine.length()-1);
        fullLine= "["+fullLine+"]";
        return fullLine; 
    }

    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
        if(node.hasChildren())
        {
            if(node.hasLeftChild())
            {
                postorderHelper(node.getLeft(),ret);
            }
            if(node.hasRightChild())
            {
                postorderHelper(node.getRight(),ret);
            }
            ret+=node.getData()+",";
        }
        return ret;
    }

    //Check if this BST contains the specified data
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }

    //Recursive helper method for contains
    private boolean containsHelper(BNode<E> node, E data)
    {
        if(node.getData()==data)
        {
            return true;
        }
        else
        {
            if(node.hasChildren())
            {
                if(node.hasRightChild())
                {
                    containsHelper(node.getRight(),data);
                }
                if(node.hasLeftChild())
                {
                    containsHelper(node.getLeft(),data);
                }
            }
        }
        return false;
    }

    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.
    public boolean remove(E data)
    {
        return false;
    }

    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {
        return null;
    }

    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        return null;
    }

    ///////////////////
    //  Helper Class //
    ///////////////////
    class BNode<E extends Comparable>
    {
        private E data;
        private BNode<E> left, right;

        public BNode(E data)
        {this.data = data;}

        public E getData()
        {return data;}

        public BNode<E> getLeft()
        {return left;}

        public BNode<E> getRight()
        {return right;}

        public void setLeft(BNode<E> left)
        {this.left = left;}

        public void setRight(BNode<E> right)
        {this.right = right;}

        public boolean hasLeftChild()
        {return null != left;}

        public boolean hasRightChild()
        {return null != right;}

        public boolean hasChildren()
        {return getNumChildren() > 0;}

        public int getNumChildren()
        {
            int ret = 0;
            if(hasLeftChild())  ret++;
            if(hasRightChild()) ret++;
            return ret;
        }
    }
}