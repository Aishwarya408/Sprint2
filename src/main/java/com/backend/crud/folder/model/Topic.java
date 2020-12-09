package com.backend.crud.folder.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;



@Entity
@Table(name="topic_main_table")
public class Topic {

       @Id
       @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String TopicName;
    @PrimaryKeyJoinColumn
    private int surveyorid;
    public Topic() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Topic(int id, String topicName) {
		super();
		this.id = id;
		TopicName = topicName;
	}
	


	
	public Topic(int id, String topicName, Surveyor surveyor) {
		super();
		this.id = id;
		TopicName = topicName;
		this.surveyorid = surveyor.getId();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTopicName() {
		return TopicName;
	}


	public void setTopicName(String topicName) {
		TopicName = topicName;
	}
	





	public int getSurveyorId() {
		return surveyorid;
	}


	public void setSurveyorId(int surveyorId) {
		this.surveyorid = surveyorId;
	}


	@Override
	public String toString() {
		return "Topic [id=" + id + ", TopicName=" + TopicName + ", surveyor=" + surveyorid + "]";
	}


	


}
