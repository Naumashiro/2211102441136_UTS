import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PalaSnake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PalaSnake extends Actor
{
    private final int EAST = 0;
    private final int SOUTH = -90;
    private final int WEST = 180;
    private final int NORTH = 270;
    private final int SPEED = 4;
    private int counter = 0;
    
    private int foodEaten = 0;
    public PalaSnake()
    {
        GreenfootImage img = new GreenfootImage(20,20);
        img.setColor(Color.RED);
        img.fill();
        setImage(img);
        setRotation(Greenfoot.getRandomNumber(4)*90);
    }
    
    public void act()
    {
        moveAround();
        if(isTouching(Food.class)) {
            World myWorld = getWorld();
            SnakeField snakeworld = (SnakeField)myWorld;
            Score score = snakeworld.getScore();
            score.addScore();
            removeTouching(Food.class);
            foodEaten++;
            SnakeField world = (SnakeField)getWorld();
            world.addFood();
        }
        
        if(isTouching(Tail.class)) {
            SnakeField myWorld = (SnakeField) getWorld();
            myWorld.displayYouLose();
        }
        
        if(facingEdge()) {
            SnakeField myWorld = (SnakeField) getWorld();
            myWorld.displayYouLose();
        }
    }
    
    private boolean facingEdge()
    {
        switch( getRotation() ) {
            case EAST: return getX()==getWorld().getWidth()-0.5;
            case SOUTH: return getY()==getWorld().getHeight()-0.5;
            case WEST: return getX()==-1;
            case NORTH: return getY()==-1;
        }
        return false;
    }
    
    private void moveAround()
    {
        counter ++;
        if(counter==SPEED) {
            getWorld().addObject(new Tail(foodEaten*SPEED), getX(), getY());
            move(1);
            counter = 0;
        }
        if(Greenfoot.isKeyDown("right")) {
            setRotation(EAST);
        }
        if(Greenfoot.isKeyDown("down")) {
            setRotation(SOUTH);
        }
        if(Greenfoot.isKeyDown("left")) {
            setRotation(WEST);
        }if(Greenfoot.isKeyDown("up")) {
            setRotation(NORTH);
        }
    }
}
