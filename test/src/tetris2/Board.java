package tetris2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements KeyListener {
	public static int STATE_GAME_PLAY = 0;
	public static int STATE_GAME_PAUSE = 1;
	public static int STATE_GAME_OVER = 2;
	private int state = STATE_GAME_PLAY;
	final int bd_WIDTH = 10, BD_HEIGHT = 20, Block_Size = 30;

	private Timer looper;
	private Color[][] board = new Color[BD_HEIGHT][bd_WIDTH];

	private Shape[] shapes = new Shape[7];
	private Shape currentShape;
	private int FPS = 60, delay = FPS / 1000;
	private Random random;

	private Color[] colors = { Color.decode("#3A538C"), Color.red, Color.decode("#fff200"),
			Color.decode("#22b14c"), Color.decode("#00a2e8"), Color.decode("#a349a4"), Color.decode("#3f48cc") };

	public Board() {
		random = new Random();
		shapes[0] = new Shape(new int[][] { { 1, 1, 1, 1 } // I
		}, this, colors[0]);
		shapes[1] = new Shape(new int[][] { { 1, 1, 1 }, // T
				{ 0, 1, 0 }

		}, this, colors[1]);
		shapes[2] = new Shape(new int[][] { { 1, 1, 1 }, // L
				{ 1, 0, 0 } }, this, colors[2]);
		shapes[3] = new Shape(new int[][] { { 1, 1, 1 }, // J
				{ 0, 0, 1 } }, this, colors[3]);
		shapes[4] = new Shape(new int[][] { { 0, 1, 1 }, // S
				{ 1, 1, 0 } }, this, colors[4]);
		shapes[5] = new Shape(new int[][] { { 1, 1, 0 }, // Z
				{ 0, 1, 1 } }, this, colors[5]);
		shapes[6] = new Shape(new int[][] { { 1, 1 }, // O
				{ 1, 1 } }, this, colors[6]);

		currentShape = shapes[0];
		looper = new Timer(delay, new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
				repaint();
			}
		});
		looper.start();
	}

	public void update() {
		if (state == STATE_GAME_PLAY) {

			currentShape.update();
		}
	}

	public void setCurrentShape() {
		currentShape = shapes[random.nextInt(shapes.length)];
		currentShape.reset();
		checkOverGame();
	}

	private void checkOverGame() {
		int[][] coords = currentShape.getCoords();
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[0].length; col++) {
				if (coords[row][col] != 0) {
					if (board[row + currentShape.getY()][col + currentShape.getX()] != null) {
						state = STATE_GAME_OVER;
					}
				}
			}
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
//		g.setColor(Color.black);
//		g.drawRect(10, 10, 200, 200);
		currentShape.render(g);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (board[row][col] != null) {
					g.setColor(board[row][col]);
					g.fillRect(col * Block_Size, row * Block_Size, Block_Size, Block_Size);

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
		// clean the board
		if (state == STATE_GAME_OVER) {
			g.setColor(Color.white);
			g.drawString("GAME OVER", 150, 200);
		}
		if (state == STATE_GAME_PAUSE) {
			g.setColor(Color.white);
			g.drawString("GAME PAUES", 150, 200);
		}
	}

	public Color[][] getBoard() {

		return board;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentShape.speedUP();
			
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			currentShape.moveRight();
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			currentShape.movedLeft();
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			currentShape.rotateShape();
		}
		if (state == STATE_GAME_OVER) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				for (int row = 0; row < board.length; row++) {
					for (int col = 0; col < board[0].length; col++) {
						board[row][col] = null;
					}
				}
				setCurrentShape();
				state = STATE_GAME_PLAY;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (state == STATE_GAME_PLAY) {
				state = STATE_GAME_PAUSE;
			}else if (state == STATE_GAME_PAUSE) {
				state = STATE_GAME_PLAY;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentShape.speedDown();
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentShape.speedDown();
		}

	}

}
