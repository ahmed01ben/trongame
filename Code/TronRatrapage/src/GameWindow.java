
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

public class GameWindow extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer myTimer;
	private GamePanel game;
	public static boolean WinnerP1 = false;
	public static boolean WinnerP2 = false;
	
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

	public void start() {
		myTimer.start();

	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
		this.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.changeDir();
		game.move();
		game.repaint();

	}

}
