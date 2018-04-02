package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Companysite {
	@Id
	@GeneratedValue
	private Long id;
	private String companysitename;

	// @OneToMany
	// @JoinColumn(name = "companysiteid")
	// private Collection<Staff> staffs;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanysitename() {
		return companysitename;
	}

	public void setCompanysitename(String companysitename) {
		this.companysitename = companysitename;
	}

	public Companysite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Companysite(Long id, String companysitename) {
		super();
		this.id = id;
		this.companysitename = companysitename;
	}

}
