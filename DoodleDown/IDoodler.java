/**
 * This interface includes the methods which are implemented in Doodler class
 * for notifying the observers attached.
 * @author Chitra 
 * @version 04/25/2014
 */
public interface IDoodler  
{
    public void attach(IDoodlerObserver object);
    public void detach(IDoodlerObserver object);
    public void notifyObservers();
}
