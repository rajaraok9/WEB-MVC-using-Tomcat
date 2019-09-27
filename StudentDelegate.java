package com.nc.delegate;


import java.util.List;

import javax.servlet.RequestDispatcher;

import com.nc.dao.StudentDao;
import com.nc.model.Student;

public class StudentDelegate implements IStudentDelegate{

	StudentDao sd=new  StudentDao();
	/*@Override
	public void process(String command) {
		  if (request.getParameter("add") != null) {  
              sd.insertStudent(student);  
              request.setAttribute("studentList", sd.getStudentList());  
         } else if (request.getParameter("update") != null) {  
              sd.updateStudent(student);  
              request.setAttribute("studentList", sd.getStudentList());  
         } else if (request.getParameter("studentIdForDelete") != null) {  
              sd.deleteStudent(Integer.parseInt(request.getParameter("studentIdForDelete")));  
              request.setAttribute("studentList", sd.getStudentList());  
         } else if (request.getParameter("studentIdForEdit") != null) {  
              student = sd.getStudent(Integer.parseInt(request.getParameter("studentIdForEdit")));  
              request.setAttribute("student", student);  
              RequestDispatcher rs = request.getRequestDispatcher("/studentForm.jsp");  
              rs.forward(request, response);  
              return;  
         }  
		
	}*/
	@Override
	public int insertStudent(Student student) {
		int rec=sd.insertStudent(student);
		return rec;
	}
	@Override
	public List<Student> getStudentList() {
         List<Student> slist=sd.getStudentList();
         return slist;
	}
	@Override
	public Student getStudent(int studentId) {
        Student sid=sd.getStudent(studentId);
        System.out.println("SID "+sid);
		return sid;
	}
	@Override
	public int deleteStudent(int studentId) {
		System.out.println("Student id is "+studentId);
       int rec=sd.deleteStudent(studentId);
		return rec;
	}
	@Override
	public int updateStudent(Student student) {
		int rec=sd.updateStudent(student);
		return rec;
	}
	
}
