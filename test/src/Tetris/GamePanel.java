package Tetris;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Tetris.GamePanel.Block;

public class GamePanel extends JPanel {
	private Block curBlock;
	private JFrame mainFrame = null;
	private int x = 0;// x座標
	private int y = 0;// y座標

	public GamePanel() {

	}

	public GamePanel(JFrame frame) {
		this.setLayout(null);
		this.setOpaque(false);
		this.mainFrame = frame;
		mainFrame.setVisible(true);

	}

	public class Block {

		private int x = 0;// x座標
		private int y = 0;// y座標
		boolean xDir;
		int step;
		private GamePanel panel = null;

		public Block(int x, int y, GamePanel panel) {
			this.x = x;
			this.y = y;
			this.panel = panel;
		}

		// 繪製
		void draw(Graphics g) {
			g.fillRect(12 + x * 20, 12 + y * 20, 20, 20);
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		void move(boolean xDir, int step) {
			if (xDir) {// X方向的移动，step 正数向右 负数向左
				x += step;
			} else {// 向下运动
				y += step;
			}
			panel.repaint();
		}

	}

}
