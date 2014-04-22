/**
 * Write a description of class ProtectionState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ProtectionState implements IProtectionState  
{
    protected Doodler doodler;
    
    public ProtectionState(Doodler d)
    {
        doodler = d;
    }
    
    public boolean doCheckDeath()
    {
        return true;    
    }

}
