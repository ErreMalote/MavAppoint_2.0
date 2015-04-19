package uta.mav.appoint.login;

import java.util.ArrayList;

import uta.mav.appoint.beans.AllocateTime;
import uta.mav.appoint.visitor.Visitor;

/**
 * @author William
 *
 */
public class AdvisorUser extends LoginUser{
	private String password;
	private String pname;
	private String dept;
	private ArrayList<String> majors;
	private String nameLow;
	private String nameHigh;
	private Integer degType;
	private Integer isLead;
	private Integer validated;
	
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
	
	

	public int getValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
