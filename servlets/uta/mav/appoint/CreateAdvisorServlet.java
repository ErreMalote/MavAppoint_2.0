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
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.visitor.AppointmentVisitor;
import uta.mav.appoint.visitor.CreateAdvisorVisitor;
import uta.mav.appoint.visitor.Visitor;
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
			CreateAdvisorBean ca = new CreateAdvisorBean();
			ca.setEmail(request.getParameter("emailAddress"));
			ca.setPname(request.getParameter("pname"));
			
			String role = "advisor";
			System.out.print(request.getParameter("isLead"));
			if(request.getParameter("isLead").equals("True"))
				role = "lead_advisor";
			ca.setRole(role);
			
			Visitor v = new CreateAdvisorVisitor();
			user.accept(v,ca);
			String msg = user.getMsg();
			response.setContentType("text/plain");
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Pragma", "no-cache");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			//--------------------
			/*
			final String username = "mavappoint.donotreply@gmail.com";
	        final String password = "mavappointemail";
	 
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	 
	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });
	 
	        try {
	 
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress("mavappoint.donotreply@gmail.com"));
	            message.setRecipients(Message.RecipientType.TO,
	                InternetAddress.parse("mavappoint.donotreply@gmail.com"));
	            message.setSubject("Mavappoint User Information");
	            message.setText("Your account has been created"
	            	+ "\n Username: " + ca.getPname()
	            	+ "\npassword: \"newadvisor!@3\" " + ca.getEmail());
	 
	            Transport.send(message);
	 
	            System.out.println("Done");
	 
	        } 
			catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
	        //-----------
	         * 
	         */
			String msgSub = "Mavappoint User Information";
			String msgText ="Your account has been created"
	            	+ "\n Username: " + ca.getPname()
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

