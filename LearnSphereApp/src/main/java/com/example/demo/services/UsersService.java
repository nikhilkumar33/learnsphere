package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;
import com.example.demo.entities.Users;

public interface UsersService {

	public boolean emailExists(String email);

	public void addUsers(Users user);

	public String validateUser(String email, String password);

	public String getRole(String email);

	public boolean userNameExists(String username);

	public Users getUser(String email);

	public void updateUser(Users user);

	public List<Course> purchasedCourses(String email);

	public void addCourseToUser(String email, Course course);

}
