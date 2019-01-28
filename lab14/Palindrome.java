import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Palindrome
{

    public static void main(String[] args)
    {

    }

    public static boolean isPalindrome(String str)
    {
        Stack<String> s= new Stack<String>();
        Queue<String> q=new LinkedList<String>();

        for(int i=0;i<str.length();i++)
        {
            String letter = str.substring(i,i+1);
            String legal="abcdefghijklmnopqrstuvwxyz";
            if(legal.indexOf(letter.toLowerCase())>-1)
            {
                if(letter!=" ")
                {
                    q.add(letter.toLowerCase());
                    s.push(letter.toLowerCase());
                }
            }
        }
        while(!q.isEmpty())
        {
            if (! q.remove().equals(s.pop()))
            {
                return false;
            }
        }
        return true;
    }
}