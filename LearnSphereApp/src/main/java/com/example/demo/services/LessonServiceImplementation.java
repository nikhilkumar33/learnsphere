package com.example.demo.services;

import java.util.List;

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
		if(lrepo.findByLessonName(lessonName)==null)
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

	@Override
	public List<Lesson> getLessonsForCourse(int courseId) {
		return lrepo.findByCourseId(courseId);
		
	}

	@Override
	public Lesson getLessonById(int lessonId) {
		return lrepo.findById(lessonId).orElse(null);
	}
}
