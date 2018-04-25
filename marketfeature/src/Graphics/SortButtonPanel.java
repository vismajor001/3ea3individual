package Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SortButtonPanel extends JPanel{
	private JButton sortByDescription;
	private JButton sortByAmount;
	private JButton sortByDate;
	private JButton sortByUser;
	private JButton breakSort;
	private JButton search;
	private JButton addTransaction;
	private JButton saveChange;
	
	public SortButtonPanel(){
		sortByDescription=new JButton("Sort By Description");
		sortByAmount=new JButton("Sort By Amount");
		sortByDate=new JButton("Sort By Date");
		sortByUser=new JButton("Sort By User");
		search=new JButton("Search/Filter");
		addTransaction=new JButton("Add New item");
		saveChange=new JButton("Save Changes");
		add(sortByDescription);
		add(sortByAmount);
		add(sortByDate);
		add(sortByUser);
		add(search);
		add(addTransaction);
		add(saveChange);
	}
	
	public JButton getSortByDescription(){
		return sortByDescription;
	}
	public JButton getSortByAmount(){
		return sortByAmount;
	}
	public JButton getSortByDate(){
		return sortByDate;
	}
	public JButton getSortByUser(){
		return sortByUser;
	}

	public JButton getSearch(){
		return search;
	}
	public JButton getAddTransaction(){
		return addTransaction;
	}
	public JButton getSaveChange(){
		return saveChange;
	}
	
}
