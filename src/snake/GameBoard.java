package snake;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameBoard extends JFrame{
    
    private GameModel snakeModel;
    
    
    /**
     * This GameBoard Constructor will add all componenets of the game into this GameBoard for 
     * the Composite Design Pattern.
     */
    public GameBoard() {
        snakeModel = new GameModel();
        
        //Components that will be added:
        
        //1. Snake Controller
        //2. Snake View
        //3. Snake Panels

        
    }
}
