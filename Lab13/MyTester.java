import junit.framework.*; 
import java.util.*;

public class MyTester extends TestCase
{
    public void testestest()
    {
        Queue<String> qq = new MyQueue<String>();
        
        qq.add("False:"); //remove this because I was able to make this code work :)
        qq.add("True:");
        qq.add("I");
        qq.add("was");
        qq.add("able");
        qq.add("to");
        qq.add("do");
        qq.add("this");
        qq.add("lab");
        qq.add(":)");
        
        String obj= qq.remove();
        assertEquals("remove() should return the first Object in the queue", "False:", obj);
    }
}
