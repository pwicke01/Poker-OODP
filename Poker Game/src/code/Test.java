package code;

import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		final int FRAME_WIDTH = 1200;
		final int FRAME_HEIGHT = 400;
		
		JFrame pokerGame = new UI();
		pokerGame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		pokerGame.setTitle("A Poker Game.");
	    pokerGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    pokerGame.setVisible(true);
	}
}
