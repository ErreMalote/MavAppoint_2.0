package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;

import uta.mav.appoint.beans.CreateAdvisorBean;

public class CreateUser  extends SQLCmd{
	
	String email;
	String password;
	String role;
	String pname;
	Boolean b;
	
	public CreateUser(String email, String password, String role){
		this.email=email;
		this.password=password;
		this.role = role;
		b = false;
	}
	
	@Override
	public void queryDB() {
		try{
			String command = "INSERT INTO user (email,password,role)"
							+" values(?,?,?)";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1,email);
			statement.setString(2,password);
			statement.setString(3,role);
			statement.executeUpdate();
			b = true;
			}
		catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public void processResult() {
		result.add(b);	
	}

		
}
