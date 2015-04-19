package uta.mav.appoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.beans.GetSet;
import uta.mav.appoint.beans.RegisterBean;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.login.LoginUser;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String email;
	String password;
	String rpassword;
	String role;
	int student_Id;
	int degree_type;
	String phone_num;
	ArrayList<String> departments;
	ArrayList<String> majors;
	
	HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();

		ArrayList<String> degreeType = new ArrayList<>();
		degreeType.add("Bachelor");
		degreeType.add("Master");
		degreeType.add("Doctorate");
		session.setAttribute("degreeType", degreeType);
		try {
			DatabaseManager dbm = new DatabaseManager();
			ArrayList<String> departments = dbm.getDepartmentStrings();
			session.setAttribute("departments", departments);
			
			//get majors from database
			ArrayList<String> major = dbm.getMajor();
			session.setAttribute("major", major);
		} catch(Exception e){
			System.out.println(e+" RegisterServlet");
		}
		
		request.setAttribute("includeHeader", "templates/header.jsp");
		request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean success = false;
		try{
			email = request.getParameter("emailAddress");
			if(!email.endsWith("@mavs.uta.edu"))
			{
				System.out.println("Email Address Invalid");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			password = request.getParameter("password");
			if(password.length()<6)
			{
				System.out.println("Unsecure Password");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			rpassword = request.getParameter("repeatPassword");
			if(!password.equals(rpassword))
			{
				System.out.println("Passwords do not match Invalid");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			phone_num = request.getParameter("phone_num");
			if(!phone_num.matches("^\\d{3}-\\d{3}-\\d{4}"))
			{
				System.out.println("Phone Number Invalid");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			role = "student";
			
			if(!request.getParameter("student_Id").matches("^100\\d{7}") && !request.getParameter("student_Id").matches("^6000\\d{6}")){
				System.out.println("Student ID Invalid");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			
			student_Id = Integer.valueOf(request.getParameter("student_Id"));

			degree_type = Integer.valueOf(request.getParameter("drp_degreeType"));
			
			departments = new ArrayList<String> (Arrays.asList(request.getParameter("drp_department")));
			majors = new ArrayList<String> (Arrays.asList(request.getParameter("drp_major")));
	
			//need to add check for maverick email address
			//need to add check that both passwords match
			//need to redirect back to register with correct error message
			RegisterBean set = new RegisterBean();
			set.setEmail(email);
			set.setPassword(password);
			set.setRole(role);
			set.setDegree_type(degree_type);
			set.setPhone_num(phone_num);
			set.setStudent_Id(student_Id);
		
			DatabaseManager dbm = new DatabaseManager();
			if (dbm.addUser(set)){
				//if adduser successful, log in as added user and redirect
				//back to start
				System.out.println("Created user");
				GetSet sets = new GetSet();
				sets.setEmailAddress(email);
				sets.setPassword(password);
					
				//call db manager and authenticate user, return value will be 0 or
				//an integer indicating a role
				LoginUser user = dbm.checkUser(sets);
				System.out.println("Checked User");
				if(user != null){
					session = request.getSession();
					System.out.println("Success");
					session.setAttribute("user", user);
					System.out.println(user.toString());
					response.sendRedirect("index");
					success = true;
				}
			}
		}
		catch(Exception e){
			System.out.println(e+"RegisterServlet");
		}
		if(!success){
			System.out.println("Couldn't Log In");
			//if unable to log in, add error message and redirect back to register
			request.setAttribute("includeHeader", "templates/header.jsp");
			request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request, response);
		}
	}

}
