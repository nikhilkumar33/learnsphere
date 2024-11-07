package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;

public interface CourseService {

	public boolean courseExist(String name);

	public void addCourse(Course course);

	public List<Course> fetchCourses();

	public Course findCourseById(int couId);

}
