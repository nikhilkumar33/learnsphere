package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entities.Lesson;
import com.example.demo.services.LessonService;

@Controller
public class LessonController 
{
	@Autowired
	LessonService lserv;
	
	@PostMapping("/addlesson")
	public String addLesson(@ModelAttribute Lesson lesson)
	{
		boolean leres=lserv.lessonExists(lesson.getLessonName());
		if(leres==false)
		{
			lserv.updateLesson(lesson);
			return "lessonsuccess";
		}
		else
		{
			return "lessonfail";
		}
	}
}
