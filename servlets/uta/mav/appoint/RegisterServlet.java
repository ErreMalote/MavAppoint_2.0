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
	ArrayList<String> degrees;
	
	HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		if(phone_num.matches("^\\d{3}-^\\d{3}-^\\d{4}"))
		{
			System.out.println("Phone Number Invalid");
			request.setAttribute("error","Unable to add user");
			request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
		}
		role = "student";
		
		try
		{
			if(request.getParameter("student_Id").matches("^100\\d{7}") || request.getParameter("student_Id").matches("^6000\\d{6}"))
				student_Id = Integer.valueOf(request.getParameter("student_Id"));
			else
			{
				System.out.println("Student ID Invalid");
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
			degree_type = Integer.valueOf(request.getParameter("degree_type"));
		}
		catch(Exception e)
		{
			System.out.println("Student ID not int");
			request.setAttribute("error","Unable to add user");
			request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
		}
		
		departments = new ArrayList<String> (Arrays.asList(request.getParameterValues("departments")));
		degrees = new ArrayList<String> (Arrays.asList(request.getParameterValues("degrees")));

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
		
		try{
			DatabaseManager dbm = new DatabaseManager();
			if (dbm.addUser(set)){
				//if adduser successful, log in as added user and redirect
				//back to start
				System.out.println("Created user");
				GetSet sets = new GetSet();
				sets.setEmailAddress(email);
				sets.setPassword(password);
				try{
					//call db manager and authenticate user, return value will be 0 or
					//an integer indicating a role
					LoginUser user = dbm.checkUser(sets);
					System.out.println("Checked User");
					if(user != null){
						session = request.getSession();
						System.out.println("Success");
						session.setAttribute("user", user);
						response.sendRedirect("index");
					}
					else{
						//redirect back to login if authentication fails
						//need to add a "invalid username or password" response
						System.out.println("Wrong password?");
						response.sendRedirect("login");
					}
				}
				catch(Exception e){
					System.out.println(e);
					response.sendRedirect("login");
				}
			}
			else{
				//if unable to log in, add error message and redirect back to register
				request.setAttribute("error","Unable to add user");
				request.getRequestDispatcher("/WEB-INF/jsp/views/register.jsp").forward(request,response);
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}

}
