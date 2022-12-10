import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paddle extends Rectangle{
	
	int id;
	int yVelocity;
	int speed =10;
	
	Paddle(){
		
	}
	
	Paddle(int x, int y, int pWidth, int pHeight, int id){
		super(x,y,pWidth,pHeight);
		this.id= id;
		
	}
	public void keyPressed(KeyEvent e) {
		
		if(this.id==1) {
			if(e.getKeyCode()== KeyEvent.VK_W) {
				
				setY(-speed);
				move();
			}
			if(e.getKeyCode()== KeyEvent.VK_S) {
				
				setY(speed);
				move();
			}
				
		}
		
		if(this.id==2) {
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				setY(-speed);
				move();
			}
			
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {	
				setY(speed);
				move();
			}
				
		}
		
		
			
	}
	
	public void keyReleased(KeyEvent e) {
		
		if(this.id==1) {
			if(e.getKeyCode()== KeyEvent.VK_W) {
				
				setY(0);
				move();
			}
			if(e.getKeyCode()== KeyEvent.VK_S) {
				
				setY(0);
				move();
			}
			
		}
		
		if(this.id==2) {
			if(e.getKeyCode()== KeyEvent.VK_UP) {
				
				setY(0);
				move();
			}
			if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				
				setY(0);
				move();
			}
				
		}
	}
	
	public void setY(int y) {
		this.yVelocity = y;
	}
	
	public void move() {
		y= y+yVelocity;  // y-coordinate inherited from rectangle class
	}
	
	public void draw(Graphics g) {
		
		if(this.id==1) {
			g.setColor(Color.BLUE);
		}
		else
			g.setColor(Color.CYAN);
		
		g.fillRect(x, y, width, height);
	}

}
