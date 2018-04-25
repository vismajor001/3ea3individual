package Graphics;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private final int windowLength = 1500;
	private final int windowHeight = 800;

	private JPanel contentPane = new JPanel();
	
	private InfoTable info;
	private SortButtonPanel sortBP;
	private PageSwitcher ps;
	private TextPanel textPanel;
	
	public MainFrame() {
		super("3EA3 project market trade center for online game");
		// set the size of the window, and set its close operation

		this.setBounds(200, 200, windowLength, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the color of the frame to make it looks better
		contentPane.setBackground(Color.white);

		contentPane.setLayout(null);
		
		info=new InfoTable(windowLength/2,windowHeight/2);
		//put the table in the middle of the frame
		info.setBounds(windowLength/4, windowHeight/4 - 100, windowLength/2, windowHeight/2);
		contentPane.add(info);
		
		//add a button panel
		sortBP=new SortButtonPanel();
		sortBP.setBounds(windowLength/4, 3*windowHeight/4+10, windowLength/2, 100);
		contentPane.add(sortBP);
		//add a panel for page switching
		ps=new PageSwitcher();
		int psLength=300;
		ps.setBounds(windowLength/2-psLength/2,3*windowHeight/4 - 100,300,50);
		contentPane.add(ps);
		//add a text panel that displays informations
		textPanel=new TextPanel();
		textPanel.setBounds(20,windowHeight/2-150,300,300);
		contentPane.add(textPanel);
		
		
		//finally, put our contentPane into the frame and make it visible
		setContentPane(contentPane);
		setVisible(true);
				
	}
	public InfoTable getInfoTable(){
		return info;
	}
	public SortButtonPanel getSortButtonPanel(){
		return sortBP;
	}
	public PageSwitcher getPageSwitcher(){
		return ps;
	}
  public TextPanel getTextPanel(){
    return textPanel;
  }	
}
