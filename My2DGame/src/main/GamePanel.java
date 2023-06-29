package main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private int originalTitleSize = 16;
	private int scale = 3;
	private int titlesize = originalTitleSize * scale;
	private int maxCol = 16;
	private int maxRow = 12;
	private int screenWidth = titlesize * maxCol;//768pixels
	private int screenHidth = titlesize * maxRow;//576pixels
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenHidth));
		
	}
	
}
