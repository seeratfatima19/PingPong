import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ball extends Rectangle{

	Random rand;
	int xVelocity;
	int yVelocity;
	private int initSpeed = 2;
	
	Ball(int x, int y, int width, int height){
		super(x,y,width,height);
		rand = new Random();
		int randX = rand.nextInt(2);
		if(randX==0)
			randX--;
		setX(randX*initSpeed);
		
		int randY = rand.nextInt(2);
		if(randY==0)
			randY--;
		setY(randY*initSpeed);
	}
	
	public void setY(int y) {
		this.yVelocity=y;
	}
	
	public void setX(int x) {
		this.xVelocity = x;
	}
	
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, height, width);
	}
}
