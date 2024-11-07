package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

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
	
	@OneToMany
	List<Lesson> lessonList;
	
	@ManyToMany
	List<Users> user;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, String name, String prerequsit, String descrip, int price, List<Lesson> lessonList,
			List<Users> user) {
		super();
		this.id = id;
		this.name = name;
		this.prerequsit = prerequsit;
		this.descrip = descrip;
		this.price = price;
		this.lessonList = lessonList;
		this.user = user;
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

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public void setLessonList(List<Lesson> lessonList) {
		this.lessonList = lessonList;
	}

	public List<Users> getUser() {
		return user;
	}

	public void setUser(List<Users> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", prerequsit=" + prerequsit + ", descrip=" + descrip
				+ ", price=" + price + ", lessonList=" + lessonList + ", user=" + user + "]";
	}

	

	
		
}
