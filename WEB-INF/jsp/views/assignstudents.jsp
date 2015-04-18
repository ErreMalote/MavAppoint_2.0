<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />
<div class="container">
<!-- Panel -->
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Panel heading</div>
  <div class="panel-body">
  	<h1>Ranges</h1>
  	<h3></h3><p></p>
  	<br>
    <h3></h3><p></p>
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
          <tr>
            <td>1</td>
            <td>Anna</td>
          </tr>
          <tr>
            <td>2</td>
            <td>Debbie</td>
          </tr>
          <tr>
            <td>3</td>
            <td>John</td>
          </tr>
        </tbody>
      </table>
    </div>
   </div>
    
<%@include file="templates/footer.jsp"%>