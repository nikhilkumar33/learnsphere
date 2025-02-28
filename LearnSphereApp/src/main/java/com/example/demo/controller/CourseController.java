package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.entities.Users;
import com.example.demo.services.CourseService;
import com.example.demo.services.LessonService;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController 
{
	@Autowired
	CourseService cserv;
	
	@Autowired
	UsersService userv;
	
	@Autowired
	LessonService lserv;
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute Course course)
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
	@GetMapping("/viewcourse")
	public String viewCourse(Model model)
	{
		List<Course> courseList=cserv.fetchCourses();
		model.addAttribute("courseList", courseList);
		return "displaycourse";
	}
	
	@GetMapping("/explorecourse")
	public String exploreCourses(Model model)
	{
		List<Course> courseList=cserv.fetchCourses();
		model.addAttribute("courselist", courseList);
		return "viewcourse";
	}
	
	@GetMapping("/mycourse")
	public String studentCourse(Model model, HttpSession session) {
	    String email = (String) session.getAttribute("email");
	    List<Course> primeCourses = userv.purchasedCourses(email);
	    if (primeCourses != null && !primeCourses.isEmpty()) {
	        // Iterate over each course to fetch and set its lessons
	        for (Course course : primeCourses) {
	            List<Lesson> lessons = lserv.getLessonsForCourse(course.getId());
	            course.setLessonList(lessons);
	        }
	        model.addAttribute("courseList", primeCourses);
	        return "mycourse";
	    } else {
	        return "nocourse";
	    }
	}

}
