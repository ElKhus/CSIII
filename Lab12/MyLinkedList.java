public class MyLinkedList<E> implements GenericList<E>
{
    private Node<E> head;
    private int size;
    public MyLinkedList()
    {
        head = new Node<E>(null);
    }

    /**
     *	Add obj to the end of the list.
     *	This method always returns true
     */
    public boolean add(E obj)
    {
        Node<E> mew = getNode(size-1);
        mew.setNext(new Node<E>(obj));
        size++;
        return true;
    }

    /**
     *	Add obj to the specified index of the list.
     *	If index is too big, then add obj to the end of the list
     *	If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj) 
    {
        if(index<0)
        {
            index=0;
        }
        else if(index>=size)
        {
            add(obj);
        }
        Node<E> neew= new Node<E>(obj);
        Node<E> before= getNode(index-1);
        Node<E> old= getNode(index);
        before.setNext(neew);
        neew.setNext(old);
    }

    /**
     *	Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj) 
    {
        if (size==0)
        {
            return false;
        }
        for(int i= 0; i<size();i++)
        {
            if(true)
            {
                return true;
            }
        }
        return false;
    }

    /**
     *	Return the Object located at the specified index
     *	If index is too big or too small, return null
     */
    public E get(int index) 
    {
        Node<E> n= getNode(index);
        if (n==null)
        {
            return null;
        }
        return n.getValue();
    }

    /**
     *	Return true if there are no elements in the list
     */
    public boolean isEmpty() 
    {
        if (size()==0)
        {
            return true;
        }
        return false;
    }

    /**
     *	Remove the Object at the specified index from the list
     *	Return the Object that was removed
     *	If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index) 
    {
        if(size>0)
        {
            if(index<size||index<0)
            {
                return null;
            }
            else
            {
                Node<E>  before= getNode(index-1);
                Node<E> after= getNode(index+1);
                Node<E> old= getNode(index);
                before.setNext(after);
                size--;
                return old.getValue();
            }
        }
        else
        {
            return null;
        }
    }

    /**
     *	Remove the first Object that is .equals() to obj
     *	Return true if an object was removed
     */
    public boolean remove(E obj) 
    {
        return false;
    }

    /**
     *	Change the value stored at index to obj
     *	Return the value that was replaced
     *	If index is too big or too small, do not change and values and return null
     */
    public E set(int index, E obj) 
    {
        if(index==0||index>=size())
        {
            return null;
        }
        Node<E> node= head;
        int i=0;
        E nono =null;
        while(node.getNext()!= null)
        {
            node=node.getNext();
            if(i==index)
            {
                nono=node.getValue();
                node.setValue(obj);
                return nono ;
            }
            i++;
        }
        return null;
    }

    /**
     *	Return the number of elements that are in the list
     */
    public int size() 
    {
        //Node<E> n= head.getNext();
        //int count=0;
        //while(n!=null)
        //{
        //    count++;
        //    n=n.getNext();
        //}
        //return count;
        return size;
    }

    private int indexOf(E obj)
    {
        int i=0;
        Node<E> n=head.getNext();
        while (n!= null&& !n.getValue().equals(obj))
        {
            i++;
            n=n.getNext();
        }

        if(n==null)
        {
            return -1;
        }
        return i;
    }

    private Node<E> getNode(int index)
    {
        if(index==-1)
        {
            return head;   
        }
        else if(index<0||index>size())
        {
            return null;
        }
        Node<E> n= head.getNext();
        int count=0;
        while (n!=null && count <index)
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
            value=obj;
        }

        public E getValue()
        {
            return value;
        }

        public E setValue(E data)
        {
            E oldValue= value;
            value=data;
            return oldValue;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public Node<E> setNext(Node<E> node)
        {
            Node<E>oldNext=next;
            next=node;
            return oldNext;
        }
    }
}