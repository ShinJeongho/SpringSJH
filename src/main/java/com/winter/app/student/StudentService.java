package com.winter.app.student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private StudentDAO studentDAO;

	public StudentService() {
		studentDAO = new StudentDAO();
	}

	public List<StudentDTO> getStudents() {
		List<StudentDTO> students = null;
		try {
			students = studentDAO.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
}