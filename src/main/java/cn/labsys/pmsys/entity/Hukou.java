package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hukou {
	@Id
	@GeneratedValue
	private Long id;
	private String hukoutype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHukoutype() {
		return hukoutype;
	}

	public void setHukoutype(String hukoutype) {
		this.hukoutype = hukoutype;
	}

	public Hukou() {
		super();
	}
}
