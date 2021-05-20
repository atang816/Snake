package snake;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import static org.junit.Assert.*;

/**
 * GameModel class that keeps track of the grid, score, snake, and apple in game. 
 *
 */
class GameModel {
    
    static final int TOTAL_GAME_AREA = 20;
    
    //Set the cell grid area
    private Cell[][] cellgrid = new Cell[TOTAL_GAME_AREA][TOTAL_GAME_AREA];
    //Keeps track of current score
    private int currentScore = 0;
    //Keeps track of high score
    private int highScore = 0;
    //isPlaying for pausing. False means game is paused
    private boolean isPlaying = false;
    private int timeinterval = 1500;
    private int snakeParts;
    private ArrayList<Point> SnakeCoordinates;
    private Point applePosition;
    private Arrow currentArrow = Arrow.RIGHT;
    private Arrow previousArrow = Arrow.LEFT;
    //boolean to see if user wants to reset game
    private boolean reset = false;
    private boolean snakeIsDead = false;
    
    //Arraylist that keeps how many times apple created for iterator method
    private ArrayList<Integer> applesCreated = new ArrayList<>();
    //Count for how many times apple created
    private int appleCount = 1;
    
    /**
     * Constructor for game model class that starts the game
     *
     */
    public GameModel(){
    	
    	applesCreated.add(appleCount++);
    	
    	
        for (Cell[] cellgrid1 : cellgrid) {
            for (int j = 0; j < cellgrid1.length; j++) {
                cellgrid1[j] = new Cell();
            }
        }
        
        changeApplePosition();
        
        SnakeCoordinates = new ArrayList<>();
        
        updateSnakeParts();
    }
    
    
    /**
     * Change apple position randomly after being eaten
     *
     */
    public void changeApplePosition(){
        int x, y;
        x = new Random().nextInt(TOTAL_GAME_AREA-1);
        y = new Random().nextInt(TOTAL_GAME_AREA-1);
        
        //Prevent overlapping of snake's coordinates and the apple's position
        if(snakeParts>0){
        while (SnakeCoordinates.contains(new Point(x, y))) {            
            x = new Random().nextInt(TOTAL_GAME_AREA-1);
            y = new Random().nextInt(TOTAL_GAME_AREA-1);
        }}
        
        this.applePosition = new Point(x, y);
    }
    
    /**
     * Remove apple from grid
     *
     */
    public void removeApple(){
        
        this.applePosition = new Point(-1, -1);
    }
    
    /**
     * Update array list that keeps all of the snake parts 
     *
     */
    public void updateSnakeParts(){
        this.snakeParts = SnakeCoordinates.size();
    }

    /**
     * Increment the snake part at x y coordinate position
     * @param x for the x coordinate of incremented snake part
     * @param y for the y coordinate of incremented snake part
     *
     */
    public void addNewSnakePart(int x, int y){
        this.SnakeCoordinates.add(new Point(x, y));
    }
    
    /**
     * Change snake coordinates and body parts to new position
     * @param position to get the new position where snake is at
     * @param newX for the new X coordinate snake will be at
     * @param newY for the new Y coordinate snake will be at
     *
     */
    public void altersnakecoordinates(int position, int newX, int newY){
        this.SnakeCoordinates.remove(position);
        this.SnakeCoordinates.add(position, new Point(newX, newY));
    }
    
    /**
     * Get the entire cell grid
     *
     */
    public Cell[][] getCellGrid(){
        return cellgrid;
    }
    
    /**
     * Get the component within the cell at specific position
     * @param x for the x position of cell type
     * @param y for the y position of cell type
     */
    public int getCellType(int x, int y){
        return cellgrid[x][y].getCellType();
    }
    
    /**
     * Set snake, apple, or none in cell grid at specific coordinates
     * @param x for the x coordinate
     * @param y for the y coordinate
     * @param type for the type of component in the cell
     *
     */
    public void setCellType(int x, int y, int type){
        cellgrid[x][y].setCellType(y);
    }
    
    /**
     * Set reset value depending on the user
     * @param reset for the new reset value to set
     */
    public void setReset(boolean reset){
    	this.reset = reset;
    	
    }
    
    /**
     * Set current score value of the game
     * @param set the new current score
     */
    public void setScore(int score){
    	this.currentScore = score;
    	
    }
    
    /**
     * Get the current score of the game
     *
     */
    public int getCurrentScore() {
    	return currentScore;
    	
    }
    
    /**
     * Get the high score value
     *
     */
    public int getHighScore() {
		return highScore;
	}

    /**
     * Set the highScore value
     * @param set the new high score
     */
	public void setHighScore(int highScore) {
	
			this.highScore = highScore;

	}
 
	/**
	 * Set the arrow key to direction if the respective arrow keys are pressed
	 * @param key for the new key pressed by the user
	 */
    public void setArrowKey(String key){
        //other part of the if check to make sure snake only moves forward and not backward
        
        if (key.toLowerCase().equals("up") && !previousArrow.equals(Arrow.DOWN)) {
            this.currentArrow = Arrow.UP;
        }
        else if (key.toLowerCase().equals("down") && !previousArrow.equals(Arrow.UP)) {
            this.currentArrow = Arrow.DOWN;
        }
        else if (key.toLowerCase().equals("right") && !previousArrow.equals(Arrow.LEFT)){
            this.currentArrow = Arrow.RIGHT;
        }
        else if (key.toLowerCase().equals("left") && !previousArrow.equals(Arrow.RIGHT)){
            this.currentArrow = Arrow.LEFT;
        }  
    }
    
    /**
     * Get the user input of the arrow keys
     *
     */
    public String getArrowKey(){
        return this.currentArrow.toString();
    }
    
    /**
     * Increment the current score
     *
     */
    public int incrementScore(){
        currentScore++;
        return currentScore;
    }
    
    /**
     * Increment highScore when greater than current score
     *
     */
    public int incrementHighScore() {
    	highScore++;
    	return highScore;
    }
    
    /**
     * Get the height of the grid of the game
     *
     */
    public int getGridHeight(){
    	return cellgrid.length;
    	
    }
    
    /**
     * Get the width of the grid of the game
     *
     */
    public int getGridWidth(){
    	return cellgrid[0].length;
    	
    }
    
    /**
     * Set if game is paused or not
     * @param isPlaying to set the playing mode on or off
     */
    public void setPlayingMode(boolean isPlaying) {
    	this.isPlaying = isPlaying;
    	
    } 
    
    /**
     * Check if game is paused
     *
     */
    public boolean getPlayingMode() {
    	return isPlaying;
    	
    }
    
    /**
     * Get time interval for how fast game is moving
     *
     */
    public int getTimeInterval(){
    	return timeinterval;
    	
    }
    
    /**
     * Set time interval for how fast the game is moving
     * @param time to set the new time interval
     */
    public void setTimeInterval(int time){
    	this.timeinterval = time;
    	
    }
    
    /**
     * When snake dies, snake parts set to 0, boolean snakeIsDead is true, and arrow keys reset
     *
     */
    public void snakeDies(){
    //snakeIsDead boolean set to true when snake dies and snake coordinates are reset to initial
    	this.snakeIsDead = true;
        this.snakeParts = 0;
        SnakeCoordinates.removeAll(SnakeCoordinates);
        this.previousArrow = Arrow.LEFT;
        this.currentArrow = Arrow.RIGHT;
    }
    
    /**
     * Get snakeIsDead boolean variable
     *
     */
    public boolean getSnakeIsDead() {
    	return this.snakeIsDead;
    }
    
    /**
     * Reset the game when snake is dead, and reset score, apple, arrow keys, and snakeIsDead 
     *
     */
    public void ResetGame(){
        snakeDies();
        setScore(0);
        removeApple();
        this.previousArrow = Arrow.LEFT;
        this.currentArrow = Arrow.RIGHT;
        this.snakeIsDead = false;
    }
    
    /**
     * Check action of the snake in the grid and if game is reset
     *
     */
    public void NextStep(){
    	
    	//Create a new cell grid
        Cell nextVersion[][] = new Cell[TOTAL_GAME_AREA][TOTAL_GAME_AREA];
        
        //Check if game reset
        if(reset){
            ResetGame();
        }
        
        //Else check snake
        else{
        
        //Check snake is dead
        if (snakeParts == 0) {
            addNewSnakePart(0, 2);
            updateSnakeParts();
        }
        else if (snakeParts < 4) {
            addNewSnakePart(0, 2);
            updateSnakeParts();
            updateSnakePosition();
            
        }
        else{
        	updateSnakePosition();
        	
        }
        
        //Check snake eats apple
        if(SnakeCoordinates.get(0).x == applePosition.x && SnakeCoordinates.get(0).y == applePosition.y)
        { 
            eat();
        }
   
        //Check snake touches the boundary
        if(SnakeCoordinates.get(0).x < 0 || SnakeCoordinates.get(0).x > TOTAL_GAME_AREA-1 
        		||SnakeCoordinates.get(0).y <0 ||SnakeCoordinates.get(0).y > TOTAL_GAME_AREA-1)
        {
            snakeDies();
            isPlaying = false;
        	assertEquals(this.snakeIsDead, true);
    		System.out.println("Snake hits head");

        }
        
        //Check snake eats itself
        for (int i = 1; i < SnakeCoordinates.size()-1; i++) {
                if (SnakeCoordinates.get(0).equals(SnakeCoordinates.get(i))) {
                    snakeDies();
                    isPlaying = false;
                	assertEquals(this.snakeIsDead, true);
            		System.out.println("Snake eats itself");
                    break;
                }
            }
                }
        
        //Double for loop to check positioning for apple and snake
        for (int y = 0; y <cellgrid.length; y++) {
            for (int x = 0; x < cellgrid[y].length; x++) {
                if (SnakeCoordinates.contains(new Point(x, y))) {
                    nextVersion[y][x] = new Cell(1);
                }
                else if (applePosition.equals(new Point(x, y))) {
                    nextVersion[y][x] = new Cell(2);
                }
                else {
                	nextVersion[y][x] = new Cell(0);
                	
                }
            }
        }
        
        cellgrid = nextVersion;
    }
    
    /**
     * Change snake position when arrow keys pressed. 
     *
     */
    public void updateSnakePosition(){
        
    	//Move the body of the snake
        for (int i = snakeParts-1; i > 0; i--) {
            altersnakecoordinates(i, SnakeCoordinates.get(i-1).x, SnakeCoordinates.get(i-1).y);
        }
        
        //Check for when arrow keys pressed
        switch (currentArrow) {
            case DOWN:
                altersnakecoordinates(0, SnakeCoordinates.get(0).x, (SnakeCoordinates.get(0).y)+1);
                break;
            case UP:
                altersnakecoordinates(0, SnakeCoordinates.get(0).x, (SnakeCoordinates.get(0).y)-1);
                break;
            case RIGHT:
                altersnakecoordinates(0, (SnakeCoordinates.get(0).x)+1, (SnakeCoordinates.get(0).y));
                break;
            case LEFT:
                altersnakecoordinates(0, (SnakeCoordinates.get(0).x)-1, (SnakeCoordinates.get(0).y));
                break;
            default:
                break;
        }
       
        previousArrow = currentArrow;

        
    }
    
    /**
     * Increment snake body, increment scores, change apple position when apple eaten
     *
     */
    public void eat(){
        addNewSnakePart(SnakeCoordinates.get(snakeParts-1).x, SnakeCoordinates.get(snakeParts-1).y);
        changeApplePosition();
        incrementScore();
        updateSnakeParts();
        
        //Increment apple count and add it to apples created list
        applesCreated.add(appleCount++);
        
		System.out.println("Game Score is incremented");

        
        if(currentScore > highScore) {
        	assertEquals(currentScore > highScore, true);
    		System.out.println("New high score made");
        	incrementHighScore();
        }
    }
    
    /**
     * Iterator method to get how many times apples are created
     *
     */
    public SnakeIterator getApplesCreated() {
    	return new SnakeIterator() {
    		int index = 0;
			@Override
			public int next() {
				// TODO Auto-generated method stub
				int curr = applesCreated.get(index);
    			index++;
    			return curr;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return index < applesCreated.size();
			}
    		
    	};
    }


	
    
    
}
/**
 * Enum with values that represent what keys can be pressed to move snake
 *
 */
enum Arrow {
    UP, DOWN, RIGHT, LEFT
}
