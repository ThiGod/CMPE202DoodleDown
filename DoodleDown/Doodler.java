import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * This class implements all the functionalities of the Doodler
 * 
 * @author (Ameya Joshi, Chitra Soni, Chung Fang, Ling Zhang, Surbhi Vijaywargia, Yulin Ye, Yang Song)
 */
public class Doodler extends Actor implements IDoodler
{
    public int moveHorizontalSpeed = 8; //Doodler honrizontal speed
    public int fallingSpeed = 0; //Doodler falling speed
    public int fallingAcceleration = 1; //Doodler falling speed acceleration
    public boolean game = false; //Check the game is done or not
    public boolean soundPlayed = false; //Check whether the sound has played or not.
    public boolean stucked=false; // check whether the doodler is stucked or not
    public int doodleWorldWide = 400;
    public int doodleWorldHeight = 600;
    private int doodleWide = 40;
    private int doodleHeight = 40;
    private String prevDirection="right"; //the last direction the doodler was facing to 
    public Item currentMovingItem;
    public Item currentProtectionItem;
    
    public ArrayList<IDoodlerObserver> itemObservers = new ArrayList<IDoodlerObserver>(); // maintaining a list of observers for observing item hit
    private boolean observersAttached = false; 

    private IMovingState normalMovingState = new NormalMovingState(this);
    private IMovingState oppositeMovingState = new OppositeMovingState(this);
    private IMovingState fastMovingState = new FastMovingState(this);
    private IMovingState slowMovingState = new SlowMovingState(this);
    private IMovingState stuckMovingState = new StuckMovingState(this);
    public IMovingState currentMovingState = normalMovingState;
    public EMovingStates currentMovingStateName =EMovingStates.NORMAL;
    
    private IProtectionState unprotectedState = new UnprotectedState(this);
    private IProtectionState protectedState = new ProtectedState(this);
    public IProtectionState currentProtectionState = unprotectedState;
    public EProtectionStates currentProtectionStateName =EProtectionStates.UNPROTECTED;
    
    private IDoodlerState doodlerFallingState = new DoodlerFallingState(this);
    private IDoodlerState doodlerGroundState = new DoodlerGroundState(this);
    public IDoodlerState currentDoodlerState = doodlerFallingState;
    public EDoodlerStates currentDoodlerStateName = EDoodlerStates.FALLING;

    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!observersAttached){
            attach(new SoundManager(new Doodler()));
            observersAttached=true;
        }
        if(((DoodleWorld)getWorld()).isPaused){
            return;
        } //do nothing if the game is paused
        if(checkDeath()) {
            doodlerMoveUp();
            checkKeys();
            checkFall();
            checkItems();
        } else { 
           ((DoodleWorld)getWorld()).gameOver();
        }
    }    
    
    //attaching object to the list of observers
    public void attach(IDoodlerObserver object){
        itemObservers.add(object);
    }
    
    public void detach(IDoodlerObserver object){
        itemObservers.remove(object);
    }
    
    private void checkKeys() {
        if(Greenfoot.isKeyDown("left")) {
            turnAround("left");
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) {
            turnAround("right");
            moveRight();
        }
    }
    
    public boolean checkDeath() {
        return currentProtectionState.doCheckDeath();
    }
    
    public void setFallingSpeed(int s){
        fallingSpeed = s;
    }
    
    public int getFallingSpeed(){
        return fallingSpeed;
    }
    
    public void setHorizontalSpeed(int s){
        moveHorizontalSpeed = s;
    }
    
    public int getHorizontalSpeed(){
        return moveHorizontalSpeed;
    }
    
    public int returnHeight() {
        int h = getY();
        return h;
    }
    
    public void doodlerMoveUp() {
        int worldMoveUpSpeed=((DoodleWorld) getWorld()).getSpeed();
        setLocation(getX(), getY() - worldMoveUpSpeed);
    }
    
    
    public void checkItems(){
        Actor item = getOneObjectAtOffset(0, (doodleHeight/2), Item.class);
        if(item != null){
            if (!((Item)item).isActivated){
                ((Item)item).startEffect(this);
                notifyObservers();
            }
        }
    }
    
    //notify the item observer classes on item hit
    public void notifyObservers(){
        for (IDoodlerObserver object: itemObservers){
            object.update();
        }
    }
    
    private void turnAround(String direction){
        if(prevDirection!=direction){
            prevDirection=direction;
            getImage().mirrorHorizontally();
        }
    }
    
    public void checkFall() {
        Actor underDoodlerGround = getOneObjectAtOffset(0, (doodleHeight/2), Ground.class);
        boolean onTop = (underDoodlerGround!=null && underDoodlerGround.getClass() != DeadGround.class);
        if(onTop) {
            if(this.currentDoodlerStateName!=EDoodlerStates.ONGROUND) //avoid resetting all the time
            setDoodlerState(EDoodlerStates.ONGROUND);
            soundPlayed = false;
            fallingSpeed = 0;
            currentDoodlerState.checkGround(underDoodlerGround);
            //will call Ground startGroundEffect,
            // then set the MovingState according to different gournd
        } else {
            if(this.currentDoodlerStateName!=EDoodlerStates.FALLING)//avoid resetting all the time
            setDoodlerState(EDoodlerStates.FALLING);
            currentDoodlerState.fall();
        }
    }
    
    public void moveLeft() {
        currentMovingState.doMoveLeft();
    }
    
    public void moveRight() {
        currentMovingState.doMoveRight();
    }
    
    public void setWorldSpeed(int speed)
    {
        ((DoodleWorld) getWorld()).setSpeed(speed);
    }
    
    public void setDoodlerState(EDoodlerStates stateName)
    {
        switch(stateName){
            case FALLING: 
                currentDoodlerState = doodlerFallingState;
                currentDoodlerStateName =EDoodlerStates.FALLING;
                break; 
            case ONGROUND: 
                currentDoodlerState = doodlerGroundState;
                currentDoodlerStateName =EDoodlerStates.ONGROUND;
                break; 
        }
        //System.out.println( "Current doodler state: " + currentDoodlerState.getClass().getName());
    }
    
    public void setMovingState(EMovingStates stateName)
    {
        switch(stateName){
            case NORMAL: 
                currentMovingState = normalMovingState;
                currentMovingStateName =EMovingStates.NORMAL;
                break; 
            case OPPOSITE: 
                currentMovingState = oppositeMovingState;
                currentMovingStateName =EMovingStates.OPPOSITE;
                break; 
            case FAST: 
                currentMovingState = fastMovingState;
                currentMovingStateName =EMovingStates.FAST;
                break; 
            case SLOW: 
                currentMovingState = slowMovingState;
                currentMovingStateName =EMovingStates.SLOW;
                break; 
            case STUCK: 
                currentMovingState = stuckMovingState;
                currentMovingStateName =EMovingStates.STUCK;
                break;                
        }
        //System.out.println( "Current moving state: " + currentMovingState.getClass().getName());
    }
    
    
    public void setProtectionState(EProtectionStates stateName)
    {
        switch(stateName){
            case PROTECTED: 
                currentProtectionState = protectedState;   
                currentProtectionStateName =EProtectionStates.PROTECTED;
                break; 
            case UNPROTECTED: 
                currentProtectionState = unprotectedState;
                currentProtectionStateName =EProtectionStates.UNPROTECTED;
                break; 
        }
        //System.out.println( "Current protection state: " + currentProtectionState.getClass().getName());
    }    
}
