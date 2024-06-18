package com.winter.app.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // 이 클래스가 컨트롤러임을 나타냅니다.
public class StudentController {
	@Autowired // StudentService 객체를 자동으로 주입합니다.
	private StudentService studentService;

	@RequestMapping("/student/list") // /student/list URL 경로에 대한 GET 요청을 처리합니다.
	public String getList(HttpServletRequest request) {
		List<StudentDTO> ar = studentService.getStudents();
		request.setAttribute("list", ar);

		return "student/list"; // student/list 뷰를 반환합니다.
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.GET) // /student/add URL 경로에 대한 GET 요청을 처리합니다.
	public String add() {
		return "student/add"; // student/add 뷰를 반환합니다.
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.POST) // /student/add URL 경로에 대한 POST 요청을 처리합니다.
	public String addStudent(HttpServletRequest request) {
		String name = request.getParameter("name"); // 요청에서 name 파라미터를 가져옵니다.
		int num = Integer.parseInt(request.getParameter("num"));// 요청에서 num 파라미터를 가져와 정수로 변환합니다.
		double avg = Double.parseDouble(request.getParameter("avg")); // 요청에서 avg 파라미터를 가져와 실수로 변환합니다.

		StudentDTO student = new StudentDTO(); // 새로운 StudentDTO 객체를 생성합니다.
		student.setName(name);// 학생 이름을 설정합니다.
		student.setNum(num); // 학생 넘버를 설정합니다.
		student.setAvg(avg); // 학생 평균을 설정합니다.

		// studentService.addStudent(student); // 학생을 추가합니다.

		return "redirect:/student/list"; // 학생 목록 페이지로 리디렉션합니다.
	}
}