package Tetris;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Tetris.GamePanel.Block;

public class GameFrame extends JFrame {
	private JButton stop;
	private Block curBlock;
	public GameFrame() {
		super("俄羅斯方塊");//設定標題setTitle也行
		setSize(500, 490);//設定尺寸
		setLayout(new BorderLayout());
		stop = new JButton("暫停");
		JPanel right = new JPanel(new FlowLayout());
		add(right, BorderLayout.EAST);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//點選關閉按鈕是關閉程式
        setLocationRelativeTo(null);   //設定居中
    	setResizable(false); //不允許修改介面大小
    	
	}
	private void createKeyListener() {
		KeyAdapter l = new KeyAdapter() {
			//按下
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				switch (key) {
					//空格
					case KeyEvent.VK_SPACE:
						break;
						
					//向上
					case KeyEvent.VK_UP:
					case KeyEvent.VK_W:
						break;
						
					//向右	
					case KeyEvent.VK_RIGHT:
					case KeyEvent.VK_D:
						if(curBlock!=null) curBlock.move(true, 1);
						break;
						
					//向下
					case KeyEvent.VK_DOWN:
					case KeyEvent.VK_S:
						if(curBlock!=null) curBlock.move(false, 1);
						break;
						
					//向左
					case KeyEvent.VK_LEFT:
					case KeyEvent.VK_A:
						if(curBlock!=null) curBlock.move(true, -1);
						break;
				}
			
			}
			//鬆開
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
		};
		addKeyListener(l);
	}
}