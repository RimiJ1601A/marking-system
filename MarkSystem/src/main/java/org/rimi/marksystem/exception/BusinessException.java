package org.rimi.marksystem.exception;


public class BusinessException extends RuntimeException{
	
	private String content;	
	
	public String getName() {
		return content;
	}

	public void setName(String content) {
		this.content = content;
	}
	public BusinessException(String content){
		this.content=content;
	}
	
}
