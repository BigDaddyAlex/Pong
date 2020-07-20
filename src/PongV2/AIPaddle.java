package PongV2;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle {
	
	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	Ball b1;
	
	
	public AIPaddle(int player, Ball b) {
		this.b1=b; 
		this.upAccel = false;
		this.downAccel = false;
		y=210; yVel=0;
		if(player==1) 
			x=20;
		else x=660;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.clearRect(x, (int)y, 20, 80);
	}

	public void move() {
		
		y=b1.getY()-40;
		
		if(y<0) y=0; 
		if(y>420) y=420;
		
	}
	
	public double getY() {
		return y;
	}	

	

}
