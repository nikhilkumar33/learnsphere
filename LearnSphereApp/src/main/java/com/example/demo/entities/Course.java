package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String prerequsit;
	String descrip;
	int price;
	
	@ManyToMany
	List<Lesson> lesson;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(int id, String name, String prerequsit, String descrip, int price, List<Lesson> lesson) {
		super();
		this.id = id;
		this.name = name;
		this.prerequsit = prerequsit;
		this.descrip = descrip;
		this.price = price;
		this.lesson = lesson;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrerequsit() {
		return prerequsit;
	}
	public void setPrerequsit(String prerequsit) {
		this.prerequsit = prerequsit;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<Lesson> getLesson() {
		return lesson;
	}
	public void setLesson(List<Lesson> lesson) {
		this.lesson = lesson;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", prerequsit=" + prerequsit + ", descrip=" + descrip
				+ ", price=" + price + ", lesson=" + lesson + "]";
	}
			
}
