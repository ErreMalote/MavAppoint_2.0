<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<%@ page import="java.util.ArrayList"%>

<%
 ArrayList<String> departments = (ArrayList<String>)session.getAttribute("departments");
 ArrayList<String> degreeType = (ArrayList<String>)session.getAttribute("degreeType");
 ArrayList<String> major = (ArrayList<String>)session.getAttribute("major");
%>
<div class="container">
	<form action="#" method="post">
		<div class="row">
			<div class="col-md-4 col-lg-4">
				<div class="form-group">
				
			        <label for="drp_department"><font color="#e67e22" size="4">Department</label> 
					<br>
					<select id="drp_department" name="drp_department" class="btn btn-default btn-lg dropdown-toggle">
						<option value="select">Select</option>
						<%
										for (int i=0;i<departments.size();i++){
											
											%>
								<option value=<%=departments.get(i)%>><%=departments.get(i)%></option>
								<%	}%>
							</form>
			
					</select> 
					<br>
					
			        <label for="drp_degreeType"><font color="#e67e22" size="4">Degree Type</font></label> 
					<br>
					<select id="drp_degreeType" name="drp_degreeType" class="btn btn-default btn-lg dropdown-toggle">
						<option value="select">Select</option>
						<%
										for (int i=0, j=1;i<degreeType.size();i++, j*=2){
											
											%>
								<option value=<%=j%>><%=degreeType.get(i)%></option>
								<%	}%>
							</form>
					</select> 
					<br>
			
			        <label for="drp_major"><font color="#e67e22" size="4">Major</font></label> 
					<br>
					<select id="drp_major" name="drp_major" class="btn btn-default btn-lg dropdown-toggle">
						<option value="select">Select</option>
							<%
										for (int i=0;i<major.size();i++){
											
											%>
								<option value=<%=major.get(i)%>><%=major.get(i)%></option>
								<%	}%>
							</form>
					</select> 
					<br>
					
					<label for="student_Id"><font color="#e67e22" size="4">Student ID</label> 
					<br>
					<input type="text" class="form-control" name=student_Id placeholder="1000xxxxxx or 6000xxxxxx">
					
					<label for="phone_num"><font color="#e67e22" size="4">Phone Number</label> 
					<br>
					<input type="text" class="form-control" name=phone_num placeholder="xxx-xxx-xxxx">
					
					<label for="emailAddress"><font color="#e67e22" size="4">Email Address</label> 
					<br>
					<input type="text" class="form-control" name=emailAddress placeholder="firstname.lastname@mavs.uta.edu"> 
					
					<label for="password"><font color="#e67e22" size="4">Password</label> 
					<br>
					<input type="password" class="form-control" name=password>
					
					<label for="repeatPassword"><font color="#e67e22" size="4">Repeat Password</label> 
					<br>
					<input type="password" class="form-control" name=repeatPassword>
				</div>
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		</p>
		<%@include file="templates/footer.jsp"%>