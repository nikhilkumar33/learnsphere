package com.example.demo.services;

import com.example.demo.entities.Lesson;

public interface LessonService 
{

	public boolean lessonExists(String lessonName);

	public void updateLesson(Lesson lesson);

}
