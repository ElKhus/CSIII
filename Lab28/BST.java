import java.util.List;
import java.util.LinkedList;
//
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
        if(root==null)
        {
            root = new BNode<E>(data);
        }
        else
        {
            addHelper(root, new BNode<E>(data));
        }
    }

    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
        E data = addMe.getData();

        if(data.compareTo(node.getData())<0)
        {
            if(node.getLeft()==null)
            {
                node.setLeft(addMe);
            }   
            else
            {
                addHelper(node.getLeft(), addMe);
            }
        }   
        else
        {
            if(node.getRight()==null)
            {
                node.setRight(addMe);
            }   
            else
            {
                addHelper(node.getRight(), addMe);
            }
        }   
    }

    public void addAll(List<E> data)
    {
        for(E e :  data)
        {
            add(e);
        }
    }

    //return the size of this tree (how many nodes are in it?)
    public int size()
    {
        int sizey = 1;
        if(root.hasRightChild())
        {
            sizey+=sizeHelper(root.getRight());
        }
        if(root.hasLeftChild())
        {
            sizey+=sizeHelper(root.getLeft());
        }
        return sizey;
    }

    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        int siz = 1;
        if(node.hasRightChild())
        {
            siz+=sizeHelper(node.getRight());
        }
        if(node.hasLeftChild())
        {
            siz+=sizeHelper(node.getLeft());
        }
        return siz;
    }
    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String fullLine = new String();
        fullLine= preorderHelper(root, "");
        fullLine= "["+fullLine+"]";
        return fullLine;
    }

    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {

        ret+=node.getData();
        if(node.hasLeftChild())
        {
            ret+= ", " + preorderHelper(node.getLeft(), "");
        }
        if(node.hasRightChild())
        {
            ret+= ", " + preorderHelper(node.getRight(), "");
        }

        return ret;
    }

    //Return a string with the data of this BST in order
    public String inorder()
    {
        String fullLine = new String();
        fullLine= inorderHelper(root, "");
        fullLine= "["+fullLine+"]";
        return fullLine;
    }

    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {

        if(node.hasLeftChild())
        {
            ret+=inorderHelper(node.getLeft(), "")+", ";
        }
        ret+=node.getData();
        if(node.hasRightChild())
        {
            ret+= ", " + inorderHelper(node.getRight(), "");
        }
        return ret;
    }

    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String fullLine = new String();
        fullLine= postorderHelper(root, "");
        fullLine= "["+fullLine+"]";
        return fullLine;
    }

    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {

        if(node.hasLeftChild())
        {
            ret+= postorderHelper(node.getLeft(), "")+", ";
        }
        if(node.hasRightChild())
        {
            ret+=postorderHelper(node.getRight(), "")+", ";
        }
        ret+=node.getData();
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
        if(node.getData().compareTo(data)>0)
        {
            if(node.hasLeftChild())
            {
                return containsHelper(node.getLeft(), data);

            }
        }
        else if (node.getData().compareTo(data)<0)
        {
            if(node.hasRightChild())
            {
                return containsHelper(node.getRight(), data);
            }

        }
        else
        {
            return true;
        }
        return false;
    }

    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.
    public boolean remove(E data)
    {
        BNode<E> nodel= root;
        BNode<E> parent= null;
        while(nodel!= null && nodel.getData()!=data)
        {
            parent=nodel;
            if(nodel.getData().compareTo(data)>0)
            {
                nodel=nodel.getLeft();
            }
            if(nodel.getData().compareTo(data)<0)
            {
                nodel=nodel.getRight();
            }
        }
        if(nodel==null)
        {
            return false;   
        }
        int kiddos=nodel.getNumChildren();
        if(parent!=null)
        {
            if(kiddos==0)
            {
                if(nodel.getData().compareTo(parent.getData())>0)
                {
                    parent.setRight(null);
                }
                if(nodel.getData().compareTo(parent.getData())<0)
                {
                    parent.setLeft(null);
                }
            }
            if(kiddos==1)
            {
                if(nodel.hasRightChild())
                {
                    if(nodel.getData().compareTo(parent.getData())>0)
                    {
                        parent.setRight(nodel.getRight());
                    }
                    if(nodel.getData().compareTo(parent.getData())<0)
                    {
                        parent.setLeft(nodel.getRight());
                    }
                }
                if(nodel.hasLeftChild())
                {
                    if(nodel.getData().compareTo(parent.getData())>0)
                    {
                        parent.setRight(nodel.getLeft());
                    }
                    if(nodel.getData().compareTo(parent.getData())<0)
                    {
                        parent.setLeft(nodel.getLeft());
                    }   
                }
            }
            if(kiddos==2)
            {
                BNode<E> comroot =combine(nodel.getLeft(), nodel.getRight());
                if(nodel.getData().compareTo(parent.getData())>0)
                {
                    parent.setRight(comroot);
                }
                if(nodel.getData().compareTo(parent.getData())<0)
                {
                    parent.setLeft(comroot);
                }   
            }
        }
        else if (parent==null)
        {
            if(kiddos==0)
            {
                root=null;
            }
            if(kiddos==1)
            {
                if(nodel.hasRightChild())
                {
                    root=nodel.getRight();
                }   
                else if(nodel.hasLeftChild())
                {
                    root=nodel.getLeft();
                }
            }
            if(kiddos==2)
            {

                BNode<E> combroot= combine(nodel.getLeft(), nodel.getRight());
                root= combroot;
            }
        }
        return true;
    }

    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {

        if(node.hasLeftChild())
        {
            BNode<E> nodie= removeSmallestChild(node.getLeft());
            if(nodie.equals(node.getLeft()))
            {
                node.setLeft(nodie.getRight());
                nodie.setRight(node);
                return nodie;
            }
        }
        return node;
    }

    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        BNode<E> x= removeSmallestChild(right);
        if(x.equals(right))
        {
            right=right.getRight();
        }
        
        x.setLeft(left);
        x.setRight(right);
        return x;
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