package uta.mav.appoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uta.mav.appoint.beans.CreateAdvisorBean;
import uta.mav.appoint.login.AdvisorUser;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AppointmentVisitor;
import uta.mav.appoint.visitor.Visitor;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.email.Email;

/*
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.*;
*/

/**
 * Servlet implementation class ViewAppointmentServlet
 */
public class CreateAdvisorServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private HttpSession session;   
    private String header;
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		if (user == null){
				user = new LoginUser();
				session.setAttribute("user", user);
				response.sendRedirect("/WEB-INF/jsp/views/login.jsp");		
		}
		else{
			try{
				header = "templates/" + user.getHeader() + ".jsp";
			}
			catch(Exception e){
				System.out.printf(e.toString());
			}
		}
		
		request.setAttribute("includeHeader", header);
		request.getRequestDispatcher("/WEB-INF/jsp/views/create_advisor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("user");
		try{
			String email = (String)request.getParameter("emailAddress");
			String password = "newadvisor!@3";
			String pname = (String)request.getParameter("pname");
			String name_low = "A";
			String name_high = "Z";
			Integer degree_types = 7;
			Integer lead_status = Integer.valueOf(request.getParameter("isLead"));
			
			try{
				
				AdvisorUser advisorUser = new AdvisorUser(email, password, pname, name_low, name_high, degree_types, lead_status);
				if (advisorUser != null && advisorUser.getUserId()>0){
					user.setMsg("Advisor account created with password \""+password+"\".");
				}
				else{
					user.setMsg("Error: Cannot create account.");
				}
			}
			catch(Exception e){
				user.setMsg("Unable to create advisor..");
			}
			String msg = user.getMsg();
			
			response.setContentType("text/plain");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			String msgSub = "Mavappoint User Information";
			String msgText ="Your account has been created"
	            	+ "\n Username: " + pname
	            	+ "\npassword: \"newadvisor!@3\" ";
			String toEmail = "mavappoint.donotreply@gmail.com";
			
			Email newMail = new Email(msgSub, msgText, toEmail);
			newMail.sendMail();
			out.write(msg);
			out.flush();
			out.close();
			}
		catch(Exception e){
			System.out.printf(e.toString());
		}
	}
}

