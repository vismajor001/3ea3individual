package Control.MainPanel;

import Graphics.InfoTable;
import Graphics.PageSwitcher;

public class PageInfo {
	private InfoTable info;
	private PageSwitcher ps;
	private Object[][][] pages;
	private int current;
	private int totalPage;
	public PageInfo(InfoTable info,PageSwitcher ps,Object[][][] data,int current,int totalPage){
		this.info=info;
		this.ps=ps;
		pages=data;
		this.current=current;
		this.totalPage=totalPage;
	}
	
	public void setPages(Object[][][] data){
		this.pages=data;
	}
	public void setCurrentPage(int c){
		this.current=c;
		ps.setText(current,totalPage);
	}
	public void setTotalPage(int total){
		this.totalPage=total;
		ps.setText(current,totalPage);
	}
	public void pageUp(){
		if (current!=1){
			current--;
			info.setData(pages[current-1]);
			ps.setText(current, totalPage);		
		}
	}
	public void pageDown(){
		if (current!=totalPage){
			current++;
			info.setData(pages[current-1]);
			ps.setText(current, totalPage);		
		}
	}
	
}
