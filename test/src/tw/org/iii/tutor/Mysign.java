package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tw.org.iii.classes.MyClock;
import tw.org.iii.classes.Mydrawer;
import tw.org.iii.classes.Mydrawer2;

public class Mysign extends JFrame {
	private Mydrawer2 myDrawer;
	private JButton clear, undo, redo, saveJPEG, saveObj, loadObj, changeColor;
	private MyClock myClock;
	public Mysign() {
		super("簽名app");

		setLayout(new BorderLayout());
		myDrawer = new Mydrawer2();
		add(myDrawer, BorderLayout.CENTER);
		clear = new JButton("清除");
		undo = new JButton("上一步");
		redo = new JButton("復原");
		saveJPEG = new JButton("存檔");
		saveObj = new JButton("序列化");
		loadObj = new JButton("解序列化");
		changeColor = new JButton("換顏色");
		myClock = new MyClock();
		JPanel top = new JPanel(new FlowLayout());
		top.add(clear);top.add(undo);top.add(redo);top.add(saveJPEG);
		top.add(saveObj);top.add(loadObj);top.add(changeColor);top.add(myClock);
		add(top, BorderLayout.NORTH);
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initEvent();
	}

	private void initEvent() {
		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.clear();

			}
		});
		undo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.undo();

			}
		});
		redo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.redo();

			}
		});
		saveJPEG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myDrawer.saveJPEG();

			}
		});
		saveObj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.saveLines();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		loadObj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					myDrawer.loadLines();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		changeColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// myDrawer.setColor(Color.BLACK);
				Color newColor = JColorChooser.showDialog(null, "換顏色", myDrawer.getColor());
				if (newColor != null) {
					myDrawer.setColor(newColor);
				}

			}
		});
	}

	public static void main(String[] args) {
		new Mysign();
	}

}
