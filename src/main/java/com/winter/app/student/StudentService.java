package com.winter.app.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

	private List<StudentDTO> students = new ArrayList<StudentDTO>();

	public List<StudentDTO> getList() {
		return students;
	}

	public void addStudent(StudentDTO student) {
		students.add(student);
	}
}