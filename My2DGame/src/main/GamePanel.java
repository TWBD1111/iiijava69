package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	private int originalTitleSize = 16;
	private int scale = 3;
	private int titlesize = originalTitleSize * scale;
	private int maxCol = 16;
	private int maxRow = 12;
	private int screenWidth = titlesize * maxCol;// 768pixels
	private int screenHidth = titlesize * maxRow;// 576pixels
	Thread gameThread;
	KeyHandler keyH = new KeyHandler();

	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHidth));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		while (gameThread != null) {

			update();
			repaint();

		}

	}

	public void update() {
		if (keyH.up == true) {
			playerY -= playerSpeed;
			//playerY = playerY - playerSpeed;
		}else if (keyH.down == true) {
			playerY += playerSpeed;
			
		}else if (keyH.left == true) {
			playerX -= playerSpeed;
			
		}else if (keyH.right == true) {
			playerX += playerSpeed;
			
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, titlesize, titlesize);
		;
		g2.dispose();
	}

}
