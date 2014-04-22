/**
 * Write a description of class UnprotectedState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnprotectedState extends ProtectionState 
{
    public UnprotectedState(Doodler d)
    {
        super (d);
    }
    
    public boolean doCheckDeath()
    {
        if(doodler.getY() == 0) {
            //getWorld().removeObject(this);
            return false;
        }
        
        
        if(doodler.getY() == (doodler.doodleWorldHeight-1)) {
            //getWorld().removeObject(this);
            return false;
        } 
        
        return true;
    }
}
