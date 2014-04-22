import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Doodler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Doodler extends Actor
{
    public int moveHorizontalSpeed = 8; //Doodler honrizontal speed
    public int fallingSpeed = 0; //Doodler falling speed
    public int fallingAcceleration = 1; //Doodler falling speed acceleration
    public boolean game = false; //Check the game is done or not
    public boolean soundPlayed = false; //Check whether the sound has played or not.
    public int doodleWorldWide = 400;
    public int doodleWorldHeight = 600;
    private int doodleWide = 40;
    private int doodleHeight = 40;
    private String prevDirection="right"; //the last direction the doodler was facing to 
    public Item currentMovingItem;
    public Item currentProtectionItem;
    
    private IMovingState normalMovingState = new NormalMovingState(this);
    private IMovingState oppositeMovingState = new OppositeMovingState(this);
    public IMovingState currentMovingState = normalMovingState;
    
    private IProtectionState unprotectedState = new UnprotectedState(this);
    private IProtectionState protectedState = new ProtectedState(this);
    public IProtectionState currentProtectionState = unprotectedState;    
    
    private IDoodlerState doodlerFallingState = new DoodlerFallingState(this);
    private IDoodlerState doodlerGroundState = new DoodlerGroundState(this);
    public IDoodlerState currentDoodlerState = doodlerFallingState;

    /**
     * Act - do whatever the Doodler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
    
    public boolean onGround() {
        Actor under = getOneObjectAtOffset(0, (doodleHeight/2), Ground.class);
        boolean onTop = (under!=null && under.getClass() != DeadGround.class);  
        if(onTop){
            soundPlayed = false;
            setDoodlerState(EDoodlerStates.ONGROUND);
            currentDoodlerState.checkGround(under);
        }
        return onTop;
    }
    
    public void checkItems(){
        Actor item = getOneObjectAtOffset(0, (doodleHeight/2), Item.class);
        if(item != null){
            if (!((Item)item).isActivated){
                ((Item)item).startEffect(this);
            }
        }
    }
    
    private void turnAround(String direction){
        if(prevDirection!=direction){
            prevDirection=direction;
            getImage().mirrorHorizontally();
        }
    }
    
    public void checkFall() {
        if(onGround()==true) {
            fallingSpeed = 0;
        } else {
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
                break; 
            case ONGROUND: 
                currentDoodlerState = doodlerGroundState; 
                break; 
        }
        //System.out.println( "Current doodler state: " + currentDoodlerState.getClass().getName());
    }
    
    public void setMovingState(EMovingStates stateName)
    {
        switch(stateName){
            case NORMAL: 
                currentMovingState = normalMovingState;   
                break; 
            case OPPOSITE: 
                currentMovingState = oppositeMovingState; 
                break; 
        }
        //System.out.println( "Current moving state: " + currentMovingState.getClass().getName());
    }
    
    public void setProtectionState(EProtectionStates stateName)
    {
        switch(stateName){
            case PROTECTED: 
                currentProtectionState = protectedState;   
                
                break; 
            case UNPROTECTED: 
                currentProtectionState = unprotectedState; 
                break; 
        }
        //System.out.println( "Current protection state: " + currentProtectionState.getClass().getName());
    }    
}
