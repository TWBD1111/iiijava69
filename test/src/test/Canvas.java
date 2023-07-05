package test;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class Canvas extends JComponent
{
	private static final long serialVersionUID = 1L;
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < GameWindow.VERTICAL_NODES; i ++)
		{
			for (int j = 0; j < GameWindow.HORIZON_NODES; j ++)
			{
				if (GameWindow.space[i][j] != 0)
					g2.fillRect(j * 20, i * 20, 20, 20);
			}
		}
	}
}
