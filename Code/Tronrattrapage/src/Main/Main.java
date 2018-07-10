package Main;

import View.GameWindow;

/**
 * TRONGAME
 * 
 * <h1>The Class Main.</h1>
 * 
 * @author ahmed
 * @version 1.0
 */

public class Main {
	
	/* this attribute give to the user the time spent for a game.
	*/
	
public static long countTime;

	/**
	 * Main method. this method lunch the counter time
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		countTime=System.currentTimeMillis();
		 new GameWindow();
	}

}
