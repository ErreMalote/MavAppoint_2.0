package uta.mav.appoint.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import uta.mav.appoint.TimeSlotComponent;
import uta.mav.appoint.beans.AllocateTime;
import uta.mav.appoint.beans.Appointment;
import uta.mav.appoint.beans.AppointmentType;
import uta.mav.appoint.beans.CreateAdvisorBean;
import uta.mav.appoint.beans.GetSet;
import uta.mav.appoint.beans.RegisterBean;
import uta.mav.appoint.login.AdminUser;
import uta.mav.appoint.login.AdvisorUser;
import uta.mav.appoint.login.LoginUser;
import uta.mav.appoint.login.StudentUser;

public interface DBImplInterface {
	public Boolean cancelAppointment(int id) throws SQLException;
	public ArrayList<Object> getAppointments(AdvisorUser user) throws SQLException;
	public ArrayList<Object> getAppointments(StudentUser user) throws SQLException;
	public ArrayList<Object> getAppointments(AdminUser user) throws SQLException;
	public Boolean createAppointment(Appointment a, String email) throws SQLException;
	public ArrayList<TimeSlotComponent> getAdvisorSchedule(String name) throws SQLException;
	public Boolean addUser(RegisterBean registerBean) throws SQLException;
	public ArrayList<String> getAdvisors() throws SQLException;
	public AdvisorUser getAdvisor(String email) throws SQLException;
	public LoginUser checkUser(GetSet set) throws SQLException;
	public String addTimeSlot(AllocateTime at) throws SQLException;
	public Connection connectDB();
	public ArrayList<AppointmentType> getAppointmentTypes(String pname) throws SQLException;
	public Boolean updateAppointment(Appointment a);
	public Boolean deleteTimeSlot(AllocateTime at) throws SQLException;
	public Appointment getAppointment(String d, String e) throws SQLException;
	public String addAppointmentType(AdvisorUser user, AppointmentType at) throws SQLException;
	public ArrayList<String> getDepartmentStrings() throws SQLException;
	public ArrayList<String> getMajor() throws SQLException;
	public ArrayList<AdvisorUser> getFullAdvisor() throws SQLException;
	public Integer createUser(String email, String password, String role) throws SQLException;
	public Boolean createAdvisor(Integer userId, String pname, String name_low, String name_high, Integer degree_types, Integer lead_status) throws SQLException;
}
