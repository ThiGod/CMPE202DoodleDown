/**
 * Write a description of class protectedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtectedState extends ProtectionState 
{
    public ProtectedState(Doodler d)
    {
        super (d);
    }
    
    public boolean doCheckDeath()
    {
        if(doodler.getY() == 0) {
            //getWorld().removeObject(this);
            doodler.setLocation(doodler.getX(), 100);
            
        }
        
        
        if(doodler.getY() == (doodler.doodleWorldHeight-1)) {
            //getWorld().removeObject(this);
            doodler.setFallingSpeed(-15);
        } 
        
        return true;
    }
}
