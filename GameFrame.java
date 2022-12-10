import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame{
	
	GamePanel p;
	
	GameFrame(){
		p = new GamePanel();
		this.add(p);
		this.setTitle("Ping Pong");
		this.setResizable(false);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
	}

}
