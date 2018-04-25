package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class InfoTable extends JPanel{
	
	private JTable table;
	
	private final String[] columnNames={"Description","Amount","Date","User"};
	private Object[][] data=new Object[50][4];
	private ArrayList<Object[]> listData;
	
	
	public InfoTable(int tableLength,int tableHeight){
		
		this.setPreferredSize(new Dimension(tableLength,tableHeight));
		
		table=new JTable(data,columnNames){
			public Component prepareRenderer(
			        TableCellRenderer renderer, int row, int column)
			    {
			        Component c = super.prepareRenderer(renderer, row, column);
			        //  add custom rendering here
			        if (!isRowSelected(row))
						c.setBackground(row % 2 == 0 ? getBackground() : Color.LIGHT_GRAY);

			        return c;
			    }
			public boolean isCellEditable(int row, int column)
		    {
		      return false;//This causes all cells to be not editable
		    }
		};
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		setLayout(new BorderLayout());
		add(scrollPane,BorderLayout.CENTER);
		//add(table.getTableHeader(), BorderLayout.PAGE_START);
	//	add(table, BorderLayout.CENTER);
		
	}
	
	public void setData(Object[][] data){
		//WARNING: Cannot have more than 50 transactions!
		this.data=data;
		for (int row=0;row<data.length;row++){
			for(int column=0;column<data[row].length;column++){
				table.getModel().setValueAt(data[row][column], row, column);
			}
		}
	}
	
  public void setData(ArrayList<Object[]> data){
    this.listData = data;
    for(int row = 0; row < data.size(); row++){
      for(int column = 0; column < data.get(row).length;column++){
        table.getModel().setValueAt(data.get(row)[column], row, column);
      }
    }
  }	
	
	
	
	
	
}
