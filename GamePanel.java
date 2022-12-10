import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
	
	static final int PANEL_WIDTH =1000;
	static final int PANEL_HEIGHT =(int)(PANEL_WIDTH*(0.5555));
	static final Dimension SCREEN_SIZE = new Dimension(PANEL_WIDTH,PANEL_HEIGHT);
	static final int ball_diameter =20;
	static final int PADEL_WIDTH =25;
	static final int PADEL_HEIGHT =100;
	Thread gameThread;
	Image im;
	Graphics gr;
	Random rand;
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score sc;
	
	
	GamePanel(){
		newPaddles();
		newBall();
		sc = new Score(PANEL_WIDTH,PANEL_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new Al());
		this.setPreferredSize(SCREEN_SIZE);
		
		gameThread= new Thread(this);
		gameThread.start();
		
		
	}
	
	public void newBall() {
		rand= new Random();
		ball = new Ball((PANEL_WIDTH/2)-(ball_diameter/2),(PANEL_HEIGHT/2)-(ball_diameter/2),ball_diameter,ball_diameter);
		
		
		
	}
	
	public void newPaddles() {
		paddle1= new Paddle(0,(PANEL_HEIGHT/2)-(PADEL_HEIGHT/2),PADEL_WIDTH,PADEL_HEIGHT,1);
		paddle2= new Paddle(PANEL_WIDTH -PADEL_WIDTH,(PANEL_HEIGHT/2)-(PADEL_HEIGHT/2),PADEL_WIDTH,PADEL_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		
		im = createImage(getWidth(),getHeight());
		gr = im.getGraphics();
		draw(gr);
		g.drawImage(im,0,0,this);
		
	}
	
	public void draw(Graphics g) {
		
		paddle1.draw(g);
		paddle2.draw(g);
		ball.draw(g);
		sc.draw(g);
	}
	
	public void move() {
		
		paddle1.move();
		paddle2.move();
		ball.move();
	}

	public void checkCollision() {
		
		
		// bounce ball off paddles
		if(ball.intersects(paddle1))
		{
			ball.xVelocity= Math.abs(ball.xVelocity);
			//for increasing difficulty
			ball.xVelocity++;
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			///////////////////////
					
			ball.setX(ball.xVelocity);
			ball.setY(ball.yVelocity);
		}			
		
		
		if(ball.intersects(paddle2))
		{
			ball.xVelocity= Math.abs(ball.xVelocity);
			//for increasing difficulty
			ball.xVelocity++;
			if(ball.yVelocity>0)
				ball.yVelocity++;
			else
				ball.yVelocity--;
			///////////////////////
					
			ball.setX(-ball.xVelocity);
			ball.setY(ball.yVelocity);
		}
		
		// stops paddles at window edges
		if(paddle1.y<=0)
			paddle1.y=0;
		
		if(paddle1.y>= (PANEL_HEIGHT - PADEL_HEIGHT))
			paddle1.y = PANEL_HEIGHT - PADEL_HEIGHT;
		
		if(paddle2.y<=0)
			paddle2.y=0;
		
		if(paddle2.y>= (PANEL_HEIGHT - PADEL_HEIGHT))
			paddle2.y = PANEL_HEIGHT - PADEL_HEIGHT;
		
		// deflect ball at window edges
		if(ball.y<=0)
			ball.setY(-ball.yVelocity);
		if(ball.y >= PANEL_HEIGHT- ball_diameter)
			ball.setY(-ball.yVelocity);
		
	
		////////////////////////////
		
		// giving points
		if(ball.x<=0) {
			sc.player2++;
			
			newPaddles();
			newBall();
			
		}
							
		if(ball.x>= PANEL_WIDTH - ball_diameter) {
			sc.player1++;

		
			newPaddles();
			newBall();
			
		}
				
				
	} 
	
	public void run() {
		
		// gameloop
		long lastTime = System.nanoTime();
		double amtTicks = 60.0;
		double ns = 1000000000/amtTicks;
		double delta =0;
		
		while(true) {
			
			long now = System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime =now;
			
			if(delta>=1) {
				move();
				checkCollision();
				if(sc.player1==10)
				{
					JFrame f1 = new JFrame("PLAYER 1 WINS!");
					break;
				}
				if(sc.player2==10)
				{
					JFrame f2 = new JFrame("PLAYER 2 WINS!");
					break;
				}
				repaint();
				delta--;
			}
			
		}
		
		/*
		// game loop new 
		while(true) {
			if(sc.player1>=10) {
				JFrame j= new JFrame("PLYER 1 WINS");
				
			}
			
			if(sc.player2>=10) {
				JFrame j = new JFrame("PLAYER 2 WINS");
			}
		}// end new while 
		*/
	}
	
	public class Al extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e) {
			
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
		
	}// end Al
	
	
}
