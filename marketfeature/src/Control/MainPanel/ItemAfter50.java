package Control.MainPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ItemAfter50 implements ActionListener {
	private PageInfo pi;
	public ItemAfter50(PageInfo pi){
		this.pi=pi;
	}
  
  public void actionPerformed(ActionEvent e) {
    pi.pageDown(); 
    
  }  
  
}
