package Graphics;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PageSwitcher extends JPanel{

	private JButton pageDown;
	private JButton pageUp;
	private JLabel text;
	
	private int currentPage=1;
	private int numberOfPage=1;
	
	public PageSwitcher(){

		
		pageDown=new JButton("Next Page");
		pageUp=new JButton("Previous Page");
		text=new JLabel(""+currentPage+"/"+numberOfPage);
		
		add(pageUp);	
		add(text);	
		add(pageDown);
	}
	public JButton getPageDownButton(){
		return pageDown;
	}
	public JButton getPageUpButton(){
		return pageUp;
	}
	public JLabel getText(){
		return text;
	}
	public int getCurrentPage(){
		return currentPage;
	}
	public int getTotalPage(){
		return numberOfPage;
	}
	public void setText(int current,int total){
		currentPage=current;
		numberOfPage=total;
		text.setText(""+currentPage+"/"+numberOfPage);
	}
}
