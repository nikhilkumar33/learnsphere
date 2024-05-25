package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>
{
	public Course findByName(String name);

}
