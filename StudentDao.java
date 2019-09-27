package com.nc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nc.model.Student;
import com.nc.utils.DBConnection;  
public class StudentDao implements IStudent {  

       Connection con;

public StudentDao(){
 con = DBConnection.getConnection();
}

     public int insertStudent(Student student) {
    	 int rec=0;
          try {               
               String qry = "insert into student(studentName, studentAddress) values(?,?)";  
               PreparedStatement pst = con.prepareStatement(qry);  
               pst.setString(1, student.getStudentName());  
               pst.setString(2, student.getStudentAddress());  
               pst.execute();
               rec=1;
          } catch (Exception e) {  
               e.printStackTrace();  
          }  
          return rec;
     }  
     public List<Student> getStudentList() {  
          try {  
               List<Student> studentList = new ArrayList<Student>();  
               String qry = "select * from student order by studentId";  
               PreparedStatement pst = con.prepareStatement(qry);  
               ResultSet rs = pst.executeQuery();  
               while (rs.next()) {  
                    Student student = new Student();  
                    student.setStudentId(rs.getInt("studentId"));  
                    student.setStudentName(rs.getString("studentName"));  
                    student.setStudentAddress(rs.getString("studentAddress"));  
                    studentList.add(student);  
               }  
               return studentList;  
          } catch (Exception e) {  
               e.printStackTrace();  
          }  
          return null;  
     }  
     public Student getStudent(int studentId) {  
          try {  
               String qry = "Select * from student where studentId=?";  
               PreparedStatement pst = con.prepareStatement(qry);  
               pst.setInt(1, studentId);  
               ResultSet rs = pst.executeQuery();  
               while (rs.next()) {  
                    Student student = new Student();  
                    student.setStudentId(rs.getInt("studentId"));  
                    student.setStudentName(rs.getString("studentName"));  
                    student.setStudentAddress(rs.getString("studentAddress"));  
                    return student;  
               }  
          } catch (Exception e) {  
               e.printStackTrace();  
          }  
          return null;  
     }  
     public int deleteStudent(int studentId) {
    	 int rec=0;
          try {  
               String qry = "delete from student where studentId=?";  
               PreparedStatement pst = con.prepareStatement(qry);  
               pst.setInt(1, studentId);  
               pst.executeUpdate();
               rec=1;
          } catch (Exception e) {  
               e.printStackTrace();  
          }  
          return rec;
     }  
     public int updateStudent(Student student) {  
    	 int rec=0;
          try {  
               String qry = "update student set studentName=?, studentAddress=? where studentId=?";  
               PreparedStatement pst = con.prepareStatement(qry);  
               pst.setString(1, student.getStudentName());  
               pst.setString(2, student.getStudentAddress());  
               pst.setInt(3, student.getStudentId());  
               pst.executeUpdate();
               rec=1;
          } catch (Exception e) {  
               e.printStackTrace();  
          }  
          return rec;
     }  
}
