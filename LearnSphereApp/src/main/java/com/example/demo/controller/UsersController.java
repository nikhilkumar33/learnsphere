package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;

	@PostMapping("/register")
	public String addUsers(@ModelAttribute Users user) {
		boolean userstatus = userv.emailExists(user.getEmail());
		if (userstatus == false) {
			if (userv.userNameExists(user.getUsername()) == false) {
				userv.addUsers(user);
				return "registersuccess";
			} else {
				return "usernamefail";
			}
		} else {
			return "registerfail";
		}
	}

	@PostMapping("/login")
	public String validateUser(@RequestParam String text, @RequestParam String password, HttpSession session) {
		// invoking validateUser() in service
		String res = userv.validateUser(text, password);
		if (!res.equals("false")) {

			session.setAttribute("email", res);
			// checking weather the user is trainer or student
			if (userv.getRole(res).equals("trainer")) {

				return "adminhome";
			} else {
				return "customerhome";
			}

		} else {
			return "loginfail";
		}
	}

	@GetMapping("/logout")
	public String logoutUser(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0
		response.setDateHeader("Expires", 0); // Proxies

		// Invalidate the session cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "login";
	}

	@PostMapping("/resetpassword")
	public String resertPassword(@RequestParam String email, @RequestParam String schname,
			@RequestParam String password) {
		Users user = userv.getUser(email);
		if (user != null) {
			String db_schname = user.getSchname();
			if (db_schname.equals(schname)) {
				user.setPassword(password);
				userv.updateUser(user);
				return "resetsuccess";
			} else {
				return "resetfail";
			}
		} else {
			return "resetfail";
		}
	}
}
