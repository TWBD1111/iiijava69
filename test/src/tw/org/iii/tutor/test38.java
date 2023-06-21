package tw.org.iii.tutor;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class test38 extends JFrame implements MouseListener{
	private JTextField mesg,mesg2;
	public test38() {
		setLayout(new BorderLayout());
		mesg = new JTextField();
		add(mesg,BorderLayout.NORTH);
		mesg2 = new JTextField();
		add(mesg2,BorderLayout.SOUTH);
		addMouseListener(new MyMouseListener(this));
		addMouseListener(this);
		addMouseListener(new MyMouseListenerV3());
		addMouseListener(new MouseAdapter() {@Override
		public void mousePressed(MouseEvent e) {
					
		}
		});
		setSize(800,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void setMesgText(String mesgtext) {
		mesg.setText(mesgtext);
	}
	public static void main(String[] args) {
		new test38();
		
	}
	class MyMouseListenerV3 extends MouseAdapter{//巢狀類別使用不用互相認識
		@Override
		public void mousePressed(MouseEvent e) {
			mesg.setText("");
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mesg2");
		//setMesgText(" Pressed: "+e.getX()+","+e.getY());
		mesg2.setText(" Pressed: "+e.getX()+","+e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
class MyMouseListener implements MouseListener{
	private test38 test38;
	public MyMouseListener(test38 t38) {
		test38 =t38;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("Clicked");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mesg1");
		//System.out.println(" Pressed: "+e.getX()+","+e.getY());
		test38.setMesgText(" Pressed: "+e.getX()+","+e.getY());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//System.out.println("Released");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//System.out.println("Entered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//System.out.println("Exited");
		
	}
	
}
class MyListener2 extends MouseAdapter{

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
	}
	
}
