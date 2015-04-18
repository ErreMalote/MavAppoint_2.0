<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<div class="container">
<!-- Panel -->
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading"><h1>Assign Students To Advisors</h1></div>
  <div class="panel-body">
  	<h2>Ranges - Uses the first letter of the last name</h2>
  	<h4>Low - low end of range </h4>
    <h4>High - High end of the range </h4>
  </div>
  <!-- Table -->
    
      <table class="table">
        <thead>
          <tr>
            <th>Advisor</th>
            <th>Low</th>
            <th>High</th>
            <th>Degree</th>
            <th>Degree Type</th>
          </tr>
        </thead>
        <tbody>
          
        </tbody>
      </table>
    </div>
   </div>
    
<%@include file="templates/footer.jsp"%>