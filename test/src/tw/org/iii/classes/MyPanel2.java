package tw.org.iii.classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyPanel2 extends JPanel {
	private BufferedImage ball0;
	private int ballX, ballY, ballW, ballH;
	private HashSet<BallTask> balls;

	public MyPanel2() {
		setBackground(Color.GREEN);
		balls = new HashSet<>();
		try {
			ball0 = ImageIO.read(new File("dir1/ball0.png"));
			ballW = ball0.getWidth();
			ballH = ball0.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MyListener myListener = new MyListener();
		addMouseListener(myListener);
	}

	private class MyListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX(), y = e.getY();
			changeBall(x, y);
		}
	}

	void changeBall(int x, int y) {
		BallTask ball = new BallTask();
		ballX = (int) (x - (ballW * 0.5));
		ballY = (int) (y - (ballH * 0.5));
		balls.add(ball);
		Timer timer = new Timer();
		timer.schedule(ball, 0, 10);
		repaint();
	}

	private class BallTask extends TimerTask {
		int x, y;
		int xSpeed, ySpeed;
		public BallTask() {
			xSpeed = (int) (Math.random() * 10) - 5; 
			ySpeed = (int) (Math.random() * 10) - 5;
		}

		@Override
		public void run() {
            x += xSpeed;
            y += ySpeed;
            if (x < 0 || x + ballW > getWidth()) {
                xSpeed = -xSpeed; 
            }
            if (y < 0 || y + ballH > getHeight()) {
                ySpeed = -ySpeed;
            }
            repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (BallTask ball : balls) {
			g.drawImage(ball0, ball.x, ball.y, null);
		}
	}
}
