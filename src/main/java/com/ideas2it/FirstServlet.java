package com.ideas2it;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.ideas2it.model.Skills;
import com.ideas2it.model.Trainee;
import com.ideas2it.model.Trainer;
import com.ideas2it.service.EmployeeService;

public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	private EmployeeService employeeService = new EmployeeService();

	private static Logger logger = LogManager.getLogger(FirstServlet.class.getName());

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
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
		case "viewTrainer": 
			viewTrainer(request, response); 
			break; 
		case "updateTrainer": 
			updateTrainerById(request, response); 
			break; 
		case "deleteTrainer": 
			deleteTrainerById(request, response); 
			break; 
		case "insertTrainee": 
			insertTrainee(request, response); 
			break;
		case "viewTrainee": 
			viewTrainee(request, response); 
			break;
		}
	}

	public void insertTrainer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();   
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
		Trainer trainer = (Trainer) session.getAttribute("trainer");

		employeeId = employeeService.addTrainer(employeeId, firstName, lastName,
				designation, department, Long.parseLong(phoneNumber), emailId, dateOfBirth,
				Float.parseFloat(previousExperience), dateOfJoining, Long.parseLong(salary));

		PrintWriter out = response.getWriter();
		logger.info("Trainer Inserted successfully!");
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
		logger.info("Trainer Inserted successfully!");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeRegisterDetails.jsp");    
		requestDispatcher.forward(request, response);//method may be include or forward  
	}

	public void viewTrainer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trainer> trainers = employeeService.getAllTrainers();
		request.setAttribute("trainers", trainers);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewTrainer.jsp");
		requestDispatcher.forward(request, response);
	}

	public void viewTrainee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Trainee> trainees = employeeService.getAllTrainees();
		request.setAttribute("trainees", trainees);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewTrainee.jsp");
		requestDispatcher.forward(request, response);
	}

	public void updateTrainerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer employeeId = Integer.parseInt(request.getParameter("id"));
		List<Trainer> trainer;
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

		trainer = employeeService.updateTrainerById(employeeId, firstName, lastName,
				designation, department, phoneNumber, emailId, dateOfBirth,
				previousExperience, dateOfJoining, salary);
		request.setAttribute("trainer", trainer);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewTrainer.jsp");  
		requestDispatcher.forward(request, response);
		PrintWriter out = response.getWriter();
		logger.info("Trainer Updated Successfully!");
	}

	public void deleteTrainerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteTrainerById(id);
		out.println(id + "Deleted Successfully");
		RequestDispatcher rd=request.getRequestDispatcher("/add?action=viewTrainer");  
		rd.include(request, response);

	}
}
