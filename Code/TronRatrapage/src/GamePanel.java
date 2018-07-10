import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private	int[][] grid = new int[160][108];
	private int boxx1, boxy1, boxx2, boxy2;
	private int xDir1 = 1;
	private int yDir1 = 0;
	private int xDir2 = -1;
	private int yDir2 = 0;
	private boolean newGame = false;
	private 	boolean[] keys;
	private GameWindow mainFrame;
	private Model model= new Model();
;
	private EndGame endGame = new EndGame();

	public GamePanel(GameWindow m){
		keys = new boolean[KeyEvent.KEY_LAST + 1];
		mainFrame = m;
		boxx1 = 170;
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
	
	
	public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
       keys[e.getKeyCode()] = true;
    }
    
    public void keyReleased(KeyEvent e) {
       keys[e.getKeyCode()] = false;
    }
	

	
	public void move() {

		if (boxx1 + 5 * xDir1 > 798) { // edge

			boxx1 = 0;

		}

		else if (boxx1 + 5 * xDir1 < 2) {

			boxx1 = 795;

		}

		else {

			boxx1 += 5 * xDir1;

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

		}if (model.checkCollision(boxx1, boxy1, boxx2,boxy2,grid) ==1) {
			Main.countTime = System.currentTimeMillis()- Main.countTime;
			System.out.println(Main.countTime);
			//insert bdd method here 
			endGame.winGameP1();
			
		}else  if(model.checkCollision(boxx1, boxy1, boxx2,boxy2,grid) ==2){
			Main.countTime = System.currentTimeMillis()- Main.countTime;
			System.out.println(Main.countTime);
			//insert bdd method here 
			endGame.winGameP2();
			
			
		}
		grid[boxx1 / 5][(boxy1 - 60) / 5] = 1;
		grid[boxx2 / 5][(boxy2 - 60) / 5] = 2;

		System.out.printf("%s,%s\n", Integer.toString(boxx1), Integer.toString(boxy1));
		
		
		
		
	}
	

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



	public void paintComponent(Graphics g) { // 160 x 120 = 19200 elements in grid
		Color tiel = new Color(32, 178, 170);
		Color orange = new Color(255, 140, 0);
		/*System.out.println(Boolean.toString(newGame));
		if (newGame) {
			// System.out.println("Derp");
			newGame = false;
			setBackground(Color.black);
			super.paintComponent(g); // does something that works

		}*/
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
	    }