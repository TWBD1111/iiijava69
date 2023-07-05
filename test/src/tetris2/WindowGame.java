package tetris2;

import javax.swing.JFrame;

public class WindowGame extends JFrame {
	final int WIDTH = 445, HEIGHT = 644;
	private Board board;
	public WindowGame() {
		super("俄羅斯方塊");
		setSize(WIDTH, HEIGHT);
		board =new Board();
		add(board);
		addKeyListener(board);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new WindowGame();
	}

}
