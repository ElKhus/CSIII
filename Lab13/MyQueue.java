import java.util.LinkedList;
public class MyQueue<E> implements Queue<E>
{
    private int size;
    private LinkedList<E> list;

    public MyQueue()
    {
        list=new LinkedList<E>();
    }

    /**
     *  Return the Object at the beginning of this Queue
     *  If the Queue is empty, return null
     */
    public E peek()
    {

        if (size==0)
        {
            return null;
        }
        return list.get(0);
    }

    /**
     *  Add obj to the end of this Queue
     */
    public boolean add(E obj)
    {
        list.add(obj);
        size++;
        return true;
    }

    /**
     *  Remove the Object from the front of this Queue and return it.
     *  If the Queue is empty, return null
     */
    public E remove()
    {
        if(size==0)
        {
            return null;
        }
        size--;
        return list.remove(0);
    }

    /**
     *  Return true if this Queue is empty
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
     *  Return the number of Objects in this Queue
     */
    public int size()
    {
        return size;
    }
}