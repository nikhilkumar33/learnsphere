package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository urepo;
	
	@Override
	public boolean emailExists(String email) {
		if(urepo.findByEmail(email) == null) {
		return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public boolean userNameExists(String username) {
		if(urepo.findByUsername(username)== null) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void addUsers(Users user) {
		urepo.save(user);
	}

	@Override
	public String validateUser(String text, String password) {
		Users user = urepo.findByEmail(text);
		if(user!=null)
		{
			if(user.getPassword().equals(password))
			{
				return user.getEmail();
			}
			else
			{
				return "false";
			}
		}
		else
		{
			Users use=urepo.findByUsername(text);
			if(use!= null)
			{
				if(use.getPassword().equals(password))
				{
					return use.getEmail();
				}
				else
				{
					return "false";
				}
			}
			else {
				return "false";
			}
		}
	}

	@Override
	public String getRole(String email) {
		String role = urepo.findByEmail(email).getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		Users user = urepo.findByEmail(email);
		return user;
	}

	@Override
	public void updateUser(Users user) {
		urepo.save(user);
		
	}

	@Override
	public List<Course> purchasedCourses(String email) {
		Users user=urepo.findByEmail(email);
		return user.getCourses();
	}

	@Override
	public void addCourseToUser(String email, Course course) {
		Users user=urepo.findByEmail(email);
		user.getCourses().add(course);
		urepo.save(user);
		
	}

	
	
}
