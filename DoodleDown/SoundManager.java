/**
 * Write a description of class SoundManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoundManager extends ConcreteObserver
{
    private boolean soundPlayed=false;
        
    SoundManager(Doodler doodler){
        super(doodler);
    }
    
    //play sound for the desired item
    public void update(){
         if(!soundPlayed) 
            {
                Greenfoot.playSound("power.wav");
                soundPlayed = true;
            }
    }
}
