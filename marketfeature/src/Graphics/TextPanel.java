package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TextPanel extends JPanel{
	private TextStatus textStatus=TextStatus.WELCOME;
	private final int xText=25;
	private final int yText=100;
	TextPanel(){
		this.setPreferredSize(new Dimension(200,200));
	}			
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//draw textual information based on the current state
		g.setColor(Color.green);
		g.setFont(new Font("Serif", Font.PLAIN, 24));
		switch(textStatus){
		case WELCOME:
			g.drawString("3EA3 final project",xText,yText);
			g.drawString("Market Center Demo!",xText+30,yText+25);
			break;
		case SAVESUCCESS: 
			g.drawString("All changes are saved", xText, yText);
			g.drawString("successfully!",xText+30,yText+25);
			break;
		case SAVEFAIL:
			g.setColor(Color.red);
			g.drawString("Save failed!", xText, yText);
			break;
		case ADDSUCCESS:
			g.drawString("The item is", xText, yText);
			g.drawString("added to the program!",xText,yText+25);
			break;
		case ADDFAIL:
			g.setColor(Color.red);
			g.drawString("Item cannot", xText, yText);	
			g.drawString("be added!",xText+45,yText+25);
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
}

