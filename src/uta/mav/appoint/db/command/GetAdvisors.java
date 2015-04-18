package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAdvisors extends SQLCmd{
	
	public GetAdvisors(){
		super();
	}
	
	
	@Override
	public void queryDB(){
		try{
			String command = "SELECT pname FROM USER,User_Advisor WHERE (ROLE=? or ROLE=?) AND USER.userid = User_Advisor.userid";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1,"advisor");
			statement.setString(2,"lead_advisor");
			res = statement.executeQuery();	
		}
		catch(SQLException sq){
			System.out.printf(sq.toString());
		}
	}
	
	@Override
	public void processResult(){
		try{
			while (res.next()){
				result.add(res.getString(1));
			}
		}
		catch(SQLException sq){
			System.out.println(sq.toString());
		}
		
	}
}
