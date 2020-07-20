package PongV2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener {
	final int WIDTH=700, HEIGHT=500;
	Thread thread;
	HumanPaddle p1;
	Ball b1;
	AIPaddle p2;
	boolean gameStarted;
	
	public void init() {
		this.resize(WIDTH,HEIGHT);
		this.addKeyListener(this);
		this.b1=new Ball();
		this.p1 = new HumanPaddle(1);
		this.p2 = new AIPaddle(2,b1);
		thread = new Thread(this);
		thread.start();
	}

	public void paint(Graphics arg0) {
		arg0.setColor(Color.black);
		arg0.fillRect(0,0,WIDTH,HEIGHT);
		if (b1.getX()<-10 || b1.getX()>710) {
			arg0.setColor(Color.red);
			arg0.drawString("Game Over",350,250);
		}
		else {
			p1.draw(arg0);
			p2.draw(arg0);
			b1.draw(arg0);
		}
	}

	public void update(Graphics arg0) {
		paint(arg0);
	}

	public void run() {
		for (;;) {
			if(gameStarted){
			p1.move();
			p2.move();
			b1.move();
			b1.checkPaddleCollision(p1,p2);
			}
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
		else if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			gameStarted= true;
		}
			
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		};
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	
}
