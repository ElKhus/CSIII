import java.util.LinkedList;
import static java.lang.System.*;
public class Runner
{
    public static void main(String[] args)
    {
        //This is where the user inputs their To-Do list
        OptionGen test = new OptionGen(new String[]{"homework","go to the movies","sleep","get food","go running","clean the house","feed the birds","do COMPUTER SCIENCE :)"});
        out.println(test);
    }
}
