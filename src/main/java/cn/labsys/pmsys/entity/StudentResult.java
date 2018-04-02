package cn.labsys.pmsys.entity;

public class StudentResult {
	private Long id;
	private String studentname;
	private String gradename;

	// Long id;
	// String studentname, gradename;

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

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public StudentResult(Long id, String studentname, String gradename) {
		super();
		this.id = id;
		this.studentname = studentname;
		this.gradename = gradename;
	}
}
