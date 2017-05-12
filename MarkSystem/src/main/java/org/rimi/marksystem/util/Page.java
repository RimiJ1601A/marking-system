package org.rimi.marksystem.util;

public class Page {
	public static int num = 10;    			//每次展示数量为10	
	private int totalPage;				//总页数
	private int currentPage;			//当前页数
	public int getNum() {
		return num;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public Page(int allcount,int currentPage){
		if(allcount%num ==0){
			this.totalPage=allcount/num;			
		}else{
			this.totalPage=allcount/num+1;
		}	
		this.currentPage=currentPage;
	}
}
