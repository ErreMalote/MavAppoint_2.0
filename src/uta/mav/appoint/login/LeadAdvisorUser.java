package uta.mav.appoint.login;

import java.util.ArrayList;

import uta.mav.appoint.beans.AllocateTime;
import uta.mav.appoint.visitor.Visitor;

public class LeadAdvisorUser extends AdvisorUser{
	
	public LeadAdvisorUser(String em, String p){
		super(em, p);
	}
	
	@Override
	public String getHeader(){
		return "lead_advisor_header";
	}
}
