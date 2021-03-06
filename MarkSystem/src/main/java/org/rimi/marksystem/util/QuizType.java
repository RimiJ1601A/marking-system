package org.rimi.marksystem.util;

public enum QuizType {
	CHOICE_QUESTION("choice_question"),ESSAY_QUESTION("essay_question");

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
	
	
	public static QuizType getQuizType(String s){
		if(s.equals("choice_question")){
			return QuizType.CHOICE_QUESTION;
		}else{
			return QuizType.ESSAY_QUESTION;
		}
	}
}
