package com.piggy.raingame.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard  implements KeyListener{

	private boolean [] keys = new boolean [200];
	public boolean up, down, left, right;
	
	public void update() {
		this.up    = keys[KeyEvent.VK_UP]    || keys[KeyEvent.VK_W];
		this.down  = keys[KeyEvent.VK_DOWN]  || keys[KeyEvent.VK_S];
		this.right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		this.left  = keys[KeyEvent.VK_LEFT]  || keys[KeyEvent.VK_A];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	

}
