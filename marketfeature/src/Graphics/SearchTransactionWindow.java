package Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SearchTransactionWindow extends JFrame{
	private final int windowLength = 500;
	private final int windowHeight = 300;

	private JPanel contentPane;
	
	public SearchTransactionWindow(){
		super("Search For a Transaction");
		// set the size of the window, and set its close operation

		this.setBounds(200, 200, windowLength, windowHeight);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		contentPane=new SmallWindowPane(false,windowLength,windowHeight);

		// set the color of the frame to make it looks better
		
		
		//the window contains some text fields, a button for confirmation and a button to clear
		
		
		//finally, put our contentPane into the frame and make it visible
		setContentPane(contentPane);
		setVisible(true);
	}
	
  public JPanel getContentPane() {
    return contentPane;
  }	
	
}
