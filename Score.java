import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Score extends Rectangle{
	
	static int GAME_WIDTH;
	static int GAME_HEIGHT;
	int player1;
	int player2;
	
	Score(){
		
	}
	
	Score(int width, int height){
		Score.GAME_WIDTH=width;
		Score.GAME_HEIGHT=height;
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.setFont(new Font("Consolas",Font.PLAIN,50));
		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85,50);
		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20,50);
		
	}
}
