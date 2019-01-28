import junit.framework.*; 
import java.util.*;
public class MySetTester extends TestCase
{
    public static void main(String[] args)
    {
        //Write code here to test your MySet class
    }

    public void testestest()
    {
        {
            Set<String> stringystring = new MySet<String>();

            stringystring.add("I");
            stringystring.add("Really");
            stringystring.add("Hope");
            stringystring.add("This");
            stringystring.add("Works");
            assertEquals("size should not change when a duplicated value is added (last value)", 5, stringystring.size());

            stringystring.add("IT DOES :)");
            assertEquals("size should change when a value is added", 6, stringystring.size());

        }
    }
}