package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer>
{
	public Lesson findByLessonName(String lessonName);
	public List<Lesson> findByCourseId(int courseId);
}
