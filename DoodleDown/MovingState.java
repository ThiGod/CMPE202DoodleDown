/**
 * Write a description of class MovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MovingState implements IMovingState
{
    protected Doodler doodler;
    
    public MovingState(Doodler d)
    {
        doodler = d;
    }
    
    public void doMoveLeft()
    {
        //do nothing
    }
    
    public void doMoveRight()
    {
        //do nothing
    }
}
