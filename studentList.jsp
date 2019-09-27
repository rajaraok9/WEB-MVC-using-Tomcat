<%@page import="java.util.*"%>  
 <%@page import="com.nc.model.Student"%>  
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>  
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
 <html>  
 <head>  
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
 <title>Insert title here</title>  
 </head>  
 <body>  
           <h1>Student List</h1>  
           <%  
           List<Student> studentList = (ArrayList<Student>)request.getAttribute("studentList");  
           System.out.println("Student list "+studentList);
           %>  
           <table>  
           <tr>  
           <td>Id</td>  
           <td>Student Name</td>  
           <td>Student Address</td>  
           <td>Edit</td>  
           <td>Delete</td>  
           </tr>  
           <% for(Student student:studentList){ %>  
           <tr>  
           <td><%=student.getStudentId()%></td>  
           <td><%=student.getStudentName()%></td>  
           <td><%=student.getStudentAddress()%></td>  
           <td><a href="./StudentServlet?req=edit&studentIdForEdit=<%=student.getStudentId()%>">Edit</a></td>  
           <td><a href="./StudentServlet?req=delete&studentIdForDelete=<%=student.getStudentId()%>">Delete</a></td>  
           </tr>  
           <%} %>  
           </table>  
 </body>  
 </html>  