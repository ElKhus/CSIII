public class MyArrayList implements MyList
{
    private Object[] o;

    /**
     *  Add obj to the end of the list.
     *  This method always returns true
     */
    public boolean add(Object obj)
    {
        Object[] femp= new Object[size()+1];
        for (int i=0; i<size();i++)
        {
            femp[i]=o[i];
        }
        femp[size()]=obj;
        o=femp;

        return true;
    }

    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj)
    {
        Object[] kemp= new Object[size()+1];
        if (index>=size())
        {
            add(obj);
        }
        else if (index<0)
        {
            kemp[0]= obj;
            for (int i=0;i<size();i++)
            {
                kemp[i+1]=o[i];
            }
            
        }
        else 
        {
            for(int i=0; i<size();i++)
            {
                if(i<index)
                {
                    kemp[i]=o[i];
                }
                kemp[index]=obj;
                if(i > index)
                {
                    kemp[i]=o[i-1];
                }  
            }
        }
        o=kemp;
    }

    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj)
    {
        boolean ft= false;
        for (int i = 0; i<size(); i++)
        {
            if(o[i].equals(obj))
            {
                ft=true;
            }
        }
        return ft;
    }

    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public Object get(int index)
    {
        if (index<size() && index>=0)
        {
            Object f=-1;
            for (int i= 0; i<size();i++)
            {
                if (i==index)
                {
                    f=o[i];
                }
            }
            return f;
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
        boolean check=true;
        for (int i = 0; i<size();i++)
        {
            check= false;
        }
        return check;
    }

    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public Object remove(int index)
    {
        if (size()==0||index>=size()||index<0)
        {
            return null;   
        }

        Object obj=o[index];
        Object[] jemp= new Object[size()-1];
        for (int i = 0; i< jemp.length;i ++)
        {
            if(i<index)
            {
                jemp[i]= o[i];
            }
            else 
            {
                jemp[i]= o[i+1];
            }
        }
        o = jemp;
        return obj;
    }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(Object obj)
    {
        
        for (int i=0; i<size();i++)
        {
            if(o[i]!=null&& o[i].equals(obj))
            {
                remove(i);
                return true;
            }
            
        }
        return false;
    }

    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     * If index is too big or too small, do not change and values and return null
     */
    public Object set(int index, Object obj)
    {
        Object temp=null;
        if (index<size() && index>=0)
        {
            Object[] lemp= new Object[size()];

            for (int i= 0; i<size();i++)
            {
                if (i==index)
                {
                    temp=o[i];
                    lemp[i]= obj;
                }
                else
                {
                    lemp[i]= o[i];
                }
            }
            o=lemp;
            return temp;
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
        if (o==null)
        {
            return 0;
        }
        return o.length;
    }
}