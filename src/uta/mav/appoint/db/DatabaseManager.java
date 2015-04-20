package uta.mav.appoint.db;

import java.sql.SQLException;
import java.util.ArrayList;

import uta.mav.appoint.TimeSlotComponent;
import uta.mav.appoint.beans.*;
import uta.mav.appoint.login.*;


public class DatabaseManager {
	private DBImplInterface imp = new RDBImpl();
	
	public Integer createUser(String email, String password, String role) throws SQLException{
		return imp.createUser(email, password, role);
	}
		
	public LoginUser checkUser(GetSet set) throws SQLException{
		return imp.checkUser(set);
	}
	
	public Boolean addUser(RegisterBean registerBean) throws SQLException{
		return imp.addUser(registerBean);
	}
	
	public ArrayList<String> getAdvisors() throws SQLException{
		return imp.getAdvisors();
	}

	public AdvisorUser getAdvisor(String email) throws SQLException{
		return imp.getAdvisor(email);
	}
	
	public ArrayList<TimeSlotComponent> getAdvisorSchedule(String name) throws SQLException{
		return imp.getAdvisorSchedule(name);
	}

	public Boolean createAppointment(Appointment a,String email) throws SQLException{
		return imp.createAppointment(a,email);
	}

	public ArrayList<Object> getAppointments(LoginUser user) throws SQLException{
		if (user instanceof AdvisorUser){
			return imp.getAppointments((AdvisorUser)user);
		}
		else if (user instanceof StudentUser){
			return imp.getAppointments((StudentUser)user);
		}
		else if (user instanceof AdminUser){
			return imp.getAppointments((AdminUser)user);
		}
		else
			return null;
	}

	public Boolean cancelAppointment(int id) throws SQLException{
		return imp.cancelAppointment(id);
	}
	
	public String addTimeSlot(AllocateTime at) throws SQLException{
		return imp.addTimeSlot(at);
	}
	
	public ArrayList<AppointmentType> getAppointmentTypes(String pname) throws SQLException{
		return imp.getAppointmentTypes(pname);
	}
	
	public Boolean updateAppointment(Appointment a) throws SQLException{
		return imp.updateAppointment(a);
	}

	public Boolean deleteTimeSlot(AllocateTime at) throws SQLException{
		return imp.deleteTimeSlot(at);
	}

	public Appointment getAppointment(String date, String email) throws SQLException{
		return imp.getAppointment(date,email);
	}

	public String addAppointmentType(AdvisorUser user, AppointmentType at) throws SQLException{
		return imp.addAppointmentType(user, at);
	}
	
	public ArrayList<String> getDepartmentStrings() throws SQLException{
		return imp.getDepartmentStrings();
	}
	
	public ArrayList<String> getMajor() throws SQLException{
		return imp.getMajor();
	}
	
	public Boolean createAdvisor(Integer userId, String pname, String name_low, String name_high, Integer degree_types, Integer lead_status) throws SQLException{
		return imp.createAdvisor(userId, pname, name_low, name_high, degree_types, lead_status);
	}
	
}

