import java.util.ArrayList;
import java.util.List;

public class HashMap<K, V> implements Map<K, V>
{
    private List<Map.Node<K, V>>[] list;

    public HashMap()
    {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public HashMap(int n)
    {
        list = (ArrayList<Map.Node<K, V>>[])new ArrayList[n];

        //populate the array with Lists
        for(int i = 0; i < list.length; i++)
            list[i] = new ArrayList<Map.Node<K, V>>();
    }

    /*
     *  Helper Method: Calculate the index that an object will be stored in an array using its hashCode
     *
     *  Returns the index where key belongs in the instance variable array using the key's hashCode
     *  Becareful about objects that have a negative hashCode! Remember, you can't have a negative index!
     */
    private int getIndex(Object key)
    {
        int index= key.hashCode();
        index= Math.abs(index);
        index = index % list.length;
        return index;
    }

    /*
     *  Return true if this map contains the specified key
     *  Precondition: key != null
     */
    public boolean containsKey(Object key)
    {
        return keySet().contains(key);
    }

    /*
     *  Return true if this map contains the specified value
     *  Precondition: value != null
     */
    public boolean containsValue(Object value)
    {
        return values().contains(value);
    }

    /*
     *  Return true is this map contains no Nodes
     */
    public boolean isEmpty()
    {
        if (size()==0)
        {
            return true;
        }
        return false;
    }

    /*
     *  Return the number of Nodes this map contains
     */
    public int size()
    {
        int size=0;
        for (int i=0; i<list.length;i++)
        {
            size+= list[i].size();
        }
        return size;
    }

    /*
     *  Return the value of the Node that has the specified key
     *  If there is no Node with the specified key, then return null
     */
    public V get(Object key)
    {
        for(Map.Node<K,V> n:list[getIndex(key)])
        {
            if (n.getKey().equals(key))
            {
                return n.getValue();
            }
            
        }
        return null;
    }

    /*
     *  Associate the specified value with the specified key
     *  If the map already contains the specified key, the replace 
     *  the value of that key and return the original value.
     *  Otherwise add a new Node to the map and return null.
     *  Precondition: key != null && value != null
     */
    public V put(K key, V value)
    {
        ArrayList <Map.Node<K,V>> n = (ArrayList) list [getIndex(key)] ;
        for (Map.Node <K,V> j:n)
        {
            if (j.getKey().equals(key))
            {
                return j.setValue(value);
            }
        }
        n.add(new Map.Node<K,V>(key,value));
        return null;
    }

    /*
     *  Remove the association for the specified key from this map.
     *  Return the value that was associated with the specified key
     *  Or return null if no value was associated with the key.
     *  Precondition: key != null
     */
    public V remove(Object key)
    {
        V removal = null;
        for (List<Map.Node<K,V>> node : list)
        {
            for (Map.Node<K,V> jj: node)
            {   
                if (jj.getKey().equals(key))
                {
                     removal = jj.getValue();
                     node.remove(jj);
                     break;
                }
            }
        }   
        return removal;
    }

    /*
     *  Return a List<V> of the values that are stored in this map
     */
    public List<V> values()
    {
        List <V> ret = new ArrayList <V>();
        for (List<Map.Node<K,V>> node : list)
        {
            for(Map.Node<K,V>jj : node)
            {
                ret.add(jj.getValue());
                
            }
        }
        return ret;
    }

    /*
     *  Return a Set<E> of the keys that have associations in this map
     */
    public Set<K> keySet()
    {
        Set <K> ret = new ListSet<K>();
        for (List<Map.Node<K,V>> node : list)
        {
            for(Map.Node<K,V> jj : node)
            {
                ret.add(jj.getKey());
                
            }
        }
        return ret;
    }
}