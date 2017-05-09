package org.rimi.marksystem.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class MSSheet<T> {
	
	
	/**
	 * 
	 * @param titles
	 * @param contents
	 * @param path
	 * @param tableName
	 * @param tableIndex
	 * @throws IOException
	 * @throws WriteException
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public MSSheet(List<String> titles,List<T> entityList,List<String> propertyNames,String path,String tableName,int tableIndex) throws IOException, WriteException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
		this.entityHandle = new EntityHandle<T>();
		this.contents = entityHandle.convertEntityToList(entityList, propertyNames);
		this.path = path;
		this.tableName = tableName;
		this.titles = titles;
		//获取元素总数量
		this.totalElements = contents.size() * ((List<String>)contents.get(0)).size();
		//获取总行数
		this.totalRows = contents.size() + 1;
		//获取总列数
		this.totalColumns = titles.size();
		
		//创建os和wb
		this.createOsAndWB();
		
		//创建sheet
		this.createSheet();
		
		//创建title 行
		this.createTitleRow();
		
		//创建内容
		for (int i = 0; i < totalRows-1; i++) {
			this.createContentRow(contents.get(i),i+1);
		}

		//写入os
		this.writeOs();
		
		//关闭os
		this.closeOs();
	}
	
	private List<List<String>> contents;
	private EntityHandle<T> entityHandle;
	private int tableIndex;
	private String tableName;
	private String path;
	private OutputStream os;
	private WritableWorkbook workbook;
	private Integer totalElements;
	private Integer totalRows;
	private Integer totalColumns;
	private WritableSheet contentSheet;
	private List<String> titles;
	public WritableSheet getContent() {
		return contentSheet;
	}
	public void setContent(WritableSheet content) {
		this.contentSheet = content;
	}
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	
	
	public EntityHandle<T> getEntityHandle() {
		return entityHandle;
	}
	public void setEntityHandle(EntityHandle<T> entityHandle) {
		this.entityHandle = entityHandle;
	}
	public int getTableIndex() {
		return tableIndex;
	}
	public void setTableIndex(int tableIndex) {
		this.tableIndex = tableIndex;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public OutputStream getOs() {
		return os;
	}
	public void setOs(OutputStream os) {
		this.os = os;
	}
	public WritableWorkbook getWorkbook() {
		return workbook;
	}
	public void setWorkbook(WritableWorkbook workbook) {
		this.workbook = workbook;
	}
	public Integer getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Integer totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}
	public Integer getTotalColumns() {
		return totalColumns;
	}
	public void setTotalColumns(Integer totalColumns) {
		this.totalColumns = totalColumns;
	}
	public WritableSheet getContentSheet() {
		return contentSheet;
	}
	public void setContentSheet(WritableSheet contentSheet) {
		this.contentSheet = contentSheet;
	}
	public void addLabelToSheet(Label label){
		try {
			this.contentSheet.addCell(label);
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createLabelToSheet( int columnNum,int rowNum,String content){
		Label label = new Label(columnNum, rowNum, content);
		try {
			this.contentSheet.addCell(label);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	
	public void createContentRow(List<String> rowContent,int currentRowNumber){
		for (int i = 0; i < rowContent.size(); i++) {
			this.createLabelToSheet(i, currentRowNumber, rowContent.get(i));	
		}
	}
	
	public void createTitleRow(){
		for (int i = 0; i < titles.size(); i++) {
			this.createLabelToSheet(i, 0, titles.get(i));
		}	
	}
	
	private void closeOs() throws IOException, WriteException{
		
		if(this.workbook != null)
			this.workbook.close();
		
		if(this.os != null)
			this.os.close();
	}
	
	private void writeOs() throws IOException{
		if(this.workbook != null)
			this.workbook.write();
	}
	
	private void createOsAndWB() throws IOException{
		this.os = new FileOutputStream(this.path);
		this.workbook = Workbook.createWorkbook(this.os);
	}
	
	private void createSheet(){
		if(tableIndex < 0)
			this.contentSheet = workbook.createSheet(this.tableName, 0);
		else
			this.contentSheet = workbook.createSheet(this.tableName, this.tableIndex);
	}
	
}
