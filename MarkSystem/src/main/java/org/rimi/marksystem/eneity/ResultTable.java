package org.rimi.marksystem.eneity;

/*
 * 评分结果表
 */
public class ResultTable {
    private int id;
    private int quizId;					//问题id
    private String answer;				//问题回答
    private String answerScore;			//回答得分
    private int evaluatedId;			//被评分人ID
    private int evaluationId;			//评分人ID
    private int marktableId;			//评分表ID
    private int teamId;					//班级ID
    private String teamName; //班级名字
    
    
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
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
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswerScore() {
		return answerScore;
	}
	public void setAnswerScore(String answerScore) {
		this.answerScore = answerScore;
	}
	public int getEvaluatedId() {
		return evaluatedId;
	}
	public void setEvaluatedId(int evaluatedId) {
		this.evaluatedId = evaluatedId;
	}
	public int getEvaluationId() {
		return evaluationId;
	}
	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}
	public int getMarktableId() {
		return marktableId;
	}
	public void setMarktableId(int marktableId) {
		this.marktableId = marktableId;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
    
    
}
