package tetris2;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	final int bd_WIDTH = 10, BD_HEIGHT = 20, Block_Size = 30;
	private int x = 4, y = 0, FPS = 60, delay = FPS / 1000, normal = 600, fast = 50, delayTimeForMovement = normal,
			deltaX = 0;
	private long beginTime;
	private boolean collision = false;
	private int[][] coords;
	private Board board;
	private Color color;

	public Shape(int[][] coords, Board board, Color color) {
		this.coords = coords;
		this.board = board;
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void reset() {
		this.x = 4;
		this.y = 0;
		collision = false;
	}

	public void update() {
		if (collision) {// 填滿方塊顏色
			for (int row = 0; row < coords.length; row++) {
				for (int col = 0; col < coords[0].length; col++) {
					if (coords[row][col] != 0) {
						board.getBoard()[y + row][x + col] = color;

					}
				}
			}
			checkLine();
			board.setCurrentShape();

			return;
		}
		// 判斷左右邊界
		boolean moveX = true;
		if (!(x + deltaX + coords[0].length > 10) && !(x + deltaX < 0)) {
			for (int row = 0; row < coords.length; row++) {// 判斷左右碰撞
				for (int col = 0; col < coords[row].length; col++) {
					if (coords[row][col] != 0) {
						if (board.getBoard()[y + row][x + deltaX + col] != null) {
							moveX = false;
						}
					}
				}
			}
			if (moveX) {
				x += deltaX;
			}

		}
		deltaX = 0;
		if (System.currentTimeMillis() - beginTime > delayTimeForMovement) {
			// 垂直移動
			if (!(y + 1 + coords.length > BD_HEIGHT)) {// 判斷觸底
				for (int row = 0; row < coords.length; row++) {
					for (int col = 0; col < coords[row].length; col++) {
						if (coords[row][col] != 0) {
							if (board.getBoard()[y + 1 + row][x + deltaX + col] != null) {
								collision = true;

							}
						}
					}
				}
				if (!collision) {
					y++;
				}
			} else {
				collision = true;
			}

			beginTime = System.currentTimeMillis();
		}
	}

	public void checkLine() {
		int bottomLine = board.getBoard().length - 1;
		for (int topLine = board.getBoard().length - 1; topLine > 0; topLine--) {
			int count = 0;
			for (int col = 0; col < board.getBoard()[0].length; col++) {
				if (board.getBoard()[topLine][col] != null) {
					count++;
				}
				board.getBoard()[bottomLine][col] = board.getBoard()[topLine][col];
			}
			if (count < board.getBoard()[0].length) {
				bottomLine--;
			}
		}
	}

	public void rotateShape() {
		int[][] rotatedShape = transposeMatrix(coords);
		reversRows(rotatedShape);
		// check for right side and bottom
		if ((x + rotatedShape[0].length > board.bd_WIDTH) || (y + rotatedShape.length > 20)) {
			return;
		}
		// check for collision with other shapes before retated
		for (int row = 0; row < rotatedShape.length; row++) {
			for (int col = 0; col < rotatedShape[row].length; col++) {
				if (rotatedShape[row][col] != 0) {
					if (board.getBoard()[y + row][x + col] != null) {
						return;
					}
				}

			}
		}
		coords = rotatedShape;
	}

	private int[][] transposeMatrix(int[][] matrix) {
		int[][] temp = new int[matrix[0].length][matrix.length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				temp[col][row] = matrix[row][col];

			}
		}
		return temp;
	}

	private void reversRows(int[][] matrix) {
		int middle = matrix.length / 2;
		for (int row = 0; row < middle; row++) {
			int[] temp = matrix[row];
			matrix[row] = matrix[matrix.length - row - 1];
			matrix[matrix.length - row - 1] = temp;
		}
	}

	public void render(Graphics g) {
		// 畫方塊
		for (int row = 0; row < coords.length; row++) {
			for (int col = 0; col < coords[0].length; col++) {
				if (coords[row][col] != 0) {
					g.setColor(color);
					g.fillRect(col * Block_Size + x * Block_Size, row * Block_Size + y * Block_Size, Block_Size,
							Block_Size);
				}
			}
		}
	}

	public void speedUP() {
		delayTimeForMovement = fast;
	}

	public void speedDown() {
		delayTimeForMovement = normal;
	}

	public void moveRight() {
		deltaX = 1;
	}

	public void movedLeft() {
		deltaX = -1;
	}
	public int getY() {
		return y;
	}
	
	public int getX() {
		return x;
	}
	
	
	
	public int[][]getCoords(){
		return coords;
	}

}
