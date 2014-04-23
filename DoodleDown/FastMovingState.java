/**
 * Write a description of class FastMovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FastMovingState extends MovingState 
{

    private int fastFactor=3;
    public FastMovingState(Doodler d)
    {
        super(d); //will set the protected variable doodler
    }
    
    public void doMoveLeft()
    {
        doodler.setLocation(doodler.getX() - doodler.getHorizontalSpeed()*fastFactor, doodler.getY());
    }
    
    public void doMoveRight()
    {
        doodler.setLocation(doodler.getX() + doodler.getHorizontalSpeed()*fastFactor, doodler.getY());
    }
}
