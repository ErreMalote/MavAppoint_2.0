<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page='<%=(String) request.getAttribute("includeHeader")%>' />

 <div class="container">
      <h2>Table</h2>
      <p>The .table class adds basic styling (light padding and only horizontal dividers) to a table:</p>            
      <table class="table">
        <thead>
          <tr>
            <th>#</th>
            <th>Firstname</th>
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
<%@include file="templates/footer.jsp"%>