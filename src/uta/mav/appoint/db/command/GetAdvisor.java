package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAdvisor extends SQLCmd{
	private String email;
	private int userId;
	
	public GetAdvisor(String email){
		super();
		this.email = email;
	}
	
	
	@Override
	public void queryDB(){
		try{
			SQLCmd cmd = new GetUserID(email);
			cmd.execute();
			userId = (int)cmd.getResult().get(0);
			
			String command = "SELECT password,validated,pName,name_low,name_high,degree_types,lead_status,Department_User.name,Major_User.name FROM User,User_Advisor,Department_User,Major_User WHERE USER.userId=? and User_Advisor.userId=? and Department_User.userId=? and Major_User.userId=?";
			PreparedStatement statement = conn.prepareStatement(command);
			int i=1;
			statement.setInt(i,userId);
			i++;
			statement.setInt(i,userId);
			i++;
			statement.setInt(i,userId);
			i++;
			statement.setInt(i,userId);
			res = statement.executeQuery();
		}
		catch(SQLException sq){
			System.out.printf(sq.toString());
		}
	}
	
	@Override
	public void processResult(){
		try{
			int row = 1;
			while (res.next()){
				for(int i=1; i<=9; i++)
					if(row==1 || i==9)
						result.add(res.getString(i));
				row++;
			}
		}
		catch(SQLException sq){
			System.out.println(sq.toString());
		}
		
	}
}
