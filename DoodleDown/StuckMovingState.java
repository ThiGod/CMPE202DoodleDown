/**
 * Write a description of class StuckMovingState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StuckMovingState extends MovingState 
{   
    
    public StuckMovingState(Doodler d)
    {
        super(d); //will set the protected variable doodler
    }
    
    public void doMoveLeft()
    {   
        if(!doodler.stucked) {
        doodler.setLocation(doodler.getX() - doodler.getHorizontalSpeed(), doodler.getY());  
        }
        
    }
    
    public void doMoveRight()
    {   
       if(!doodler.stucked) {
        doodler.setLocation(doodler.getX() + doodler.getHorizontalSpeed(), doodler.getY());
       }
    }
}
