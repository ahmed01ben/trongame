package View;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * <h1>The Class GameWindow.</h1>
 *
 * @author ahmed
 * @version 1.0
 */
public class GameWindow extends JFrame implements ActionListener {

	//
	private static final long serialVersionUID = 1L;
	
	//attribute used to create a timer object
	private Timer myTimer;
	
	//attribute used to create a GamePanel object
	private GamePanel game;
	
	//attribute used to send the winner player to the database
	public static boolean WinnerP1 = false;
	
	/**
	 * The GameWindow() Method
	 *
	 * This Method is used to builds the game window.
	 * It also serves to refresh the window every 25 milliseconds to see the movements of players
	 * 
	 * @param no parameters
	 * 
	 */
	public GameWindow() {

		super("TRON");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setSize(800, 600);
		setBackground(Color.black);
		// trigger every 100 ms
		myTimer = new Timer(25, this);
		game = new GamePanel(this);
		add(game);
		addKeyListener(game);

		setResizable(false);
		setVisible(true);
	}

	/**
	 * The start() Method
	 *
	 * This Method is used to start the timer.
	 * 
	 * @param no parameters
	 * 
	 */
	public void start() {
		myTimer.start();

	}

	/**
	 * The addNotify() Method
	 *
	 * This Method is used to start the timer.
	 * 
	 * @param no parameters
	 * 
	 */
	public void addNotify() {
		super.addNotify();
		requestFocus();
		this.start();
	}

	/**
	 * The actionPerformed method
	 *
	 * This Method is used to make the players move and it repaints the panel thanks to the method saw before
	 * 
	 * @param ActionEvent e
	 *
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		game.changeDir();
		game.move();
		game.repaint();

	}

}
