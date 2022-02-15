package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.training.persistence.Training;
import com.model.training.service.TrainingService;
import com.model.training.service.TrainingServiceImpl;

@WebServlet("/TrainingController")
public class TrainingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private TrainingService tariningService = new TrainingServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-control","no-store");
		response.setHeader("Pragma","no-cache");
		response.setDateHeader("Expires",0);
		
		String action=request.getParameter("action");
		
		if(action.equals("showall"))
		{
			List<Training> trainees = tariningService.getAll();
			request.setAttribute("trainees", trainees);
			RequestDispatcher rd=request.getRequestDispatcher("showAll.jsp");
			rd.forward(request, response);
		}
		else if(action.equals("addTrainee"))
		{
			RequestDispatcher rd=request.getRequestDispatcher("addTrainee.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id=Integer.parseInt(request.getParameter("trainee_id"));
		String tname=request.getParameter("trainee_name");
		String tbranch =request.getParameter("tbranch");
		double per=Double.parseDouble(request.getParameter("per"));
		
		Training training=new Training(id, tname, tbranch, per);
				tariningService.addTrainee(training);
		
		response.sendRedirect("TrainingController?action=showall");

}
}
