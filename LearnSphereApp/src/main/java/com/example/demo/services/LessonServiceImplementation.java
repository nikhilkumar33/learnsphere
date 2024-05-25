package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Lesson;
import com.example.demo.repositories.LessonRepository;

@Service
public class LessonServiceImplementation implements LessonService
{
	@Autowired
	LessonRepository lrepo;

	@Override
	public boolean lessonExists(String lessonName) 
	{
		if(lrepo.findByName(lessonName)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public void updateLesson(Lesson lesson) {
		lrepo.save(lesson);
	}

}
