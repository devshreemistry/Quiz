package com.quiz.entities;

public class Question {

	private int questionId;
	private String question;
	private String option_1;
	private String option_2;
	private String option_3;
	private String option_4;
	private String answer;
	//static int count;
	
	private  String givenAnswer;
	
	
	public Question() {
		super();
	}
	
	
	
	public Question( String question, String option_1, String option_2, String option_3, String option_4,
			String answer) {
		super();
		//this.questionId = questionId;
		this.question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.answer = answer;
		//count++;
	}

	public Question(int questionId, String question, String option_1, String option_2, String option_3, String option_4,
			String answer) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.option_1 = option_1;
		this.option_2 = option_2;
		this.option_3 = option_3;
		this.option_4 = option_4;
		this.answer = answer;
	}


	public int getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption_1() {
		return option_1;
	}
	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}
	public String getOption_2() {
		return option_2;
	}
	public void setOption_2(String option_2) {
		this.option_2 = option_2;
	}
	public String getOption_3() {
		return option_3;
	}
	public void setOption_3(String option_3) {
		this.option_3 = option_3;
	}
	public String getOption_4() {
		return option_4;
	}
	public void setOption_4(String option_4) {
		this.option_4 = option_4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
	

	
	public String getGivenAnswer() {
		return givenAnswer;
	}



	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}



	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", question=" + question + ", option_1=" + option_1
				+ ", option_2=" + option_2 + ", option_3=" + option_3 + ", option_4=" + option_4 + ", answer=" + answer
				+ "]";
	}
	
		
}
