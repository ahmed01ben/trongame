package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

import Main.Main;
import Model.Model;

/**
 * <h1>The Class GamePanel.</h1>
 *
 * @author  ahmed
 * @version 1.0
 */
public class GamePanel extends JPanel implements KeyListener  {
	
	//Universal version identifier for a Serializable class.
	private static final long serialVersionUID = 1L;
	
	//attribute used to create a double dimension array int
	private	int[][] grid = new int[160][108];
	
	//attribute used to the moving coordinate point
	private int boxx1, boxy1, boxx2, boxy2;
	
	//attribute corresponding to the direction in x axis of player 1
	private int xDir1 = 1;
	
	//attribute corresponding to the direction in y axis of player 1
	private int yDir1 = 0;
	
	//attribute corresponding to the direction in x axis of player 2
	private int xDir2 = -1;
	
	//attribute corresponding to the direction in y axis of player 2
	private int yDir2 = 0;
	
	//
	private boolean newGame = false;
	
	//attribute used to create a boolean array
	private boolean[] keys;
	
	//attribute corresponding to an GameWindow object
	private GameWindow mainFrame;
	
	//attribute corresponding to a Model object
	private Model model= new Model();
	
	//attribute corresponding to an EndGame object
	private EndGame endGame = new EndGame();
	
	
	/**
	 * The GamePanel method
	 *
	 * It's the constructor and it build a GamePanel thanks to a boolean array
	 *
	 * @param GameWindow m
	 * 
	 */
	public GamePanel(GameWindow m){
		keys = new boolean[KeyEvent.KEY_LAST + 1];
		mainFrame = m;
		setBoxx1(170);
		boxy1 = 170;

		boxx2 = 630;
		boxy2 = 170;

		for (int i = 0; i < 160; i++) {
			for (int j = 0; j < 108; j++) {
				grid[i][j] = 0;
			}
		}

		grid[170 / 5][(170 - 60) / 5] = 1;
		grid[630 / 5][(170 - 60) / 5] = 2;
		setSize(800, 600);
	}
	
	
	/**
	 * The keyTyped method.
	 *
	 * Unused Method.
	 *
	 * @param KeyEvent e
	 * 
	 */
	public void keyTyped(KeyEvent e) {}

	
	/**
	 * The keyPressed method.
	 *
	 * This method is used to set the boolean of the key pressed by the user to true.
	 *
	 * @param KeyEvent e
	 * 
	 */
    public void keyPressed(KeyEvent e) {
       keys[e.getKeyCode()] = true;
    }
    
    
	/**
	 * The keyReleased method.
	 *
	 * This method is used to set the boolean of the key released by the user to false.
	 *
	 * @param KeyEvent e
	 * 
	 */
    public void keyReleased(KeyEvent e) {
       keys[e.getKeyCode()] = false;
    }
	

	/**
	 * The move() method.
	 *
	 * This method is used to make the two player moving.
	 *
	 * @param no parameters
	 * 
	 */
	public void move() {

		if (getBoxx1() + 5 * xDir1 > 798) { // edge

			setBoxx1(0);

		}

		else if (getBoxx1() + 5 * xDir1 < 2) {

			setBoxx1(795);

		}

		else {

			setBoxx1(getBoxx1() + 5 * xDir1);

		}

		if (boxy1 + 5 * yDir1 > 570) {

			boxy1 = 60;

		}

		else if (boxy1 + 5 * yDir1 < 58) {

			boxy1 = 570;

		}

		else {

			boxy1 += 5 * yDir1;
			

		}

		if (boxx2 + 5 * xDir2 > 798) { // p2

			boxx2 = 0;

		}

		else if (boxx2 + 5 * xDir2 < 2) {

			boxx2 = 795;

		}

		else {

			boxx2 += 5 * xDir2;

		}

		if (boxy2 + 5 * yDir2 > 570) {

			boxy2 = 60;

		}

		else if (boxy2 + 5 * yDir2 < 58) {

			boxy2 = 570;

		}

		else {

			boxy2 += 5 * yDir2; 

		}if (model.checkCollision(getBoxx1(), boxy1, boxx2,boxy2,grid) ==1) {
			Main.countTime = System.currentTimeMillis()- Main.countTime;
			System.out.println(Main.countTime);
			//insert bdd method here 
			endGame.winGameP1();
			
		}else  if(model.checkCollision(getBoxx1(), boxy1, boxx2,boxy2,grid) ==2){
			Main.countTime = System.currentTimeMillis()- Main.countTime;
			System.out.println(Main.countTime);
			//insert bdd method here 
			endGame.winGameP2();
			
			
		}
		grid[getBoxx1() / 5][(boxy1 - 60) / 5] = 1;
		grid[boxx2 / 5][(boxy2 - 60) / 5] = 2;

		System.out.printf("%s,%s\n", Integer.toString(getBoxx1()), Integer.toString(boxy1));
		
		
		
		
	}
	
	/**
	 * The changeDir() method
	 *
	 * This method is used to change the direction of the players in x and y axis according to the key pressed  
	 * 
	 * @param no parameters
	 *
	 */
	public void changeDir() {

		if (keys[KeyEvent.VK_D]) {

			if (xDir1 != -1) {

				xDir1 = 1;

				yDir1 = 0;

			}

		}

		if (keys[KeyEvent.VK_Q]) {

			if (xDir1 != 1) {

				xDir1 = -1;

				yDir1 = 0;

			}

			yDir1 = 0;

		}

		if (keys[KeyEvent.VK_Z]) {

			if (yDir1 != 1) {

				yDir1 = -1;

				xDir1 = 0;

			}

		}

		if (keys[KeyEvent.VK_S]) {

			if (yDir1 != -1) {

				yDir1 = 1;

				xDir1 = 0;

			}

		}

		if (keys[KeyEvent.VK_RIGHT]) {

			if (xDir2 != -1) {

				xDir2 = 1;

				yDir2 = 0;

			}

		}

		if (keys[KeyEvent.VK_LEFT]) {

			if (xDir2 != 1) {

				xDir2 = -1;

				yDir2 = 0;

			}

			yDir2 = 0;

		}

		if (keys[KeyEvent.VK_UP]) {

			if (yDir2 != 1) {

				yDir2 = -1;

				xDir2 = 0;

			}

		}

		if (keys[KeyEvent.VK_DOWN]) {

			if (yDir2 != -1) {

				yDir2 = 1;

				xDir2 = 0;

			}

		}

	}


	/**
	 * The paintComponent method
	 *
	 * This method is used to paint the grid according to the player movements
	 * 
	 * @param Graphics g
	 *
	 */
	public void paintComponent(Graphics g) { // 160 x 120 = 19200 elements in grid
		Color tiel = new Color(32, 178, 170);
		Color orange = new Color(255, 140, 0);
		
		/*System.out.println(Boolean.toString(newGame));
		if (newGame) {
			// System.out.println("Derp");
			newGame = false;
			setBackground(Color.black);
			super.paintComponent(g); // does something that works }*/
		
		System.out.printf("%s,%s\n", Integer.toString(xDir1), Integer.toString(yDir1));
		for (int i = 0; i < 800; i += 15) { // grid will be arraylist of [x,y,p1ayer]
			g.drawLine(i, 60, i, 600);
		}

		for (int i = 0; i < 540; i += 15) {
			g.drawLine(0, i + 60, 800, i + 60);
		}

		for (int i = 0; i < 160; i++) {
			for (int j = 0; j < 108; j++) {
				if (grid[i][j] == 1) {
					g.setColor(tiel);
					g.fillRect(i * 5, 5 * j + 60, 5, 5);
				}

				if (grid[i][j] == 2) {
					g.setColor(orange);
					g.fillRect(i * 5, 5 * j + 60, 5, 5);
				}
			}
		}

	}


	public int getBoxx1() {
		return boxx1;
	}


	public void setBoxx1(int boxx1) {
		this.boxx1 = boxx1;
	} 
	    }