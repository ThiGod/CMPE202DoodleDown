import greenfoot.*;
import java.awt.Font;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreKeeper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreKeeper extends Actor
{
    /**
     * Act - do whatever the ScoreKeeper wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int scoretimer = 20;
    private static int SCORECHECKPOINT =20 ; 
    private int score=0;
    GreenfootImage gfi;
    
    public void act() 
    {
        //int worldMoveUpSpeed=1; //World go up speed
        if(((DoodleWorld)getWorld()).isPaused){return;} //do nothing if the game is paused
        gfi = new GreenfootImage("Score: "+score, 25, java.awt.Color.black, java.awt.Color.white);
        
        if(scoretimer!=SCORECHECKPOINT){
            scoretimer++;
        }
        else{
            scoretimer=0;
             
            int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed(); 
             
            addScore(worldMoveUpSpeed);
        }
        Actor ground=getOneObjectAtOffset(0,0,Ground.class);
        if(ground!=null){
            getWorld().removeObject(ground);
        }
    }
    
    public void addScore(int worldMoveUpSpeed){
        score=score+1*worldMoveUpSpeed;
        gfi.drawString("Score: "+score,getX(),getY());
        this.setImage(gfi);
    }
    
    public int getScore(){
        return score;
    }
}
