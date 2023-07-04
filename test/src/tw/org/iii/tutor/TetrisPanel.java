package tw.org.iii.tutor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetrisPanel extends JPanel {
    private static final int ROWS = 20;
    private static final int COLS = 10;
    private static final int SQUARE_SIZE = 30;
    private static final int DELAY = 300; // 方块下落的延迟时间（毫秒）

    private Timer timer;
    private boolean[][] grid;
    private Tetromino currentTetromino;

    public TetrisPanel() {
        setPreferredSize(new Dimension(COLS * SQUARE_SIZE, ROWS * SQUARE_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);

        grid = new boolean[ROWS][COLS];

        timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveDown();
            }
        });
        timer.start();

        addKeyListener(new TetrisKeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制方块
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col]) {
                    int x = col * SQUARE_SIZE;
                    int y = row * SQUARE_SIZE;
                    g.setColor(Color.CYAN);
                    g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                }
            }
        }

        // 绘制当前的俄罗斯方块
        if (currentTetromino != null) {
            for (Point square : currentTetromino.getSquares()) {
                int x = square.x * SQUARE_SIZE;
                int y = square.y * SQUARE_SIZE;
                g.setColor(Color.CYAN);
                g.fillRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    private void moveDown() {
        if (currentTetromino == null || !isValidMove(currentTetromino, 1, 0)) {
            // 方块到达底部或无法继续向下移动时，固定方块并生成新的方块
            if (currentTetromino != null) {
                for (Point square : currentTetromino.getSquares()) {
                    grid[square.y][square.x] = true;
                }
            }
            currentTetromino = TetrominoFactory.createRandomTetromino();
        } else {
            // 向下移动方块
            currentTetromino.move(1, 0);
        }

        repaint();
    }

    private boolean isValidMove(Tetromino tetromino, int dx, int dy) {
        for (Point square : tetromino.getSquares()) {
            int newX = square.x + dx;
            int newY = square.y + dy;

            if (newX < 0 || newX >= COLS || newY < 0 || newY >= ROWS || grid[newY][newX]) {
                return false; // 无效移动
            }
        }

        return true; // 有效移动
    }

    private class TetrisKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (currentTetromino == null) {
                return;
            }

            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    if (isValidMove(currentTetromino, 0, -1)) {
                        currentTetromino.move(0, -1);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (isValidMove(currentTetromino, 0, 1)) {
                        currentTetromino.move(0, 1);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (isValidMove(currentTetromino, 1, 0)) {
                        currentTetromino.move(1, 0);
                    }
                    break;
                case KeyEvent.VK_UP:
                    Tetromino rotated = currentTetromino.rotate();
                    if (isValidMove(rotated, 0, 0)) {
                        currentTetromino = rotated;
                    }
                    break;
            }

            repaint();
        }
    }
    public class Tetromino {
        private Point[] squares;

        public Tetromino(Point[] squares) {
            this.squares = squares;
        }

        public Point[] getSquares() {
            return squares;
        }

        public void move(int dx, int dy) {
            for (Point square : squares) {
                square.x += dx;
                square.y += dy;
            }
        }

        public Tetromino rotate() {
            Point[] rotatedSquares = new Point[squares.length];

            for (int i = 0; i < squares.length; i++) {
                int x = squares[i].y;
                int y = -squares[i].x;
                rotatedSquares[i] = new Point(x, y);
            }

            return new Tetromino(rotatedSquares);
        }
    }

public class TetrominoFactory {
    private static final Point[][] SHAPES = {
            // 俄罗斯方块的形状
            {new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1)}, // 方块
            {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(3, 0)}, // 横条
            {new Point(0, 0), new Point(0, 1), new Point(0, 2), new Point(0, 3)}, // 竖条
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(2, 1)}, // 右L型
            {new Point(0, 0), new Point(1, 0), new Point(1, -1), new Point(2, -1)}, // 左L型
            {new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(1, -1)}, // T型
            {new Point(0, 0), new Point(1, 0), new Point(2, 0), new Point(1, -1)} // 山形
    };

    private static final Color[] COLORS = {
            Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.BLUE, Color.ORANGE, Color.GREEN, Color.RED
    };

    private static final Random random = new Random();

    public static Tetromino createRandomTetromino() {
        int shapeIndex = random.nextInt(SHAPES.length);
        Point[] squares = SHAPES[shapeIndex];
        Color color = COLORS[shapeIndex];

        return new Tetromino(squares, color);
    }
}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TetrisPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
