/**
 * Write a description of class OppositeMovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OppositeMovingState extends MovingState 
{
    public OppositeMovingState(Doodler d)
    {
        super(d);
    }
    
    public void doMoveLeft()
    {
        doodler.setLocation(doodler.getX() + doodler.getHorizontalSpeed(), doodler.getY());
    }
    
    public void doMoveRight()
    {
        doodler.setLocation(doodler.getX() - doodler.getHorizontalSpeed(), doodler.getY());
    }
}
