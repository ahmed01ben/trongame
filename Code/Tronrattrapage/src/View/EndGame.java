package View;

import javax.swing.JOptionPane;

import Model.LorannBDDConnector;

/**
 * <h1>The Class EndGame.</h1>
 *
 * @author Ben Mbarek Ahmed
 * @version 1.0
 */

public class EndGame {

	// attributes winGameP1 and winGameP2 corresponding to the JOptionPane objects used in this class
	JOptionPane winGameP1, winGameP2;
	public static String p1 = "Orange";
	public static String p2 = "Bleu";
	/**
	 * The winGameP1() method.
	 *
	 * This Method creates a pop up window that informs players, it is the player1 who has won
	 * 
	 * @param no
	 *            parameters
	 */
	public void winGameP1() {
		GameWindow.WinnerP1 = true;
		new LorannBDDConnector();
		winGameP1 = new JOptionPane();
		int result = JOptionPane.showConfirmDialog(winGameP1, "Close the game ?", " " + p1 + " player You win !",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION)
			System.exit(0);
		if (result != JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	/**
	 * The winGameP2() method.
	 *
	 * This Method creates a pop up window that informs players, it is the player2 who has won.
	 * 
	 * @param no
	 *            parameters
	 */
	public void winGameP2() {
		GameWindow.WinnerP1 = false;
		new LorannBDDConnector();
		winGameP2 = new JOptionPane();
		int result = JOptionPane.showConfirmDialog(winGameP2, "Close the game ?", " " + p2 + " player You win !",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION)
			System.exit(0);
		if (result != JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
}
