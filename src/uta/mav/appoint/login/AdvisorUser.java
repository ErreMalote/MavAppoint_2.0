package uta.mav.appoint.login;

import java.util.ArrayList;

import uta.mav.appoint.beans.AllocateTime;
import uta.mav.appoint.visitor.Visitor;

public class AdvisorUser extends LoginUser{
	private String pname;
	private String dept;
	private ArrayList<String> degrees;
	private Character nameLow;
	private Character nameHigh;
	private String degType;
	
	public AdvisorUser(String em, String p){
		super(em);
		pname = p;
	}
	
	@Override
	public String getHeader(){
		return "advisor_header";
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
}
