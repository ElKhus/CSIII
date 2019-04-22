import java.util.LinkedList;

public class MySet<E> implements Set<E>
{
    private LinkedList<E> list;
    private int size;
    public MySet()
    {
        list=new LinkedList<E>();
    }   
    /**
     *	Return true if the Set is empty
     */
    public boolean isEmpty()
    {
        if(size==0)
        {
            return true;
        }
        return false;
    }
    

    /**
     *	Return the number of elements in the Set
     */
    public int size()
    {
        return size;
    }
    /**
     *	Return true if this Set contains obj
     */
    public boolean contains(Object obj)
    {
        for(int i=0;i<size;i++)
        {
            if(list.get(i).equals(obj))
            {
                return true;
            }
        }   
        return false;
    }

    /**
     *	Remove obj from this set.
     *	Return true if obj was removed from the set
     */
    public boolean remove(Object obj)
    {
        for(int i=0;i<size;i++)
        {
            if(list.get(i).equals(obj))
            {
                list.remove(i);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     *	If the set does not alreay contain item:
     *		add item to the Set
     *		return true
     *	Otherwise, return false
     */
    public boolean add(E item)
    {
        if (!list.contains(item))
        {
            list.add(item);
            size++;
            return true;
        }
        return false;
    }
}