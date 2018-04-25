package Control.SearchTrans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.MainPanel.PageInfo;
import Graphics.*;
import Model.Model;

public class SearchAction implements ActionListener {
  private MainFrame temp;
  private Model m;
  private PageInfo pi;
  public SearchAction(MainFrame w,Model m,PageInfo pi) {
    this.temp = w;
    this.m=m;
    this.pi=pi;
  }
  
  
  
  
  public void actionPerformed(ActionEvent e) {
    SearchTransactionWindow w1 = new SearchTransactionWindow();    
    ((SmallWindowPane) w1.getContentPane()).getConfirm().addActionListener(new SearchConfirmAction(w1, this.temp,m,pi));
 
    
  }
}
