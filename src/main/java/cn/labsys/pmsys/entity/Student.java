package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private Long id;
	private String studentname;
	@ManyToOne
	@JoinColumn(name = "gradeid", referencedColumnName = "id")
	private Grade grade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentname() {
		return studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long id, String studentname, Grade grade) {
		super();
		this.id = id;
		this.grade = grade;
		this.studentname = studentname;
	}

}
