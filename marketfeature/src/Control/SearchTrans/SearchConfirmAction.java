package Control.SearchTrans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Control.MainPanel.PageInfo;
import Graphics.*;
import Model.*;


public class SearchConfirmAction implements ActionListener {
	private SearchTransactionWindow searchPanel;
	private MainFrame mainPanel;
	private Model m;
	private PageInfo pi;

	SearchConfirmAction(SearchTransactionWindow w, MainFrame w1, Model m,
			PageInfo pi) {
		this.searchPanel = w;
		this.mainPanel = w1;
		this.m = m;
		this.pi = pi;
	}

	public void actionPerformed(ActionEvent e) {
		String[] searchData = ((SmallWindowPane) this.searchPanel
				.getContentPane()).confirm();
		if (searchData[0]!=null &&searchData[1]!=null){
			String tmp = searchData[0];
			searchData[0] = searchData[1];
			searchData[1] = tmp;
		}
		else if (searchData[0]==null){
			searchData[0]=searchData[1];
			searchData[1]=null;
		}
		else if (searchData[1]==null){
			searchData[1]=searchData[0];
			searchData[0]=null;
		}

		// Search.search has to be provided amount
		Transaction[] trans = Search.search(searchData, m.getTransactionList(),
				null);

		int count = 0;
		// count the total number of pages
		for (Transaction i : trans)
			if (i != null)
				count++;

		System.out.println(count);
		int numPage = (int) Math.ceil(count / 50.0);
		Object[][][] allPageData = new Object[numPage][50][4];
		if (numPage != 0) {
			int pageCount = 0;
			count = 0;
			for (Transaction i : trans) {
				// set up the object array
				// format: [description,amount,date,user]
				if (i != null) {
					allPageData[pageCount][count][0] = i.getDescription();
					allPageData[pageCount][count][1] = i.getAmount();
					allPageData[pageCount][count][2] = i.getDate();
					allPageData[pageCount][count][3] = i.getUser();
					count++;
					if (count >= 50) {
						count = 0;
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
		else{
			
			mainPanel.getInfoTable().setData(new Object[50][4]);
			pi.setTotalPage(1);
			pi.setCurrentPage(1);
		}

		this.searchPanel.dispose();

	}
}
