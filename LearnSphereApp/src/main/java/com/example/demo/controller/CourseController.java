package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Course;
import com.example.demo.services.CourseService;

@Controller
public class CourseController 
{
	@Autowired
	CourseService cserv;
	
	@PostMapping("/addcourse")
	public String addSongs(@ModelAttribute Course course)
	{
		if(cserv.courseExist(course.getName())==false)
		{
			cserv.addCourse(course);
			return "coursesuccess";
		}
		else
		{
			return "coursefail";
		}
		
	}
}
