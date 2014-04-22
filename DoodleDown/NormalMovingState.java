/**
 * Write a description of class NormalMovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NormalMovingState extends MovingState 
{
    public NormalMovingState(Doodler d)
    {
        super(d);
    }
    
    public void doMoveLeft()
    {
        doodler.setLocation(doodler.getX() - doodler.getHorizontalSpeed(), doodler.getY());
    }
    
    public void doMoveRight()
    {
        doodler.setLocation(doodler.getX() + doodler.getHorizontalSpeed(), doodler.getY());
    }
}
