/**
 * Write a description of class SlowMovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlowMovingState extends MovingState 
{   
    private int slowFactor=3;
    public SlowMovingState(Doodler d)
    {
        super(d); //will set the protected variable doodler
    }
    
    public void doMoveLeft()
    {
        doodler.setLocation(doodler.getX() - doodler.getHorizontalSpeed()/slowFactor, doodler.getY());
    }
    
    public void doMoveRight()
    {
        doodler.setLocation(doodler.getX() + doodler.getHorizontalSpeed()/slowFactor, doodler.getY());
    }
}
