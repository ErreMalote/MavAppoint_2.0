package uta.mav.appoint.db.command;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import uta.mav.appoint.beans.RegisterBean;

public class RegisterInitialStudent  extends SQLCmd{

	int userid;
	int student_Id;
	int degree_type;
	String phone_num;
	Boolean b;
	
	public RegisterInitialStudent(int id,RegisterBean registerBean){
		userid = id;
		student_Id = registerBean.getStudent_Id();
		degree_type = registerBean.getDegree_type();
		phone_num = registerBean.getPhone_num();
		System.out.println(phone_num+"Initial Student\n");
		b = false;
	}
	
	@Override
	public void queryDB() {
		try{
			String command = "INSERT INTO User_Student (userid,student_Id,degree_type,phone_num) "
								+"values(?,?,?,?)";
			PreparedStatement statement = conn.prepareStatement(command);
			statement.setInt(1,userid);
			statement.setInt(2,student_Id);
			statement.setInt(3,degree_type);
			statement.setString(4,phone_num);
			statement.executeUpdate();
			b = true;
		}
		catch(SQLException sqe){
			System.out.println(sqe.toString()+"RegisterInitialStudent");
		}
		
	}

	@Override
	public void processResult() {
		result.add(b);
	}

}