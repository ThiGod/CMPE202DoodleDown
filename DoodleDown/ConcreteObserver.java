/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteObserver implements Observer
{
    protected Doodler doodler;
    
    public ConcreteObserver(Doodler doodler){
        this.doodler = doodler;
    }
    public void update(){
    }
}
