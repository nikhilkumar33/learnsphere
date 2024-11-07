package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Course;
import com.example.demo.entities.Lesson;
import com.example.demo.services.CourseService;
import com.example.demo.services.LessonService;

@Controller
public class LessonController 
{
	@Autowired
	LessonService lessonserv;
	
	@Autowired
	CourseService cserv;
	
	@PostMapping("/addlesson")
	public String addLesson(@ModelAttribute Lesson lesson)
	{
		Course course = cserv.findCourseById(lesson.getCouId());
		if(course!=null)
		{
			boolean res=lessonserv.lessonExists(lesson.getLessonName());
			if(res==false)
			{
				// Associate the lesson with the found course.
				lesson.setCourse(course);
				lessonserv.updateLesson(lesson);
				return "lessonsuccess";
			}
			else
			{
				return "lessonfail";
			}
		}
		else
		{
			return "coursemismatch";
		}
	}
	
	@GetMapping("/viewLesson")
    public String viewLesson(@RequestParam int lessonId, Model model) {
        Lesson lesson = lessonserv.getLessonById(lessonId);
        model.addAttribute("lesson", lesson);
        return "lessondetails";
    }
}
