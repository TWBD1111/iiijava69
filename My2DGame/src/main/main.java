package main;

import java.awt.Component;

import javax.swing.JFrame;

import main.GamePanel;

public class main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(3);
		window.setResizable(false);
		window.setTitle("2D 小遊戲");
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		window.setLocationRelativeTo((Component) null);
		window.setVisible(true);
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
}
