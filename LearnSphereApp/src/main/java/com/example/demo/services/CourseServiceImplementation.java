package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService {
	@Autowired
	CourseRepository crepo;

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

}
