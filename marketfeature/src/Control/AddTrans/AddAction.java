package Control.AddTrans;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
import Control.MainPanel.PageInfo;
import Graphics.*;



public class AddAction implements ActionListener {
  private MainFrame mainPanel;
  private Model m;
  private PageInfo pi;
  private enum Actions {
    DATE, CONFIRM
  }
  
  public AddAction(MainFrame w,Model m,PageInfo pi) {
    this.mainPanel = w;
    this.m=m;
    this.pi=pi;
  }
  
  
  public void actionPerformed(ActionEvent e) {
  
    AddTransactionWindow w = new AddTransactionWindow();   
    ((SmallWindowPane) w.getContentPane()).getConfirm().setActionCommand(Actions.CONFIRM.name());
    ((SmallWindowPane) w.getContentPane()).getConfirm().addActionListener(new AddConfirmAndDateAction(w, this.mainPanel,m,pi));  
    ((SmallWindowPane) w.getContentPane()).getCheckBox().setActionCommand(Actions.DATE.name());
    ((SmallWindowPane) w.getContentPane()).getCheckBox().addActionListener(new AddConfirmAndDateAction(w, this.mainPanel,m,pi)); 
    

    
  }

  
}




