<%@page import="com.nc.model.Student"%>  
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
   pageEncoding="ISO-8859-1"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>  
 <head>   
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
 <title>Insert title here</title>  
 </head>
 <style>

</style>  
 <body>  
 
 <%  
 Student student = (Student)request.getAttribute("student");  
 if(student==null){  
      student = new Student();  
      student.setStudentId(0);  
      student.setStudentName("");  
      student.setStudentAddress("");  
         
 }  
 %>
      <h1>Student Form</h1>  
      <form action="StudentServlet" method="get">  
      <input type="hidden" value="<%=student.getStudentId()%>" name="studentId">  
      Student Name <input type="text" value="<%=student.getStudentName() %>" name="studentName">  
      Student Address <input type="text" value="<%=student.getStudentAddress() %>" name="studentAddress">  

      <input type=submit value="add" name="req">
      <input type=submit value="update" name="req" class="disp" id="disp">
      </form>  
 </body>  
 </html>  