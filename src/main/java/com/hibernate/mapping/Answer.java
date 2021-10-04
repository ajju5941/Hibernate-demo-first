package com.hibernate.mapping;

import javax.persistence.*;

@Entity
public class Answer {

	@Id
	private int answer_id;
	private String answer;

	@ManyToOne
	private Questions question;

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Questions getQuestion() {
		return question;
	}

	public void setQuestion(Questions question) {
		this.question = question;
	}

	public Answer(int answer_id, String answer, Questions question) {
		super();
		this.answer_id = answer_id;
		this.answer = answer;
		this.question = question;
	}

	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
