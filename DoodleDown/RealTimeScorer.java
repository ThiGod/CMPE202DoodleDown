import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RealTimeScorer extends Actor implements IRealTimeScorer
{
    
    GreenfootImage gfi;
    private int scoretimer = 20;
    private static int SCORECHECKPOINT = 20; 
    private int score = 0;
    
    public void act() 
    {
        if(((DoodleWorld)getWorld()).isPaused){return;} //do nothing if the game is paused
        gfi = new GreenfootImage("Score: " + score, 25, java.awt.Color.black, java.awt.Color.white);
        
        if(scoretimer!=SCORECHECKPOINT){
            scoretimer++;
        } else{
            scoretimer = 0;
            int worldMoveUpSpeed = ((DoodleWorld) getWorld()).getSpeed(); 
            addScore(worldMoveUpSpeed);
        }
        
        Actor ground = getOneObjectAtOffset(0, 0, Ground.class);
        if(ground!=null){
            getWorld().removeObject(ground);
        }
    }    
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public void addScore(int worldSpeed) {
        setScore(score + (1 * worldSpeed));
        gfi.drawString("Score: " + score, getX(), getY());
        this.setImage(gfi);
    }
    
    public void updateScore() {
        //Do Nothing..
    }
}
