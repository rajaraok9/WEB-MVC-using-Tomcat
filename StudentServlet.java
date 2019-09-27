package com.nc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nc.delegate.StudentDelegate;
import com.nc.model.Student;

/**
 * Servlet implementation class StudentServlet 
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 try {  
             //StudentDao sd = new StudentDao();
			 StudentDelegate isd=new StudentDelegate();
			 
             Student student = new Student();  
             if(request.getParameter("studentId")!=null)  
             student.setStudentId(Integer.parseInt(request.getParameter("studentId")));  
             student.setStudentName(request.getParameter("studentName"));  
             student.setStudentAddress(request.getParameter("studentAddress"));  
             String command[]=request.getParameterValues("req");
             for(String s:command) {
            	 switch(s) {
            	 case "add":
            		 int rec=isd.insertStudent(student);
            		 System.out.println("Rec is "+rec);
            		 request.setAttribute("studentList", isd.getStudentList());
            		 RequestDispatcher rspa = request.getRequestDispatcher("/studentList.jsp");  
                     rspa.forward(request, response);  
            		 break;
            	 case "update":
            		 isd.updateStudent(student);
            		 request.setAttribute("studentList", isd.getStudentList());
            		 RequestDispatcher rspu = request.getRequestDispatcher("/studentList.jsp");  
                     rspu.forward(request, response);  
            		 break;
            	 case "edit":
            		Student student1=isd.getStudent(Integer.parseInt(request.getParameter("studentIdForEdit")));
            		 request.setAttribute("student", student1);  
                     RequestDispatcher rs = request.getRequestDispatcher("/studentForm.jsp");  
                     rs.forward(request, response);  
            		 break;
            	 case "delete":
            		 int recs=Integer.parseInt(request.getParameter("studentIdForDelete"));
            		 Student student2=isd.getStudent(recs);
            		 isd.deleteStudent(student2.getStudentId());
            		  System.out.println(student2+" student 2");
            		  request.setAttribute("studentList", isd.getStudentList());
            		  //sd.deleteStudent(Integer.parseInt(request.getParameter("studentIdForDelete")));  
                     //request.setAttribute("studentList", isd.getStudentList());
                     RequestDispatcher rsp = request.getRequestDispatcher("/studentList.jsp");  
                     rsp.forward(request, response);  
            		 break;

            	 case "list":
            		 request.setAttribute("studentList", isd.getStudentList());
            		 RequestDispatcher rspl = request.getRequestDispatcher("/studentList.jsp");  
                     rspl.forward(request, response);  
            		 break;
            		 
            		    
            	 }
             }
            	 
            //RequestDispatcher rs = request.getRequestDispatcher("studentList.jsp");  
             //rs.forward(request, response);  
        } catch (Exception e) {  
             e.printStackTrace();  
        }  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	          
	}
	
}



