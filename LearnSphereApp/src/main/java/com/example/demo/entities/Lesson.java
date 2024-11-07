package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Lesson 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int couId;
	String lessonName;
	String topics;
	@Column(length=5000)
	String video;
	String attachment;
	
	@ManyToOne
	Course course;
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(int id, int couId, String lessonName, String topics, String video, String attachment, Course course) {
		super();
		this.id = id;
		this.couId = couId;
		this.lessonName = lessonName;
		this.topics = topics;
		this.video = video;
		this.attachment = attachment;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCouId() {
		return couId;
	}
	public void setCouId(int couId) {
		this.couId = couId;
	}
	public String getLessonName() {
		return lessonName;
	}
	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	public String getTopics() {
		return topics;
	}
	public void setTopics(String topics) {
		this.topics = topics;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", couId=" + couId + ", lessonName=" + lessonName + ", topics=" + topics
				+ ", video=" + video + ", attachment=" + attachment + ", course=" + course + "]";
	}
	

}
