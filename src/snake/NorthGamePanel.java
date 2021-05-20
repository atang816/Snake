
package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import static org.junit.Assert.*;

/**
 * Class for the upper portion of the game where buttons are located
 *
 */
class NorthGamePanel extends JPanel{

	//Buttons for playing the game
    private final JButton play;
    private final JButton newGame;
    boolean gameMode;

    /**
     * Constructor for buttons to be created
     *
     */
    public NorthGamePanel() {
        setBackground(Color.BLACK);
 
        
        play = new JButton("Play");
        play.setBackground(Color.WHITE);
        play.setPreferredSize(new Dimension(100, 30));
        add(play);
        
        newGame = new JButton("New Game");
        newGame.setBackground(Color.WHITE);
        newGame.setPreferredSize(new Dimension(100, 30));
        add(newGame);
        
		System.out.println("North panel is created");

    }
    
    /**
     * Play button listener to be functional
     * @param playAction to make play button functional
     */
    public void addPlayButtonListener(ActionListener playAction){
        play.addActionListener(playAction);
    }
    
    /**
     * New game listener to be functional
     * @param newGameAction to make new game button functional
     *
     */
    public void addNewGameButoonListener(ActionListener newGameAction){
        newGame.addActionListener(newGameAction);
    }
    
    /**
     * Change button from pause to play depending if game is paused or not
     * @param isPlaying to set whether game is paused or not
     *
     */
    public void updatePanelForPlayMode(boolean isPlaying){
        if(isPlaying){
            newGame.setEnabled(false);
            play.setText("Pause");
        }
        else{
            newGame.setEnabled(true);
            play.setText("Play");
        }
    }
    
    /**
     * When game is over, enable new game button
     *
     */
    public void updatePanelForGameOverMode(){
        newGame.setEnabled(true);
        play.setEnabled(false);
        gameMode = false;
        assertEquals(gameMode, false);
		System.out.println("Game over made");
    }
    
    /**
     * Enable play and new game button when game starts again
     *
     */
    public void updatePanelforGameStartMode(){
        newGame.setEnabled(true);
        play.setEnabled(true);
        gameMode = true;
        assertEquals(gameMode, true);

        //Prints when new game pressed
		System.out.println("New game made");

    }
}
