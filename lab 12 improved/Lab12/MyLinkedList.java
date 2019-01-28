import junit.framework.*; 
import java.util.*;
public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head;
    private int size;
    public MyLinkedList()
    {
        head= new Node<E> (null);
    }

    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(E obj)
    {
        Node<E> n = head;
        while (n.getNext() != null)
        {
            n=n.getNext();
        }
        n.setNext(new Node <E> (obj));
        size++;
        return true;
    }

    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj)
    {
        if (index<0)
        {
            index = 0;
        }
        else if(index>size)
        {
            index= size;
        }
        if (index==0)
        {
            Node<E> addition= new Node<E> (obj);
            Node<E> n = head.getNext();
            head.setNext(addition);
            addition.setNext(n);
        }
        else
        {
            Node <E> n= new Node<E> (obj);
            Node <E> before = getNode(index-1);
            Node <E> old= before.getNext();
            before.setNext(n);
            n.setNext(old); 
        }

        size++;
    }

    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj)
    {
        if (size==0)
        {
            return false;
        }
        Node n = head.getNext();
        while(n!= null)
        {
            if( n.getValue().equals(obj))
            {
                return true;
            }
            n= n.getNext();
        }
        return false;
    }

    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public E get(int index)
    {
        if (size>0)
        {
            if (index<0 || index>size)
            {
                return null;
            }
            Node<E> n= getNode(index);
            if(n== null)
            {
                return null;
            }
            return n.getValue();
        }
        else
        {
            return null;
        }
    }

    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        if (size==0)
        {
            return true;
        }
        return false;
    }

    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index)
    {
        if (size>0)
        {
            if (index > size || index< 0)
            {
                return null;
            }
            if (index==0)
            {
                Node<E> removal= getNode(index);
                Node<E> n = removal.getNext();
                head.setNext(n);
                size--;
                return removal.getValue();
            }
            if (index==size)
            {
                Node<E> remove= getNode(index);
                Node<E> n= getNode(index-1);
                n.setNext(null);
                size--;
                return remove.getValue();
            }

            Node <E> post = getNode(index+1);
            Node<E> pre = getNode(index-1);
            Node<E> orig = getNode(index);
            pre.setNext(post);
            size--;
            return orig.getValue();

        }
        else
        {
            return null;
        }
    }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(E obj)
    {
        if (size==0)
        {
            return false;
        }
        Node n = head.getNext();

        for (int i=0; i <size; i++)
        {
            if( n.getValue().equals(obj))
            {
                remove(i);
                return true;
            }
            n= n.getNext();
        }

        return false;
    }

    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     *  If index is too big or too small, do not change and values and return null
     */
    public E set(int index, E obj)
    {
        if (size>0)
        {
            if (index > size || index< 0)
            {
                return null;
            }
            Node<E>n= head;
            int count = 0;
            E temp = null;
            while (n.getNext() != null)
            {
                n=n.getNext();
                if (count==index)
                {
                    temp= n.getValue();
                    n.setValue(obj);
                    return temp;
                }
                count++;
            }
            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     *  Return the number of elements that are in the list
     */
    public int size()
    {
        return size;
    }

    /**
     * This method returns the index where the first
     * occurrence of obj
     * If list does not contain obj, then return -1
     */
    private int indexOf (E obj)
    {
        int i=0;
        Node <E> n= head.getNext();
        while(n!= null && !n.getValue().equals(obj))
        {
            i++;
        }
        n=n.getNext();
        if (n==null)
        {
            return -1;
        }
        return i;
    }

    /**
     * return the Node object that is stored at index
     * If index is out of bounds then return null
     */
    private Node<E> getNode(int index)
    {
        if (index<0|| index>size())
        {
            return null;
        }
        Node<E> n= head.getNext();
        int count= 0;
        while (n!=null && count<index)
        {
            count++;
            n.getNext();
        }
        return n;
    }
    class Node<E>
    {
        private E value;
        private Node<E> next;
        public Node(E obj)
        {
            value= obj;
        }

        public E getValue()
        {
            return value;
        }

        public E setValue(E data)
        {
            E oldValue= value;
            value = data;
            return oldValue;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public Node<E> setNext(Node <E> node)
        {
            Node<E> oldNext = next;
            next= node;
            return oldNext;
        }
    }
}