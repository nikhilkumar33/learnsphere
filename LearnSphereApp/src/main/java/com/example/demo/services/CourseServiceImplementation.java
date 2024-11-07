package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService {
	@Autowired
	CourseRepository crepo;
	
	@Autowired
	LessonService lrepo;
	@Override
	public boolean courseExist(String name) {
		if (crepo.findByName(name) == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addCourse(Course course) {
		crepo.save(course);

	}

	@Override
	public List<Course> fetchCourses() {
		List<Course> courseList=crepo.findAll();
		 for (Course course : courseList) {
		        course.setLessonList(lrepo.getLessonsForCourse(course.getId()));
		    }
		return courseList;
	}

	@Override
	public Course findCourseById(int couId) {
		return crepo.findById(couId).orElse(null);
	}

	

}
