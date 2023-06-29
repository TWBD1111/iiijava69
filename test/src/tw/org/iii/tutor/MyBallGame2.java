package tw.org.iii.tutor;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tw.org.iii.classes.MyPanel;
import tw.org.iii.classes.MyPanel2;

public class MyBallGame2 extends JFrame{
	private MyPanel2 myPanel;
	public MyBallGame2() {
		setLayout(new BorderLayout());
		myPanel = new MyPanel2();
		add(myPanel,BorderLayout.CENTER);
		setSize(600,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new MyBallGame2();
	}

}
