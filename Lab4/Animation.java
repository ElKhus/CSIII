import mayflower.*;
/**
 * Write a description of class Animation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Animation
{   
    private Picture[] frames;
    private int frameRate;
    private int currentFrame;
    /**
     * Constructor for objects of class Animation
     */
    public Animation(int number, String [] imgname)
    {
        frames= new Picture [10];
        for (int i=0;i< imgname.length;i++)
        {
            frames [i] = new Picture (imgname[i]); 
        }
    }
    public int getFrameRate()
    {
        return frameRate;
    }
    public Picture getNextFrame()
    {
        currentFrame= (currentFrame+1)%(frames.length);
        Picture curr= frames[currentFrame];
        return curr;
    }
    public void resize(int w, int h)
    {
        for (int j = 0; j<frames.length;j++)
        {
         frames[j].resize(w,h);   
        }
    }
    public void setTransparency(int percent)
    {
     for (int j = 0; j<frames.length; j++)
     {
      //   frames[j].setTransparency(percent);
        }
    }
}