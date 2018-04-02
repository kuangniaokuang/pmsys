package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	@GeneratedValue
	private Long id;
	private Integer rankno;
	private String departmentname;
	private Long parentid;
	// 0 未删除；1 删除
	private Integer deleteflag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRankno() {
		return rankno;
	}

	public void setRankno(Integer rankno) {
		this.rankno = rankno;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}

	public Integer getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, Integer rankno, String departmentname, Long parentid,
			Integer deleteflag) {
		super();
		this.id = id;
		this.rankno = rankno;
		this.departmentname = departmentname;
		this.parentid = parentid;
		this.deleteflag = deleteflag;
	}

}
