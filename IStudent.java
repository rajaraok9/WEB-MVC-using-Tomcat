package com.nc.dao;

import java.util.List;

import com.nc.model.Student;

public interface IStudent {
	public int insertStudent(Student student);
	public List<Student> getStudentList();
	public Student getStudent(int studentId);
	public int deleteStudent(int studentId);
	public int updateStudent(Student student);
	 
}
