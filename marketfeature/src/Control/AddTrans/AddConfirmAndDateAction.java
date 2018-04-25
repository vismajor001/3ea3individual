package Control.AddTrans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.MainPanel.PageInfo;
import Graphics.AddTransactionWindow;
import Graphics.InfoTable;
import Graphics.MainFrame;
import Graphics.SmallWindowPane;
import Graphics.TextPanel;
import Graphics.TextStatus;
import Model.Model;
import Model.Transaction;

import java.util.*;
import java.io.*;


public class AddConfirmAndDateAction implements ActionListener {
  private AddTransactionWindow addPanel;
  private MainFrame mainPanel;
  private TextPanel mainTextPanel;
  private static int count = 0;
  private Model m;
  private PageInfo pi;

  private enum Actions {
    DATE, CONFIRM
  }

  public AddConfirmAndDateAction(AddTransactionWindow w, MainFrame w1,Model m,PageInfo pi) {
    this.addPanel = w;
    this.mainPanel = w1;
    this.m=m;
    this.pi=pi;
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == Actions.CONFIRM.name()) {
     
      // update small window data
      String[] addedData = ((SmallWindowPane) this.addPanel.getContentPane()).confirm();
      // uncheck the check box
      if (((SmallWindowPane) this.addPanel.getContentPane()).getCheckBox()
          .isSelected()) {
        ((SmallWindowPane) this.addPanel.getContentPane()).getCheckBox().setSelected(false);
        ((SmallWindowPane) this.addPanel.getContentPane()).deselectCurrentDate();
        this.count = 0;
      }              
      if (addedData!=null){
      String tmp = addedData[0];
      addedData[0] = addedData[1];
      addedData[1] = tmp;
      
      m.add(new Transaction(Float.parseFloat(addedData[0]), addedData[1], addedData[2], addedData[3]));
      
      Transaction[] trans=m.getTransactionList();
      
      
      int count=0;
      //count the total number of pages
      for (Transaction i:trans) if (i!=null) count++;
      int numPage=(int) Math.ceil(count/50.0);
      Object[][][] allPageData=new Object[numPage][50][4];
      int pageCount=0;
      count=0;
      for (Transaction i:trans){
      	//set up the object array 
      	//format: [description,amount,date,user]
      	if (i!=null ){
      		allPageData[pageCount][count][0]=i.getDescription();
      		allPageData[pageCount][count][1]=i.getAmount();
      		allPageData[pageCount][count][2]=i.getDate();
      		allPageData[pageCount][count][3]=i.getUser();
      		count++;
      		if (count>=50){
      			count=0;
      			pageCount++;
      		}
      	
      	}  	
      }
      pi.setPages(allPageData);
      pi.setTotalPage(numPage);
      pi.setCurrentPage(1);
      InfoTable temp = mainPanel.getInfoTable();
      temp.setData(allPageData[0]);
      
      
      
        // show if add new data successfully in the main panel
        this.mainTextPanel = this.mainPanel.getTextPanel();
        TextStatus t = TextStatus.ADDSUCCESS;
        this.mainTextPanel.setTextStatus(t);


      }
      
    } else if (e.getActionCommand() == Actions.DATE.name()) {
      if (count % 2 == 0) {
        ((SmallWindowPane) this.addPanel.getContentPane()).selectCurrentDate();
        this.count++;
      } else {
        ((SmallWindowPane) this.addPanel.getContentPane()).deselectCurrentDate();
        this.count++;
      }

    }
  }
}
