/**
 * This class implements the functionalities included in IDoodlerObserver interface
 * 
 * @author (Chitra Soni)
 * @version (04/25/2014)
 */
public class DoodlerObserver implements IDoodlerObserver
{
    protected Doodler doodler;
    
    public DoodlerObserver(Doodler doodler){
        this.doodler = doodler;
    }
    public void update(){
    }
}
