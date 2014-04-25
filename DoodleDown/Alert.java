import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alert here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alert extends Actor
{
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timer;
    
    public Alert(String msg){
        timer=80;
        this.showMessage(msg);
    }
    
    public void act() 
    {
        --timer;
        
        if(timer==0){
            this.removeMessage();
        }else{
            getImage().setTransparency((255*timer)/80);
            setLocation(getX(), getY()-3);
        }
        // Add your action code here.
    }    
    
    
   private void showMessage(String msg){
        //System.out.println( "Clicked!" ) ;
        GreenfootImage gi;
        gi = new GreenfootImage(150,100);
        gi.setColor( java.awt.Color.YELLOW ) ;
        gi.drawString( msg, 0, 50 );
        this.setImage(gi);
   }
   
   private void removeMessage(){
        World world = (DoodleWorld) getWorld();
        world.removeObject(this) ;
    } 
}
