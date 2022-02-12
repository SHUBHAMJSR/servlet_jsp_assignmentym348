package com.product.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.Exception.UserNotFoundException;
import com.product.persistance.User;
import com.product.service.UserService;
import com.product.service.UserServiceImpl;

public class LoginController extends HttpServlet {
	
	private UserService userService= new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username=request.getParameter("uname");
		String password=request.getParameter("pwd");
		
		Optional<User> users = userService.getUser(username, password);
		
		User user=null;
		try{
			user= users.orElseThrow(()-> new UserNotFoundException("user not found"));
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("ProductController?action=showall");
		}catch(UserNotFoundException ex) {
			response.sendRedirect("login.jsp?status=login failed");
		}
		
		
	}

}
