package uta.mav.appoint.db.command;

import uta.mav.appoint.beans.RegisterBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends SQLCmd {
	
	private String email;
	private String password;
	private String role;
	
	Boolean b;
	
	public Register(RegisterBean registerBean){
		email = registerBean.getEmail();
		password = registerBean.getPassword();
		role = "student";
		b = false;
	}
	
	public void queryDB(){
		try{
			String command = "INSERT INTO user (email,password,role,validated)"
					+" values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1,email);
			statement.setString(2,password);
			statement.setString(3,role);
			statement.setInt(4,0);

			System.out.printf("About to update\n");
			statement.executeUpdate();
			System.out.printf("Just updated\n");
			b=true;
		}
		catch(SQLException sq){
			System.out.println(sq.toString());
		}
	}
	
	public void processResult(){
		result.add(b);
	}

}
