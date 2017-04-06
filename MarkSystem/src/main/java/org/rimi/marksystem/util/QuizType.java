package org.rimi.marksystem.util;

public enum QuizType {
	CHOICE_QUESTION("选择题"),ESSAY_QUESTION("问答题");
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private QuizType(String type){
		this.type = type;
	}
}
