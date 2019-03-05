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
        if(getParentIndex(index)!=-1)
        {
            if((getValueAt(index).compareTo(getValueAt(getParentIndex(index))))<0)
            {
                super.swap(index,getParentIndex(index));
                addHelper(index);
            }
        }
    }

    //returns true if the value at index is less than both of its children
    public boolean meetsHeapProperty(int index)
    {
        E parent= getValueAt(index);
        int left= getLeftIndex(index);
        int right= getRightIndex(index);
        if(getLeftIndex(index)!= -1 || parent.compareTo(left)>0)
        {
            return false;
        }
        if(getRightIndex(index)!= -1 || parent.compareTo(right)>0)
        {
            return false;
        }
        return true;
    }

    //Helper method
    //Returns the index of the child of the specified node with the smallest value
    private int getSmallestChildIndex(int index)
    {
        
        int left=getLeftIndex(index);
        int right = getRightIndex(index);
        if(left==-1)
        {
            if(right==-1)
            {
                return -1;
            }
            return right;
        }
        if(right==-1)
        {
            if(left==-1)
            {
                return -1;
            }
            return left;
        }
        else
        {
            if(getValueAt(left).compareTo(getValueAt(right))<0)
            {
                 return left;
            }
            return right;
        }
    }

    //remove and return the value at the root of this heap
    //then reconstitute its heapness using the remove algorithm
    public E removeRoot()
    {
        if(size()==0)
        {
            return null;
        }
        E rootval= getValueAt(0);
        swap(0,list.size()-1);
        removeLast();
        sink(0);
        return rootval;
    }

    public void heapify()
    {
        for(int i=size()-1; i>=0;i--)
        {
            sink(i);
        }
    }

    //recursive helper method for heapify. 
    //This method "sinks" the value at index until it meets the heap property
    private void sink(int index)
    {
        if(!meetsHeapProperty(index))
        {
            int kiddo= getSmallestChildIndex(index);
            if(kiddo!=-1)
            {
                swap(index,kiddo);
                sink(kiddo);

            }

        }
    }

    //do not edit this method!
    public void shuffle()
    {
        for(int i=0; i<size(); i++)
            swap(i, (int)(Math.random() * size()));
    }
}