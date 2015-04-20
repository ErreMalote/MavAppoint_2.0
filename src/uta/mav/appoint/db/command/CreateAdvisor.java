package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uta.mav.appoint.beans.CreateAdvisorBean;

public class CreateAdvisor extends SQLCmd{

	Integer userId;
	String pname;
	String name_low;
	String name_high;
	Integer degree_types;
	Integer lead_status;
	Boolean b;
	
	public CreateAdvisor(Integer userId, String pname, String name_low, String name_high, Integer degree_types, Integer lead_status){
		this.userId = userId;
		this.pname = pname;
		this.name_low = name_low;
		this.name_high = name_high;
		this.degree_types = degree_types;
		this.lead_status = lead_status;
		
		b = false;
	}
	
	@Override
	public void queryDB() {
		try{
			String command = "INSERT INTO User_Advisor (userid,pname,notification,name_low,name_high,degree_types,lead_status) "
								+"values(?,?,?,?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setInt(1,userId);
			statement.setString(2,pname);
			statement.setString(3,"Day");
			statement.setString(4,name_low);
			statement.setString(5,name_high);
			statement.setInt(6,degree_types);
			statement.setInt(7,lead_status);
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
