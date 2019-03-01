public class Heap<E extends Comparable> extends ListBinaryTree<E>
{
	//Add data to this heap
	//Add data exactly like a ListBinaryTree, then propigate that value up the tree 
	//(using the addHelper method)
    @Override
    public void add(E data)
    {
    	super.add(data);
    	addHelper(0);
    }
    
    //Recursive helper method for add
    //Recusively swap the value at index and its parent while val is less than its parent
    private void addHelper(int index)
    {
    	if(getValueAt(index)<getValueAt(index.getParentIndex()))
    	{
    	    
    	   }
    }
    
    //returns true if the value at index is less than both of its children
    public boolean meetsHeapProperty(int index)
    {
    	return false;
    }
    
    //Helper method
    //Returns the index of the child of the specified node with the smallest value
    private int getSmallestChildIndex(int index)
    {
    	
    }
    
    
    //remove and return the value at the root of this heap
    //then reconstitute its heapness using the remove algorithm
    public E removeRoot()
    {
    	return null;
    }
    
    public void heapify()
    {
    	
    }
 
    //recursive helper method for heapify. 
    //This method "sinks" the value at index until it meets the heap property
    private void sink(int index)
    {
    	
    }
    
    //do not edit this method!
    public void shuffle()
    {
    	for(int i=0; i<size(); i++)
    		swap(i, (int)(Math.random() * size()));
    }
}