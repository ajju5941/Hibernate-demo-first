package com.hibernate.mapping;

import java.util.List;

import javax.persistence.*;

@Entity
public class Questions {

	@Id
	private int question_id;
	private String question;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Answer> answer;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Questions(int question_id, String question, List<Answer> answer) {
		super();
		this.question_id = question_id;
		this.question = question;
		this.answer = answer;
	}

	public Questions() {
		super();
		// TODO Auto-generated constructor stub
	}

}
