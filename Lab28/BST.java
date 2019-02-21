import java.util.List;

public class BST<E extends Comparable>
{
	private BNode<E> root;
	
    public BST() 
    {
    	root = null;
    }
    
    //add data to this BST
    public void add(E data)
    {
    	addHelper(root,new BNode<E>(data));
    }
    
    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
    	
    }
    
    public void addAll(List<E> data)
    {
    	
    }
    
    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
    	return sizeHelper(root);
    }
    
    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
    	return -1;
    }
    
    //Return a string with the data of this BST in pre order
    public String preorder()
    {
    	return preorderHelper(root, "");
    }
    
    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {
    	return ret;
    }
    
    //Return a string with the data of this BST in order
    public String inorder()
    {
    	return inorderHelper(root, "");	
    }
    
    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {
    	return ret;
    }
    
    //Return a string with the data of this BST in post order
    public String postorder()
    {
    	return postorderHelper(root, "");
    }
    
    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
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
    //	Helper Class //
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