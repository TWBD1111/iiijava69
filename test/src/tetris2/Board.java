package tetris2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener {
	final int bd_WIDTH = 10, BD_HEIGHT = 20, Block_Size = 30;

	private Timer looper;
	private Color[][] board = new Color[bd_WIDTH][BD_HEIGHT];
	private Color[][] shape = { { Color.RED, Color.RED, Color.RED }, { null, Color.RED, null } };
	private int x = 4, y = 0, FPS = 60, delay = FPS / 1000, normal = 600, fast = 50, delayTimeForMovement = normal,
			deltaX = 0;
	private long beginTime;
	private boolean collision =false;

	public Board() {
		looper = new Timer(delay, new ActionListener() {
			int n = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		looper.start();
	}
	public void update() {
		if(collision) {
			return;
		}
		//判斷左右邊界
		if (!(x + deltaX + shape[0].length > 10) && !(x + deltaX < 0)) {
			x += deltaX;
			
		}
		deltaX = 0;
		if (System.currentTimeMillis() - beginTime > delayTimeForMovement) {
			if(!(y+1+shape.length>BD_HEIGHT)) {//判斷觸底
				y++;
			}else {
				collision =true;
			}
			
			beginTime = System.currentTimeMillis();
		}
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
//		g.setColor(Color.black);
//		g.drawRect(10, 10, 200, 200);
		// 畫方塊
		for (int row = 0; row < shape.length; row++) {
			for (int col = 0; col < shape[0].length; col++) {
				if (shape[row][col] != null) {
					g.setColor(shape[row][col]);
					g.fillRect(col * Block_Size + x * Block_Size, row * Block_Size + y * Block_Size, Block_Size,
							Block_Size);
				}
			}
		}
		// 畫版面
		g.setColor(Color.white);
		for (int row = 0; row < BD_HEIGHT; row++) {// 畫行
			g.drawLine(0, Block_Size * row, Block_Size * bd_WIDTH, Block_Size * row);

		}
		for (int col = 0; col < bd_WIDTH + 1; col++) {// 畫列
			g.drawLine(Block_Size * col, 0, Block_Size * col, Block_Size * BD_HEIGHT);

		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			delayTimeForMovement = fast;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			deltaX = 1;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			deltaX = -1;
		} else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			delayTimeForMovement = fast;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			delayTimeForMovement = normal;
		} else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
			delayTimeForMovement = normal;
		}

	}

}
