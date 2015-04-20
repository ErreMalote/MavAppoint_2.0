package uta.mav.appoint.login;

import java.util.ArrayList;

import uta.mav.appoint.beans.AllocateTime;
import uta.mav.appoint.db.DatabaseManager;
import uta.mav.appoint.visitor.Visitor;

/**
 * @author William
 *
 */
public class AdvisorUser extends LoginUser{
	private String pname;
	private String dept;
	private ArrayList<String> majors;
	private String nameLow;
	private String nameHigh;
	private Integer degType;
	private Integer isLead;
	
	public AdvisorUser(String email, String password, String pname, String name_low, String name_high, Integer degree_types, Integer lead_status){
		super(email,password,"advisor");
		this.pname = pname;
		this.nameLow = name_low;
		this.nameHigh = name_high;
		this.degType = degree_types;
		this.isLead = lead_status;
		
		try
		{
			DatabaseManager databaseManager = new DatabaseManager();
			databaseManager.createAdvisor(getUserId(), pname, name_low, name_high, degree_types, lead_status);
		} catch (Exception e){
			System.out.println(e+"AdvisorUser");
		}

	}
	
	public AdvisorUser(String em, String p){
		super(em);
		pname = p;
	}
	
	public AdvisorUser(String em){
		super(em);
	}
	
	@Override
	public String getHeader(){
		if(isLead == 0){
			return "advisor_header";
		}else{
			return "lead_advisor_header";
		}
	}

	/**
	 * @return the pname
	 */
	@Override
	public String getPname() {
		return pname;
	}
	
	
	@Override
	public void accept(Visitor v){
		v.check(this);
	}
	
	@Override
	public ArrayList<Object> accept(Visitor v, Object o){//allow javabean to be passed in
		return v.check(this,o);
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public ArrayList<String> getMajors() {
		return majors;
	}

	public void setMajors(ArrayList<String> majors) {
		this.majors = majors;
	}

	public String getNameLow() {
		return nameLow;
	}

	public void setNameLow(String nameLow) {
		this.nameLow = nameLow;
	}

	public String getNameHigh() {
		return nameHigh;
	}

	public void setNameHigh(String nameHigh) {
		this.nameHigh = nameHigh;
	}

	public Integer getDegType() {
		return degType;
	}

	public void setDegType(Integer degType) {
		this.degType = degType;
	}

	public int getIsLead() {
		return isLead;
	}

	public void setIsLead(int isLead) {
		this.isLead = isLead;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}
	
	
}
