package com.backend.crud.folder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity

@Table(name="question_main_table")
public class Question {

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String Question;
    @PrimaryKeyJoinColumn
    private int surveyorid;
    @PrimaryKeyJoinColumn
    private int topicid;
    


	public Question() {
		super();
	}



	public Question(int id, String question, Surveyor surveyor, Topic topic) {
		super();
		this.id = id;
		Question = question;
		this.surveyorid = surveyor.getId();
		this.topicid = topic.getId();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQuestion() {
		return Question;
	}



	public void setQuestion(String question) {
		Question = question;
	}



	public int getSurveyorid() {
		return surveyorid;
	}



	public void setSurveyorid(int surveyorid) {
		this.surveyorid = surveyorid;
	}



	public int getTopicid() {
		return topicid;
	}



	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}



	@Override
	public String toString() {
		return "Question [id=" + id + ", Question=" + Question + ", surveyorid=" + surveyorid + ", topicid=" + topicid
				+ "]";
	}
}

	