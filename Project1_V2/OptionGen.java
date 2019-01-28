import java.util.LinkedList;
import java.util.Random;
public class OptionGen
{
    private LinkedList <String> list;

    /**
     * Constructor for objects of class OptionGen
     */
    public OptionGen()
    {
        list=new LinkedList<String>();
    }
    
    public OptionGen(String[] nums)
    {
        list=new LinkedList<String>();
        for(int i=0;i<nums.length; i++)
        {
            list.add(nums[i]);
        }
    }
    //This is what is output to the user
    public String toString()
    {
        String output= "I think the first thing you should do is... "+ getRandomOption() +"!!!";
        return output;
    }
    //This finds a random index within the range and finds the String
    //that coresponds to that index
    public String getRandomOption()
    {
        int count=0;
        for(int i=0; i<list.size();i++)
        {
            count++;
        }
        int ranNum = (int)(Math.random()*count);
        return list.get(ranNum);
    }

}
