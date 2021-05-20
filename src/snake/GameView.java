
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * This is the view class that will set the view of the game when user began.
 * There are methods to update snake coordinates and change the color of each cell accordingly.
 */
class GameView extends JComponent {
    
    private Cell[][] snakeGame;
    
    public GameView(){ }
    
    /**
     * Key listener to get arrow key inputs
     * @param keyCode get key inputs
     * @param Name for the name of the key
     * @param action for action fo key
     *
     */
    public void addKeyArrowListener(int keyCode, String Name, Action action){
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(keyCode, 0), Name);
        getActionMap().put(Name, action);
    }
    
    /**
     * Component paint method to display snake and apple
     * @param g for the Graphics for the view
     */
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        
        for (int i = 0; i<snakeGame.length; i++){
            for (int j = 0; j < snakeGame[i].length; j++) {
                if (snakeGame[i][j].isSnake()) {
                    g2d.setColor(Color.GREEN);
                } else if (snakeGame[i][j].isApple()) {
                    g2d.setColor(Color.RED);
                }
                else{
                    g2d.setColor(Color.BLACK);
                }
                g2d.fill(snakeGame[i][j].getCircle());
            }
        }
        
        g2d.setColor(Color.RED);
        //+20 is just to put some space from the border
        g2d.drawRect(0+20, 0+20, 400, 400);
    }
    
    /**
     * Setter method for the cells of the grid
     * @param allCells for all of the cells for the grid
     */
    public void setCells(Cell[][] allCells){
        this.snakeGame = allCells;
    }
    
    /**
     * Getter method for the cells
     *
     */
    public Cell[][] getCells(){
    	return snakeGame;
    	
    }
            
}
