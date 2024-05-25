package com.example.demo.services;

import com.example.demo.entities.Course;

public interface CourseService {

	public boolean courseExist(String name);

	public void addCourse(Course course);

}
