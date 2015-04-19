<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<%@ page import="java.util.ArrayList"%>

<% ArrayList<String> array = (ArrayList<String>)session.getAttribute("advisors");
	if (array != null){ %>
	
<% ArrayList<String> departments = (ArrayList<String>)session.getAttribute("departments");
%>

<% ArrayList<String> degreeType = (ArrayList<String>)session.getAttribute("degreeType");
%>
	
<% ArrayList<String> major = (ArrayList<String>)session.getAttribute("major");
%>
	
<div class="container">
	<div class="row">
    <div class="col-md-2">
        <label for="drp_department"><font color="#e67e22" size="4">Department</label> 
		<br>
		<select id="drp_department" class="btn btn-default btn-lg dropdown-toggle">
			<option value="select">Select</option>
			<%
							for (int i=0;i<departments.size();i++){
								
								%>
					<option value="option<%=i%>"><%=departments.get(i)%></option>
					<%	}%>
				</form>

		</select> 

    </div>
    <div class="col-md-2">

        <label for="drp_degreeType"><font color="#e67e22" size="4">Degree Type</font></label> 
		<br>
		<select id="drp_degreeType" class="btn btn-default btn-lg dropdown-toggle">
			<option value="select">Select</option>
			<%
							for (int i=0;i<degreeType.size();i++){
								
								%>
					<option value="option<%=i%>"><%=degreeType.get(i)%></option>
					<%	}%>
				</form>
		</select> 
		<br>

    </div>
    <div class="col-md-2">

        <label for="drp_major"><font color="#e67e22" size="4">Major</font></label> 
		<br>
		<select id="drp_major" class="btn btn-default btn-lg dropdown-toggle">
			<option value="select">Select</option>
				<%
							for (int i=0;i<major.size();i++){
								
								%>
					<option value="option<%=i%>"><%=major.get(i)%></option>
					<%	}%>
				</form>
		</select> 
		<br>

    </div>
    
    <div class="col-md-6"></div>
    <br>
	</div>
	<div class="page-header">



		<div class="pull-right form-inline">
			<div class="btn-group">
				<form action="advising" method="post" name="advisor_form">
					<input type=hidden name=advisor_button id="advisor_button">

					<!-- begin processing advisors  -->
					<button type="button" id="all1" onclick="alladvisors()">All</button>
					<script> function alladvisors(){
		    							document.getElementById("advisor_button").value = "all";
		    							advisor_form.submit();
		    						 }
		    				</script>
					<%
							for (int i=0;i<array.size();i++){
								
								%>
					<button type="button" id="button1<%=i%>" onclick="button<%=i%>()"><%=array.get(i)%></button>
					<script> function button<%=i%>(){
											document.getElementById("advisor_button").value = "<%=array.get(i)%>";
											advisor_form.submit();
											}
									</script>
					<%	}%>
				</form>
			</div>
		</div>
	</div>
	<%} 
		 else{%>
	<label><font color="#e67e22" size="5"> Log in to see Advisor schedules.</font></label>
	<% } %>
	<!-- end processing advisors -->

	<div class="date-display span12">
		<h3></h3>
	</div>

	<div id='calendar'></div>
	<%@ page import="uta.mav.appoint.TimeSlotComponent"%>
	<%@ page import="uta.mav.appoint.PrimitiveTimeSlot"%>
	<%@ page import="uta.mav.appoint.CompositeTimeSlot"%>
	<%@ page import="uta.mav.appoint.beans.AdvisingSchedule"%>
	<%@ page import="uta.mav.appoint.beans.Appointment"%>

	<!--  begin processing schedules -->
	<% ArrayList<TimeSlotComponent> schedules = (ArrayList<TimeSlotComponent>)session.getAttribute("schedules");
		   ArrayList<Appointment> appointments = (ArrayList<Appointment>)session.getAttribute("appointments");
		    				%><script>
		    				$(document).ready(function(){
		    					$('#calendar').fullCalendar({
		    						header: {
		    							left:'month,basicWeek,basicDay',
		    							right: 'today, prev,next',
		    							center: 'title'
		    						},
		    						displayEventEnd : {
		    							month: true,
		    							basicWeek: true,
		    							'default' : true,
		    						}
		    						<%if (schedules != null){%>
		    				    	,
		    						eventClick: function(event,element){
		    							if (event.id >= 0){
		    							document.getElementById("id1").value = event.id;
		    							document.getElementById("pname").value = event.title;
		    							addAppt.submit();
		    							}
		    							else{
		    								updateAppt.submit();
		    							}
		    						},
		    					events: [
		 		    		<% int i = 0;
									for (i=0;i<schedules.size();i++){%> 
		 								{
		 									title:'<%=schedules.get(i).getName()%>',
		 									start:'<%=schedules.get(i).getDate()+"T"+schedules.get(i).getStartTime()%>',
		 									end:'<%=schedules.get(i).getDate()+"T"+schedules.get(i).getEndTime()%>',
		 									id:<%=i%>,
		 									backgroundColor: 'blue'
		 								}
		 								<%if(i != (schedules.size()-1)||appointments != null){%>,<%}%>
		 					 		<%}	
									if (appointments != null){
										for(i=1;i<1+appointments.size();i++){%>
		 									{
 												title:'<%=appointments.get(i-1).getAppointmentType()%>',
 												start:'<%=appointments.get(i-1).getAdvisingDate()+"T"+appointments.get(i-1).getAdvisingStartTime()%>',
 												end:'<%=appointments.get(i-1).getAdvisingDate()+"T"+appointments.get(i-1).getAdvisingEndTime()%>',
 												id:<%=-i%>,
 												backgroundColor: 'orange'
 											}[
 											  <%if(i != appointments.size()){%>,<%}
 										}
									}%>		 					 
		 					 			]<%}%>
		    					});
		    				});
	 						</script>


	<form name=addAppt action="schedule" method="get">
		<input type="hidden" name=id1 id="id1"> <input type="hidden"
			name=pname id="pname"> <input type="hidden"
			name=advisor_email id="advisor_email">
	</form>

	<form name=updateAppt action="appointments" method="get"></form>

	<br /> <br />
	<hr>
</div>
<style>
#calendar {
	background-color: white;
}
</style>
<%@include file="templates/footer.jsp"%>