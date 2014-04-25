/**
 * Write a description of class IDoodler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IDoodler  
{
    public void attach(Observer object);
    public void detach(Observer object);
    public void notifyObservers();
}
