<%@include file="templates/header.jsp"%>
<div class="container">
	<form action="#" method="post">
		<div class="row">
			<div class="col-md-4 col-lg-4">
				<div class="form-group">
					
					<label for="degree_type"><font color="#e67e22" size="4">Degree Type</label> 
					<br>
					<select name="degree_type" class="btn btn-default btn-lg dropdown-toggle">
						<option value=1>Bachelors</option>
						<option value=2>Masters</option>
						<option value=3>Doctorate</option>
					</select>
					<br>
					
					<label for="departments"><font color="#e67e22" size="4">Departments</label> 
					<br>
					<select name="departments" class="btn btn-default btn-lg dropdown-toggle">
						<option value="CSE">CSE</option>
						<option value="MAE">MAE</option>
						<option value="ARCH">ARCH</option>
						<option value="MATH">MATH</option>
					</select>
					<br>
					
					<label for="degrees"><font color="#e67e22" size="4">Degrees</label> 
					<br>
					<select name="degrees" class="btn btn-default btn-lg dropdown-toggle">
						<option value="Software Engineering">Software Engineering</option>
						<option value="Computer Engineering">Computer Engineering</option>
						<option value="Computer Science">Computer Science</option>
						<option value="Mechanical Engineering">Mechanical Engineering</option>
						<option value="Aerospace Engineering">Aerospace Engineering</option>
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