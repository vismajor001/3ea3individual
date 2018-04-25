package Control.MainPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graphics.InfoTable;
import Graphics.MainFrame;
import Model.Model;
import Model.Sort;
import Model.Transaction;

public class SortByDate implements ActionListener {
  private MainFrame mainPanel;
  private PageInfo pi;
  private Model m;
  public SortByDate(MainFrame w,Model m,PageInfo pi) {
    this.mainPanel = w;
    this.pi=pi;
    this.m=m;
  }
  
  
  public void actionPerformed(ActionEvent e) {
	  Transaction[] trans=m.getTransactionList();

      Sort.sortByDate(trans);

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

    } 
}
