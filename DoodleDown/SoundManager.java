/**
 * This class extends the parent class DoodlerObserver and implemets the logic of playing sound on change of Doodler State
 * 
 * @author (Chitra Soni)
 * @version (04/25/2014)
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoundManager extends DoodlerObserver
{
       
    SoundManager(Doodler doodler){
        super(doodler);
    }
    
    //play sound for the desired item
    public void update(){
        playSound();
    }
    
    public void playSound(){
        boolean soundPlayed=false;
        if(!soundPlayed) 
        {
            Greenfoot.playSound("power.wav");
            soundPlayed = true;
        }
    }
}
