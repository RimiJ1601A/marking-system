package org.rimi.marksystem.eneity;

import java.util.List;

import org.rimi.marksystem.util.QuizType;

/*
 * 问题类
 */
public class Quiz {
    private int id;
    private String quizTitle;			//问题
    private QuizType quizType;			//问题类型(选择题或问答题)
    private List<QuizContent> quizContent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public QuizType getQuizType() {
		return quizType;
	}
	public void setQuizType(QuizType quizType) {
		this.quizType = quizType;
	}
	public List<QuizContent> getQuizContent() {
		return quizContent;
	}
	public void setQuizContent(List<QuizContent> quizContent) {
		this.quizContent = quizContent;
	}
    
}
