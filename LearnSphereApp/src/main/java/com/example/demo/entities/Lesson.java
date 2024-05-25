package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Lesson 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String lessonName;
	String topics;
	String video;
	String attachment;
	@ManyToMany
	List<Course> course;
	public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lesson(int id, String lessonName, String topics, String video, String attachment, List<Course> course) {
		super();
		this.id = id;
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
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Lesson [id=" + id + ", lessonName=" + lessonName + ", topics=" + topics + ", video=" + video
				+ ", attachment=" + attachment + ", course=" + course + "]";
	}
	

}
