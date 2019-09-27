package com.nc.delegate;

import java.util.List;

import com.nc.model.Student;

public interface IStudentDelegate {
	public int insertStudent(Student student);
	public List<Student> getStudentList();
	public Student getStudent(int studentId);
	public int deleteStudent(int studentId);
	public int updateStudent(Student student);

}
