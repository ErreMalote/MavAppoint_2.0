package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uta.mav.appoint.beans.CreateAdvisorBean;

public class CreateInitialAdvisorSettings extends SQLCmd{

	int userid;
	String pname;
	String email;
	Boolean b;
	
	public CreateInitialAdvisorSettings(int a,CreateAdvisorBean ca){
		userid = a;
		pname = ca.getPname();
		email = ca.getEmail();
		b = false;
	}
	
	@Override
	public void queryDB() {
		try{
			String command = "INSERT INTO User_Advisor (userid,pname,notification,name_low,name_high,degree_types) "
								+"values(?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setInt(1,userid);
			statement.setString(2,pname);
			statement.setString(3,"Day");
			statement.setString(4,"A");
			statement.setString(5,"Z");
			statement.setInt(6,7);
			statement.executeUpdate();
			b = true;
		}
		catch(SQLException sqe){
			System.out.println(sqe.toString());
		}
		
	}

	@Override
	public void processResult() {
		result.add(b);
	}

}
