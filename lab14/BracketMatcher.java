 import java.util.Stack;
import java.util.LinkedList;
public class BracketMatcher
{

    public static void main(String[] args)
    {

    }

    public static String matchBrackets(String str)
    {
        Stack<String> s= new Stack<String>();
        for(int i=0;i<str.length();i++)
        {
            String letter = str.substring(i,i+1);
            String left="{[(";
            String right="}])";
            if(left.indexOf(letter)>-1)
            {
                s.push(letter);
            }
            else if(right.indexOf(letter)>-1)
            {
                if (s.isEmpty())
                {
                    return "Too many closing brackets";
                }
                else
                {
                    if(letter.equals(")"))
                    {
                        if(!s.peek().equals("("))
                        {
                            return "Bracket mismatch";
                        }
                        s.pop();
                    }
                    else if(letter.equals("]"))
                    {
                        if(!s.peek().equals("["))
                        {
                            return "Bracket mismatch";
                        }
                        s.pop();
                    }
                    else if(letter.equals("}"))
                    {
                        if(!s.peek().equals("{"))
                        {
                            return "Bracket mismatch";
                        }
                        s.pop();
                    }
                }
            }
        }
        if (s.isEmpty())
        {
            return "Balanced";
        }
        else
        {
            return "Not enough closing brackets";
        }
    }
}