package Tetris;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import Tetris.GamePanel.Block;


public class BackPanel extends JPanel implements ActionListener {
	BackPanel panel = this;
	private JFrame mainFrame = null;
	private Block curBlock;
	private GamePanel gamePanel;
	private GameFrame frame;
	
	JMenuBar jmb = null;
	int ROWS =20; //15行20列
	int COLS =15;
	// 構造裡面初始化相關引數
	public BackPanel(JFrame frame) {
		this.setLayout(null);
		this.setOpaque(false);
		this.mainFrame = frame;
		mainFrame.setVisible(true);
		initMenu();
		init();
	}

	private void initMenu() {
		// 建立選單及選單選項
		jmb = new JMenuBar();
		JMenu jm1 = new JMenu("遊戲");
		jm1.setFont(new Font("標楷體", Font.BOLD, 15));// 設定選單顯示的字型
		JMenu jm2 = new JMenu("幫助");
		jm2.setFont(new Font("標楷體", Font.BOLD, 15));// 設定選單顯示的字型

		JMenuItem jmi1 = new JMenuItem("開始新遊戲");
		JMenuItem jmi2 = new JMenuItem("退出");
		jmi1.setFont(new Font("標楷體", Font.BOLD, 15));
		jmi2.setFont(new Font("標楷體", Font.BOLD, 15));

		JMenuItem jmi3 = new JMenuItem("操作說明");
		jmi3.setFont(new Font("標楷體", Font.BOLD, 15));
		JMenuItem jmi4 = new JMenuItem("失敗判定");
		jmi4.setFont(new Font("標楷體", Font.BOLD, 15));

		jm1.add(jmi1);
		jm1.add(jmi2);

		jm2.add(jmi3);
		jm2.add(jmi4);

		jmb.add(jm1);
		jmb.add(jm2);
		mainFrame.setJMenuBar(jmb);// 選單Bar放到JFrame上
		jmi1.addActionListener(this);
		jmi1.setActionCommand("Restart");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("Exit");

		jmi3.addActionListener(this);
		jmi3.setActionCommand("help");
		jmi4.addActionListener(this);
		jmi4.setActionCommand("lost");
	}
	private void init() {	

		// 開始/停止按鈕
		JButton btnStart = new JButton();
		btnStart.setFont(new Font("標楷體", Font.PLAIN, 18));
		btnStart.setFocusPainted(false);
		btnStart.setText("暫停");
		btnStart.setBounds(360, 300, 80, 43);
		btnStart.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(btnStart);
		btnStart.addActionListener(this);
		btnStart.setActionCommand("start");
        int x = 0;
        int y = 0;
        //curBlock = new Block(x, y,this);
	
	}

	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("標楷體", Font.ITALIC, 18)));
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("標楷體", Font.ITALIC, 18)));
		if ("Exit".equals(command)) {
			Object[] options = { "確定", "取消" };
			int response = JOptionPane.showOptionDialog(this, "您確定要退出嗎", "", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(response==0) {
				System.exit(0);
			}
		
		}else if("Restart".equals(command)) {			
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawBorder(g);
		drawBorderRight(g);
		drawGrid(g);
		drawCount(g);
		drawNext(g);
        if (curBlock != null) {
            curBlock.draw(g);
        }
	}
	private void drawBorder(Graphics g) {
		BasicStroke bs_2=new BasicStroke(12L,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		Graphics2D g_2d=(Graphics2D)g;
		g_2d.setColor(new Color(128,128,128));
		g_2d.setStroke(bs_2);

		RoundRectangle2D.Double rect = new RoundRectangle2D.Double(6, 6, 313 - 1, 413 - 1, 2, 2);
		g_2d.draw(rect);
	}
	private void drawBorderRight(Graphics g) {
		BasicStroke bs_2=new BasicStroke(12L,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		Graphics2D g_2d=(Graphics2D)g;
		g_2d.setColor(new Color(128,128,128));
		g_2d.setStroke(bs_2);
		
		RoundRectangle2D.Double rect = new RoundRectangle2D.Double(336, 6, 140 - 1, 413 - 1, 2, 2);
		g_2d.draw(rect);
		//g_2d.drawRect(336, 6, 140, 413);
		
	}

	//繪製積分割區域
	private void drawCount(Graphics g) {
		BasicStroke bs_2=new BasicStroke(2L,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		Graphics2D g_2d=(Graphics2D)g;
		g_2d.setColor(new Color(0,0,0));
		g_2d.setStroke(bs_2);
		g_2d.drawRect(350, 17, 110, 80);
		
		//得分
		g.setFont(new Font("標楷體", Font.BOLD, 20));
		g.drawString("得分：",380, 40);
	}
	//繪製下一個區域
	private void drawNext(Graphics g) {
		BasicStroke bs_2=new BasicStroke(2L,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER);
		Graphics2D g_2d=(Graphics2D)g;
		g_2d.setColor(new Color(0,0,0));
		g_2d.setStroke(bs_2);
		g_2d.drawRect(350, 120, 110, 120);
		
		//得分
		g.setFont(new Font("標楷體", Font.BOLD, 20));
		g.drawString("下一個：",360, 140);
	}
	//繪製網格
	private void drawGrid(Graphics g) {
		Graphics2D g_2d=(Graphics2D)g;
		g_2d.setColor(new Color(255,255,255,150));
		float strokeWidth = 2.0f;//調整網格線的粗細
		g_2d.setStroke(new BasicStroke(strokeWidth));
		int x1=12;
		int y1=20;
		int x2=312;
		int y2=20;
		for (int i = 0; i <= ROWS; i++) {
			y1 = 12 + 20*i;
			y2 = 12 + 20*i;
			g_2d.drawLine(x1, y1, x2, y2);		
		}
		
		y1=12;
		y2=412;
		for (int i = 0; i <= COLS; i++) {
			x1 = 12 + 20*i;
			x2 = 12 + 20*i;
			g_2d.drawLine(x1, y1, x2, y2);		
		}
	}
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
    public BackPanel(GameFrame frame) {
        this.frame = frame;
    }
}