import java.util.List;
import java.util.ArrayList;
public class ListMap<K, V> implements Map <K, V>
{
    private int size;
    private ArrayList<Map.Node<K, V>> list;
    public ListMap()
    {
        list = new ArrayList<Map.Node<K, V>>();
    }

    /*
     *  Return true if this map contains the specified key
     *  Precondition: key != null
     */
    public boolean containsKey(Object key)
    {
        for (Map.Node<K,V> node:list)
        {
            if(node.getKey().equals(key))
            {
                return true;
            }
        }
        return false;
    }

    /*
     *  Return true if this map contins the specified value
     *  Precondition: value != null
     */
    public boolean containsValue(Object value)
    {
        for (Map.Node<K,V> node: list)
        {
            if(node.getValue().equals(value))
            {
                return true;
            }
        }
        return false;
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
        return size;
    }

    /*
     *  Return the value of the Node that has the specified key
     *  If there is no Node with the specified key, then return null
     */
    public V get(Object key)
    {
        for(Map.Node<K,V> node:list)
        {
            if(node.getKey().equals(key))
            {
                return node.getValue();
            }
        }
        return null;
    }

    /*
     *  Associate the specified value with the specified key
     *  If the map already contains the specified key, then replace 
     *  the value of that key and return the original value.
     *  Otherwise add a new Node to the map and return null.
     *  Precondition: key != null && value != null
     */
    public V put(K key, V value)
    {
        for (Map.Node<K,V> n: list)
        {
            if (n.getKey().equals(key))
            {
                V ret= n.getValue();
                n.setValue(value);
                return ret;
            }
        }
        Map.Node<K,V> nee= new Map.Node<K,V>(key,value);
        list.add(nee);
        size++;
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
        for (Map.Node <K,V> n:list)
        {
            if (n.getKey().equals(key))
            {
                V ret= n.getValue();
                list.remove(n);
                size--;
                return ret;
            }
        }
        return null;
    }

    /*
     *  Return a List<V> of the values that are stored in this map
     */
    public List<V> values()
    {
        List<V> ret = new ArrayList<V>();
        for (Map.Node<K,V> node: list)
        {
            ret.add(node.getValue());
        }
        return ret;
    }

    /*
     *  Return a Set<E> of the keys that have associations in this map
     */
    public Set<K> keySet()
    {
        Set<K>ret= new ListSet<K>();
        for (Map.Node<K,V> node: list)
        {
            ret.add(node.getKey());
        }
        return ret;
    }

}