<%@include file="top_header.jsp" %>
			<div>
				<ul class="nav navbar-nav">
				<li><a href="availability"><font style="color:#e67e22"> Update Schedule</font> </a></li>
				<li><a href="appointments"><font style="color:#e67e22"> Appointments</font> </a></li>
				<li><a href="advising"><font style="color:#e67e22"> Show Schedule </font></a></li>
				<li><a href="customize"><font style="color:#e67e22">Customize Settings</font></a></li>
                <li><a href="#assig_students_advisors" data-toggle="modal"><font style="color:#e67e22">Assign Students To Advisors </a> </li>
				</ul>
                <!-- Modal HTML -->
	
				<ul class="nav navbar-nav navbar-right">
				
				<li><a href="#"><font style="color:#e67e22">You are logged in as an Advisor.</font></a></li>
				<li><a href="logout"><span class="glyphicon glyphicon-log-in"><font style="color:#e67e22">Logout</font></a></li>
				</ul>
                  
			</div>
		</div>
	</nav>
</div>
<div class="modal fade" id="assig_students_advisors" tabindex="-1" role="m" aria-labelledby="assig_students_advisors" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h2 class="modal-title sidebar-title">Assign Students To Advisors</h2>
			
	 </div>
	 <div id="upperPannel" class="modal-body container-fluid" >
		 <div  class="col-md-6">
			 <!-- Single button -->
        <div>
                <h5>Advisors</h5>
               <select type="button" class="btn btn-default dropdown-toggle  pull-left" 
                  data-toggle="dropdown">
                   <option>Dr. Barasch</option>
                  <option>Dr. Becker</option>
                  <option>Dr. Stefan</option>
                    <option>Dr. Elmasri</option></select>
               
             </div>

		 </div>


		 <div  class="col-md-6">
             <!--middle Content -->
			 

		 </div>
         <!-- second row -->
    </div>  
		 <div id="middlePannel" class = "modal-body container-fluid">
			<div  class="col-md-12">
			 <h2>Last Names</h2>
		    </div>
	     </div>
	     <div id="middlePannel" class = "modal-body container-fluid">
			<div  class="col-md-3">
			 <div>
                <h5>Starts</h5>
               <select type="button" class="btn btn-default dropdown-toggle  pull-left" 
                  data-toggle="dropdown">
                   <option>A</option>
                    <option>B</option>
                    <option>C</option>
                    <option>D</option>
                    <option>E</option>
                    <option>F</option>
                    <option>G</option>
                    <option>H</option>
                    <option>I</option>
                    <option>J</option>
                    <option>K</option>
                    <option>L</option>
                    <option>M</option>
                    <option>N</option>
                    <option>O</option>
                    <option>P</option>
                    <option>Q</option>
                    <option>R</option>
                    <option>S</option>
                    <option>T</option>
                    <option>U</option>
                    <option>V</option>
                    <option>W</option>
                    <option>X</option>
                    <option>Y</option>
                    <option>Z</option></select>
               
             </div>
		    </div>
             <div  class="col-md-3">
              <div>
                <h5>Ends</h5>
               <select type="button" class="btn btn-default dropdown-toggle  pull-left" 
                  data-toggle="dropdown">
                   <option>A</option>
                    <option>B</option>
                    <option>C</option>
                    <option>D</option>
                    <option>E</option>
                    <option>F</option>
                    <option>G</option>
                    <option>H</option>
                    <option>I</option>
                    <option>J</option>
                    <option>K</option>
                    <option>L</option>
                    <option>M</option>
                    <option>N</option>
                    <option>O</option>
                    <option>P</option>
                    <option>Q</option>
                    <option>R</option>
                    <option>S</option>
                    <option>T</option>
                    <option>U</option>
                    <option>V</option>
                    <option>W</option>
                    <option>X</option>
                    <option>Y</option>
                    <option>Z</option></select>
               
             </div>
             </div>
	     </div>
        <div id="middlePannel" class = "modal-body container-fluid">
			<div  class="col-md-12">
			 <div>
                <h5>Degree Type</h5>
               <select type="button" class="btn btn-default dropdown-toggle  pull-left" 
                  data-toggle="dropdown">
                   <option>Bachelors</option>
                  <option>Masters</option>
                  <option>Doctorate</option></select>
               
             </div>
		    </div>
	     </div>
            <div id="middlePannel" class = "modal-body container-fluid">
			<div  class="col-md-12">
			 <div>
                <h5>Major</h5>
               <select type="button" class="btn btn-default dropdown-toggle  pull-left" 
                  data-toggle="dropdown">
                  <option>Computer Science</option>
                  <option>Computer Engineering</option>
                  <option>Software Engineering</option></select>
               
             </div>
		    </div>
	     </div>
	<div class="container-fluid">
	  <div class="modal-footer col-md-12">
		
		<button type="button" class=" btn btn-primary" data-dismiss="modal">Save</button>
	</div>
	</div>
	</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->