package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SmallTextPanel extends JPanel{
	private TextStatus textStatus=TextStatus.WELCOME;
	private int transactionCount=0;
	private final int xText=30;
	private final int yText=15;
	SmallTextPanel(){
	}			
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw textual information based on the current state
		g.setColor(Color.green);
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		switch(textStatus){
		case ADDSUCCESS:
			g.drawString(transactionCount+" item is added to the market!", xText, yText);
			break;
		case ADDFAIL:
			g.setColor(Color.red);
			g.drawString("Invalid information provided!", xText+20, yText);	
			break;
		default:
			break;
		}
	}
	
	public void setTextStatus(TextStatus t){
		//set the textStatus, then update it
		textStatus=t;
		repaint();
	}
	public void incrementCount(){
		transactionCount++;
	}
}
