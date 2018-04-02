package cn.labsys.pmsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.labsys.pmsys.dao.StudentRepository;
import cn.labsys.pmsys.entity.Student;
import cn.labsys.pmsys.entity.StudentResult;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentRepository studentRepository;

	@RequestMapping("/result")
	public List<StudentResult> getStudentResults() {
		List<StudentResult> studentResults = studentRepository.getStudentResults();
		return studentResults;
	}
	
	@RequestMapping("/object")
	public List<Object> getObjectResults() {
		List<Object> studentResults = studentRepository.getObjectResults();
		return studentResults;
	}
	
	@RequestMapping("/re")
	public List<StudentResult> getStuResults() {
		List<StudentResult> studentResults = studentRepository.getStuResults();
		return studentResults;
	}
	
	@RequestMapping("/all")
	public List<Student> getAll() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
}
