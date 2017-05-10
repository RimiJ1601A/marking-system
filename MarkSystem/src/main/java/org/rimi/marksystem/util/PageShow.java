package org.rimi.marksystem.util;

public class PageShow {

	private int totalPage;//总页数
	private int currentPageNum;//当前页
	private int start;//数据库查询开始的记录
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	/**
	 * 返回总页数
	 * @param total 数据库的数据总数
	 * @return
	 */
	public void returnTotalPage(int total){
		this.totalPage = (total+ConstantClassField.COUNT-1)/ConstantClassField.COUNT;
		if(this.totalPage <=0){
			this.totalPage = 1;
		}
	}
	/**
	 * 返回当前页的页码
	 * @param pageNum 前台传的当前页页码
	 * @return
	 */
	public void returnCurrentPageNum(String pageNum){
		if(pageNum == null || pageNum.isEmpty()){
			this.currentPageNum = 1;
		}else{
			this.currentPageNum = Integer.parseInt(pageNum);
		}
	}
	/**
	 * 返回数据库查询的开始的地方
	 * @param currentPageNum 当前页的页码
	 * @return
	 */
	public void returnStart(int currentPageNum){
		this.start = (currentPageNum-1)*ConstantClassField.COUNT;
	}
	public PageShow(){
		
	}
	/**
	 * 分页
	 * @param total 总数
	 * @param pageNum 前台传的当前页
	 */
	public PageShow(int total,String pageNum){
		this.returnTotalPage(total);
		this.returnCurrentPageNum(pageNum);
		this.returnStart(this.currentPageNum);
	}
}
