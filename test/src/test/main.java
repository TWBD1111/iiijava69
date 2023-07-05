package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class main {

	public static final int FRAME_WIDTH = 305;
	public static final int FRAME_HEIGHT = 525;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GameWindow gameWindow = new GameWindow();
				gameWindow.setTitle("Tetris");
				gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gameWindow.setLocationByPlatform(true);
				gameWindow.setSize(FRAME_WIDTH, FRAME_HEIGHT);
				gameWindow.setResizable(false);
				gameWindow.setVisible(true);
				gameWindow.startGame();
			}
		});

	}

}
