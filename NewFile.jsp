<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,javax.naming.*,javax.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
		Connection conn = ds.getConnection();
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from student");
		while(rs.next()){
		out.println(rs.getString("studentName")+" "+rs.getString("studentAddress"));
		}
		}
		catch(NamingException ne) {
			System.out.println(ne);
			
		}
		catch(SQLException se) {
			System.out.println(se);
		}
		

 %>
</body>
</html>