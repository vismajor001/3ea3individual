package Control;


import Control.AddTrans.AddAction;
import Control.MainPanel.PageInfo;
import Control.MainPanel.SaveAction;
import Control.MainPanel.SortByAmount;
import Control.MainPanel.SortByDate;
import Control.MainPanel.SortByDescription;
import Control.MainPanel.SortByUser;
import Control.MainPanel.ItemAfter50;
import Control.MainPanel.ItemBefore50;
import Control.SearchTrans.SearchAction;
import Graphics.*;
import Model.Model;
import Model.Transaction;

public class MarketCenterMain {
  
  public static void main(String[] args) {
	  //create the mainframe and the model
    MainFrame m = new MainFrame();
    Model model=new Model();
    //add action listeners to the components

    //m.getSortButtonPanel().getBreakSort().addActionListener(new BreakSortOrder(m));
   

      m.getSortButtonPanel().getSaveChange().addActionListener(new SaveAction(m,model));    
    
   
    //setup the table using data from model
    Transaction[] transactionList=model.getTransactionList();
  
    int count=0;
    //count the total number of pages
    for (Transaction i:transactionList) if (i!=null) count++;
    int numPage=(int) Math.ceil(count/50.0);
    Object[][][] allPageData=new Object[numPage][50][4];
    System.out.println(numPage);
    int pageCount=0;
    count=0;
    for (Transaction i:transactionList){
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
    //setup the data in the table
    m.getInfoTable(). setData(allPageData[0]);
    //set the number of pages
    m.getPageSwitcher().setText(1, numPage);
    //construct a pageInfo
    PageInfo pi=new PageInfo(m.getInfoTable(),m.getPageSwitcher(), allPageData, 1, numPage);
    
    m.getPageSwitcher().getPageDownButton().addActionListener(new ItemAfter50(pi));
    m.getPageSwitcher().getPageUpButton().addActionListener(new ItemBefore50(pi));      
    
    m.getSortButtonPanel().getSortByDescription().addActionListener(new SortByDescription(m,model,pi));
    m.getSortButtonPanel().getSortByDate().addActionListener(new SortByDate(m,model,pi));
    m.getSortButtonPanel().getSortByUser().addActionListener(new SortByUser(m,model,pi));
    m.getSortButtonPanel().getSortByAmount().addActionListener(new SortByAmount(m,model,pi));
    m.getSortButtonPanel().getSearch().addActionListener(new SearchAction(m,model,pi)); 
    m.getSortButtonPanel().getAddTransaction().addActionListener(new AddAction(m,model,pi));
    

    
    
    

  }

}
