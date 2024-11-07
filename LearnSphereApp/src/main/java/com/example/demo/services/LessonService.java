package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Lesson;

public interface LessonService 
{

	public boolean lessonExists(String lessonName);

	public void updateLesson(Lesson lesson);

	public List<Lesson> getLessonsForCourse(int id);

	public Lesson getLessonById(int lessonId);

}
