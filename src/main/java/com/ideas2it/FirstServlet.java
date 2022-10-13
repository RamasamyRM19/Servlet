package com.ideas2it;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.EmployeeService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private EmployeeService employeeService = new EmployeeService();

    private static Logger log = LogManager.getLogger(FirstServlet.class.getName());

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("flag");
		switch (action) {
		case "insertTrainer":
			insertTrainer(request, response);
			break;
	    case "/viewTrainer": 
	    	viewTrainer(request, response); 
	    	break; 
			 /*case "/updateTrainer": updateTrainer(request, response); break; case
			 * "/deleteTrainer": deleteTrainer(request, response); break;
			 */
	    case "insertTrainee": 
	    	insertTrainee(request, response); 
	        break;
		
		}
	}

	public void insertTrainer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer employeeId = 0;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String designation = request.getParameter("designation");
		String department = request.getParameter("department");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailId = request.getParameter("emailId");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String previousExperience = request.getParameter("previousExperience");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String salary = request.getParameter("salary");

		employeeId = employeeService.addTrainer(employeeId, firstName, lastName,
				designation, department, Long.parseLong(phoneNumber), emailId, dateOfBirth,
				Float.parseFloat(previousExperience), dateOfJoining, Long.parseLong(salary));
		 
		PrintWriter out = response.getWriter();
		//response.sendRedirect("EmployeeRegisterDetails.jsp");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployeeRegisterDetails.jsp");    
		requestDispatcher.forward(request, response);//method may be include or forward  
	}
	
    public void insertTrainee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	Set<Skills> skillSet = new LinkedHashSet<Skills>();
		Integer employeeId = 0;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String designation = request.getParameter("designation");
		String department = request.getParameter("department");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailId = request.getParameter("emailId");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String previousExperience = request.getParameter("previousExperience");
		String dateOfJoining = request.getParameter("dateOfJoining");
		String passedOutYear = request.getParameter("passedOutYear");
		Skills skills = new Skills();
        String skillName = request.getParameter("skillName");
        skills.setSkillName(skillName);
        String skillVersion = request.getParameter("version");
        skills.setSkillVersion(skillVersion);
        String lastUsedYear = request.getParameter("lastUsedYear");
        skills.setLastUsedYear(Integer.parseInt(lastUsedYear));
        String skillExperience = request.getParameter("experience");
        skills.setSkillExperience(Float.parseFloat(skillExperience));
        skillSet.add(skills);

		employeeId = employeeService.addTrainee(employeeId, firstName, lastName,
				designation, department, Long.parseLong(phoneNumber), emailId, dateOfBirth,
				Float.parseFloat(previousExperience), dateOfJoining, Integer.parseInt(passedOutYear),
				skillSet);
		 
		PrintWriter out = response.getWriter();
		//response.sendRedirect("EmployeeRegisterDetails.jsp");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeRegisterDetails.jsp");    
		requestDispatcher.forward(request, response);//method may be include or forward  
	}
    
    public void viewTrainer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewTrainer.jsp");
    	List<Trainer> trainers = employeeService.getAllTrainers();
    	request.setAttribute("trainers", trainers);
    }
}
