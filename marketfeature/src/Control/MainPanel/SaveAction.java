package Control.MainPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.*;
import Model.*;

public class SaveAction implements ActionListener {
  private MainFrame mainWindow;
  private TextPanel addTextWindow;
  private Model m;
  
  public SaveAction(MainFrame w,Model m) {
    this.mainWindow = w;
    this.m=m;
  }
  
  
  public void actionPerformed(ActionEvent e) {
	  m.save();
      this.addTextWindow = this.mainWindow.getTextPanel();
      TextStatus t = TextStatus.SAVESUCCESS;
      this.addTextWindow.setTextStatus(t);

    } 

  
}
