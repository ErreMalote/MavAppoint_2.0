package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;

import uta.mav.appoint.beans.AllocateTime;

public class UpdateTimeSlot extends SQLCmd{
	String date;
	String start;
	String end;
	String email;
	Boolean b;
	
	public UpdateTimeSlot(AllocateTime at){
		date = at.getDate();
		start = at.getStartTime();
		end = at.getEndTime();
		email = at.getEmail();
		b = false;
	}
	
	public void queryDB(){
		try{
			String command = "DELETE FROM advising_schedule,User_Advisor WHERE date=? AND start >=? AND end <=? AND User_Advisor.pname=? AND User_Advisor.userid=user.userid";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setString(1, date);
			statement.setString(2, start);
			statement.setString(3, end);
			statement.setString(4, email);
			b = true;
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void processResult(){
		result.add(b);
	}

}
