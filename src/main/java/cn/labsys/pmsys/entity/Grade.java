package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grade {
	@Id
	@GeneratedValue
	private Long id;
	private String gradename;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGradename() {
		return gradename;
	}

	public void setGradename(String gradename) {
		this.gradename = gradename;
	}

	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grade(Long id, String gradename) {
		super();
		this.id = id;
		this.gradename = gradename;
	}

}
