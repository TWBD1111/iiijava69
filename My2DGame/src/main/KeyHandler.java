package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	public boolean up,down,left,right;
	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code ==KeyEvent.VK_W) {
			up =true;
		}
		if(code ==KeyEvent.VK_A) {
			down =true;
		}
		if(code ==KeyEvent.VK_S) {
			left =true;
		}
		if(code ==KeyEvent.VK_D) {
			right =true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code ==KeyEvent.VK_W) {
			up =false;
		}
		if(code ==KeyEvent.VK_A) {
			down =false;
		}
		if(code ==KeyEvent.VK_S) {
			left =false;
		}
		if(code ==KeyEvent.VK_D) {
			right =false;
		}
		
	}

}
