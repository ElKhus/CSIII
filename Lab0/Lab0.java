// name: Elina Khusnatdinov
// date: August 17th
// per:  7

public class Lab0
{

    public Lab0()
    {
        // do not update the constructor
    }

    public  void display (int min, int max)
    {
        while (min!= max+1)
        {
            System.out.println(checkValue (min++));
        }
    }

    public String checkValue(int value)
    {
        String ret="";
       if (value%3 == 0  && value%5 == 0)
       {
          ret= "Pokemon";
       }
       else if (value%3 ==0)
       {
           ret="Poke";
        }
       else if (value%5 == 0 )
       {
          ret= "mon";  
        }
       return ret; 
    }
}
