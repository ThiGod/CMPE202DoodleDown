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
    private int timer = 20;
    private static int CHECKPOINT =20 ; 
    private int score=0;
    GreenfootImage gfi;
    
    public void act() 
    {
        int moveSpeed=1; //World go up speed

        gfi = new GreenfootImage("Score: "+score, 25, java.awt.Color.black, java.awt.Color.white);
        
        if(timer!=CHECKPOINT){
            timer++;
        }
        else{
            timer=0;
            if (!getWorld().getObjects(Ground.class).isEmpty())  
            {  
                Ground grd = (Ground)getWorld().getObjects(Ground.class).get(0);  
                moveSpeed=grd.getSpeed();  
            }  
            addScore(moveSpeed);
        }
        Actor ground=getOneObjectAtOffset(0,0,Ground.class);
        if(ground!=null){
            getWorld().removeObject(ground);
        }
    }
    
    public void addScore(int moveSpeed){
        score=score+1*moveSpeed;
        gfi.drawString("Score: "+score,getX(),getY());
        this.setImage(gfi);
    }
    
    public int getScore(){
        return score;
    }
}
