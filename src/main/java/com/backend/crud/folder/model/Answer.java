package com.backend.crud.folder.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity

@Table(name="crud_answer")
public class Answer {

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String answer;
    @PrimaryKeyJoinColumn
    private int surveyorid;
    @PrimaryKeyJoinColumn
    private int questionid;
    


	public Answer() {
		super();
	}



	public Answer(int id, String answer, Surveyor surveyor,Question question) {
		super();
		this.id = id;
		this.answer = answer;
		this.surveyorid=surveyor.getId();
		this.questionid=question.getId();
		
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public int getSurveyorid() {
		return surveyorid;
	}



	public void setSurveyorid(int surveyorid) {
		this.surveyorid = surveyorid;
	}



	public int getQuestionid() {
		return questionid;
	}



	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}



	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", surveyorid=" + surveyorid + ", questionid=" + questionid
				+ "]";
	}
	



}