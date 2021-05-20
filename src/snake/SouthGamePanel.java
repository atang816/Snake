package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 * SouthGamePanel will create the labels for the scores of the snake game
 *
 */
class SouthGamePanel extends JPanel {
         
    //Labels for the score of the game
    private final JLabel scorelabel;
    private final JLabel highScoreLabel;
    

    /**
     * Constructor to set the colors and Jlabels of the scores
     *
     */
    public SouthGamePanel() {
        setBackground(Color.BLACK);
        setLayout(new GridLayout(0, 2));
        
        scorelabel = new JLabel();
        scorelabel.setForeground(Color.white);
        setScoreLabel(0);
        scorelabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        scorelabel.setPreferredSize(new Dimension(100, 30));
        add(scorelabel);
        
        highScoreLabel = new JLabel();
        highScoreLabel.setForeground(Color.white);
        setHighScoreLabel(0);
        highScoreLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        highScoreLabel.setPreferredSize(new Dimension(100, 30));
        add(highScoreLabel);
        

        
    }
    
    /**
     * Setter method for the current score label
     * @param score for the current score
     *
     */
    public void setScoreLabel(int score){
    	scorelabel.setText(" Score: "+ score);
    	
    }
    
    /**
     * Setter method for the high score label
     * @param highScore for the high score to set to
     */
    public void setHighScoreLabel(int highScore) {
    	highScoreLabel.setText(" High Score: "+ highScore);
    }
    

}
