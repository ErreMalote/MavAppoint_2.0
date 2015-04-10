<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
	<label><font color="#e67e22" size="5"> Create New Advisor: </label>
			
	<form action="create_advisor" method="post" name="advisor_form" onsubmit="return false;">
		<div class="form-group">
					<label for="emailAddress"><font color="#e67e22" size="4">Email Address</label><br>
		 			<input type="text" style="width:350px;" class="form-control" id="emailAddress"
		 				placeholder="advisor@uta.edu">
				</div>
				<div>
					<label for="pname"><font color="#e67e22" size="4">Display Name</label><br>
		 			<input type="text" style="width:350px;"class="form-control" id="pname"
		 				placeholder="Dr. Advisor">
					<label for="lead_TF"><font color="#e67e22" size="4">Lead Advisor</label><br>
					<select id="lead_TF" class="btn btn-default btn-lg dropdown-toggle">
					<option value="True">True</option>
					<option value="False">False</option>
					</select>
				</div>
				<input type="submit" value="submit" onclick="javascript:FormSubmit();">
	</form>			 	
	<label id="result"><font color="#e67e22" size="4"></font></label>
	<script> function FormSubmit(){
									var email = document.getElementById("emailAddress").value;
									var pname = document.getElementById("pname").value;
									var lead_TF = // document.getElementById("lead_TF").value; Hi this should get the info for lead advisor
									var params = ('emailAddress='+email+'&pname='+pname); // please add a parameter for lead advisor
									var xmlhttp;
									xmlhttp = new XMLHttpRequest();
									xmlhttp.onreadystatechange=function(){
										if (xmlhttp.readyState==4){
											document.getElementById("result").innerHTML = xmlhttp.responseText;	
										}
									}
									xmlhttp.open("POST","create_advisor",true);
									xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
									xmlhttp.setRequestHeader("Content-length",params.length);
									xmlhttp.setRequestHeader("Connection","close");
									xmlhttp.send(params);// here it sends the parameters
									document.getElementById("result").innerHTML = "Attempting to create new Advisor...";
								}
								</script>
<%@include file="templates/footer.jsp" %>