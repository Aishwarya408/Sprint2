package com.backend.crud.folder.model;

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
@Table(name="crud_feedback") 
public class Feedback{
	
	@Id
	//@GeneratedValue(strategy= GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int sid;
	private String feedbck;
	 @PrimaryKeyJoinColumn
	    private int surveyorid;
	 @PrimaryKeyJoinColumn
	    private int topicid;
	public Feedback() {
		super();
	}
	public Feedback(int sid, String feedbck, Surveyor surveyor, Topic topic) {
		super();
		this.sid = sid;
		this.feedbck = feedbck;
		this.surveyorid = surveyor.getId();
		this.topicid = topic.getId();
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFeedbck() {
		return feedbck;
	}
	public void setFeedbck(String feedbck) {
		this.feedbck = feedbck;
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
		return "Feedback [sid=" + sid + ", feedbck=" + feedbck + ", surveyorid=" + surveyorid + ", topicid=" + topicid
				+ "]";
	}
	
	
	
	
}