<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<div class="container">
	<label><font color="#e67e22" size="5"> Create New
			Advisor: </label>

	<form action="create_advisor" method="post" name="advisor_form"
		onsubmit="return false;">
		<div class="form-group">
			<label for="emailAddress"><font color="#e67e22" size="4">Email
					Address</label><br> <input type="text" style="width: 350px;"
				class="form-control" id="emailAddress" placeholder="">
		</div>
		<div>
			<label for="pname"><font color="#e67e22" size="4">Display
					Name</label><br> <input type="text" style="width: 350px;"
				class="form-control" id="pname" placeholder="">
		</div>

		<div>
			<label for="isLead"><font color="#e67e22">Lead Advisor</label><br>
			<select id="isLead" class="btn btn-default btn-lg dropdown-toggle">
				<option value=1>True</option>
				<option value=2>False</option>
			</select> <br>
		</div>

		<br> <input type="submit" value="submit"
			onclick="javascript:FormSubmit();">
	</form>
</div>

<label id="result"><font color="#e67e22" size="4"></font></label>
<script> function FormSubmit(){
									var email = document.getElementById("emailAddress").value;
									var pname = document.getElementById("pname").value;
									var isLead = document.getElementById("isLead").value;
									var params = ('emailAddress='+email+'&pname='+pname+'&isLead='+isLead);
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
									xmlhttp.send(params);
									document.getElementById("result").innerHTML = "Attempting to create new Advisor...";
								}
								</script>
<%@include file="templates/footer.jsp"%>