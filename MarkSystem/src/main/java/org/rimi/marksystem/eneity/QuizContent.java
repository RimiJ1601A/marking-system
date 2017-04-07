package org.rimi.marksystem.eneity;

public class QuizContent {
    private int id;
    private int quizId;					//问题id
    private String content;				//问题答案
    private int quizCore;				//答案分数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getQuizCore() {
		return quizCore;
	}
	public void setQuizCore(int quizCore) {
		this.quizCore = quizCore;
	}
    
    
}
