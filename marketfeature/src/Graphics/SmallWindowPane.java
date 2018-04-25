package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SmallWindowPane extends JPanel {
	private boolean isAdd;
	
	private JLabel headLabel;
	private JLabel descriptionLabel=new JLabel("Description: ");
	private JLabel amountLabel     =new JLabel("Amount:      ");
	private JLabel yearLabel=new JLabel("Year: ");
	private JLabel monthLabel=new JLabel("Month: ");
	private JLabel dayLabel=new JLabel("Day: ");
	private JLabel userLabel       =new JLabel("User:        ");
	
	private JTextField description;
	private JTextField amount;
	//textfields to record time
	private JTextField year;
	private JTextField month;
	private JTextField day;
	private JTextField user;
	private JCheckBox currentDate;
	
	//a confirm button
	private JButton confirm;
	
	//a small text panel to display information
	private SmallTextPanel smallTextPanel=new SmallTextPanel();
	public SmallWindowPane(boolean isAdd,int paneLength,int paneHeight){
		this.isAdd=isAdd;
		setBackground(Color.white);
		setLayout(null);
		
				
		headLabel=new JLabel((isAdd? "Add ":"Find ") + "a item");
		headLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		Dimension d=headLabel.getPreferredSize();
		//put the label in the centre;
		int y=20;
		headLabel.setBounds(paneLength/2-d.width/2, y, d.width, d.height);
		y+=d.height+10;
		add(headLabel);
		//then, place the text panel
		smallTextPanel.setBounds(paneLength/2-150,y,300,20);
		y+=30;
		add(smallTextPanel);
		//then, put the description label
		d=descriptionLabel.getPreferredSize();
		descriptionLabel.setBounds(60, y, d.width, d.height);
		
		description=new JTextField(17);
		//put the description text panel next to it
		Dimension e=description.getPreferredSize();
		description.setBounds(60+d.width+5, y-5, e.width, e.height);
		y+=e.height+10;
		add(descriptionLabel);
		add(description);
		
		
		//next, the amount label and the amount 
		d=amountLabel.getPreferredSize();
		amountLabel.setBounds(60, y, d.width, d.height);
		
		amount=new JTextField(17);
		//put the description text panel next to it
		e=amount.getPreferredSize();
		amount.setBounds(60+d.width+5, y-5, e.width, e.height);
		y+=e.height+10;
		add(amountLabel);
		add(amount);
		
		//then the year, month and day on the same row;
		//next, the amount label and the amount 
		int x=50;
		d=yearLabel.getPreferredSize();
		yearLabel.setBounds(x, y, d.width, d.height);
				
		year=new JTextField(4);
		//put the description text panel next to it
		e=year.getPreferredSize();
		x+=d.width+5;
		year.setBounds(x, y-5, e.width, e.height);
		x+=10+e.width;
		add(yearLabel);
		add(year);
		
		d=monthLabel.getPreferredSize();
		monthLabel.setBounds(x, y, d.width, d.height);
				
		month=new JTextField(2);
		//put the description text panel next to it
		e=month.getPreferredSize();
		x+=d.width+5;
		month.setBounds(x, y-5, e.width, e.height);
		x+=10+e.width;
		add(monthLabel);
		add(month);
		
		d=dayLabel.getPreferredSize();
		dayLabel.setBounds(x, y, d.width, d.height);
				
		day=new JTextField(2);
		//put the description text panel next to it
		e=day.getPreferredSize();
		x+=d.width+5;
		day.setBounds(x, y-5, e.width, e.height);
		x+=10+e.width;
		add(dayLabel);
		add(day);
				//then, if it is an add window, add the checkbox next to it
		if(isAdd){
			currentDate=new JCheckBox("Current Date");
			d=currentDate.getPreferredSize();
			currentDate.setBounds(x,y,d.width,d.height);
			add(currentDate);
		}
		
		y+=e.height+10;
		//next, the user label and text field
		d=userLabel.getPreferredSize();
		userLabel.setBounds(60, y, d.width, d.height);
		
		user=new JTextField(17);
		//put the description text panel next to it
		e=user.getPreferredSize();
		user.setBounds(60+d.width+5, y-5, e.width, e.height);
		y+=e.height+10;
		add(userLabel);
		add(user);
		
		
		//at last, the confirm button
		confirm=new JButton(isAdd? "Confirm":"Search");
		d=confirm.getPreferredSize();
		confirm.setBounds(paneLength/2-d.width/2,y,d.width,d.height);
		add(confirm);
	}
	public void selectCurrentDate(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String[] d=dateFormat.format(date).split("-");
		year.setText(d[0]);
		month.setText(d[1]);
		day.setText(d[2]);
		year.setEditable(false);
		month.setEditable(false);
		day.setEditable(false);
	}
	public void deselectCurrentDate(){
		year.setEditable(true);
		month.setEditable(true);
		day.setEditable(true);
		year.setText("");
		month.setText("");
		day.setText("");
	}
	// search and comfirm
	// different by cases
	public String[] confirm(){
		//format: [description,amount,date,user]
		//if any number format fails, it returns null
		String[] result=new String[4];
		String des=description.getText();
		if (des==null ||des.equals("")) des=(isAdd?"No description":null);
		result[0]=des;
		String a=amount.getText();
		
		if (!isAdd && (a==null || a.equals(""))){
			a=null;
		}
		else if (a==null || !checkNumber(a)) {
			smallTextPanel.setTextStatus(TextStatus.ADDFAIL);
			return null;
		}
		result[1]=a;
		
		//check the date
		String y=year.getText();
		if (!isAdd && (y==null || y.equals(""))) y="";
		else if (y==null || !checkNumber(y)){
			smallTextPanel.setTextStatus(TextStatus.ADDFAIL);
			return null;
		}
		String m=month.getText();
		if (!isAdd && (m==null || m.equals(""))) m="";
		else if (m==null || !checkNumber(m)){
			smallTextPanel.setTextStatus(TextStatus.ADDFAIL);
			return null;
		}
		String d=day.getText();
		if (!isAdd && (d==null || d.equals(""))) d="";
		else if (d==null|| !checkNumber(d)){
			smallTextPanel.setTextStatus(TextStatus.ADDFAIL);
			return null;
		}
		if (m.length()==1) m="0"+m;
		if (d.length()==1) d="0"+d;
		String date=(y.equals("")? y: y+ "-" )+(m.equals("")? m : m+"-")+d;
		if (isAdd){
			if (!isValidDate(date)){
				smallTextPanel.setTextStatus(TextStatus.ADDFAIL);
				return null;
			}
		}
		result[2]=date;
		
		//check user
		String u=user.getText();
		if (u==null ||u.equals("")) des=(isAdd?"Unspecified user":null);
		result[3]=u;
		//if everything passes, clear all text fields, set the text panel, and return the result
		description.setText("");
		amount.setText("");		
		year.setText("");
		month.setText("");
		day.setText("");
		user.setText("");
		smallTextPanel.incrementCount();
		smallTextPanel.setTextStatus(TextStatus.ADDSUCCESS);
		return result;
	}
	private boolean checkNumber(String str){
		try  
		  {  
		    double d = Double.parseDouble(str);  
		  }  
		  catch(NumberFormatException nfe)  
		  {  
		    return false;  
		  }  
		  return true;  
	}
	private boolean isValidDate(String inDate) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    try {
	      dateFormat.parse(inDate.trim());
	    } catch (ParseException pe) {
	      return false;
	    }
	    return true;
	  }
	
	public JCheckBox getCheckBox() {
	  return currentDate;
	  
	}
	// add -> as confirm
	// search -> as search 
	public JButton getConfirm() {
	  return confirm;
	}
	
}
