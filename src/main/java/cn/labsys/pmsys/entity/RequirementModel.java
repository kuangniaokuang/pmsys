package cn.labsys.pmsys.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RequirementModel {
	private Long id;
	private Integer addtype;// 需求类型
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date formdate;// 填表日期 Date
	private Long departmentid;
	private String departmentname;
	private Long companysiteid;// 工作地点
	private String companysitename;
	private String suggestsalary;// 建议薪资
	private String positionname;// 增补职位
	private Integer addreason;// 申请增补理由 扩大编制，辞职补充
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date arrivaldate;// 期望到岗日期 Date
	private Integer addcount;// 增补额（人）Integer
	private Integer sex;// 性别
	private String education;// 学历
	private String appearance;// 身高/外貌
	private Integer marrystatus;// 婚姻
	private String major;// 专业
	private String others;// 其他
	private Integer age;// 年龄
	private String trait;// 性格
	private String experience;// 具备技能及工作经验
	private String duty;// 岗位职责
	private String proposer;// 申请人
	private String manager;// 总经理
	private String director;// 分管负责人
	private String chairman;// 董事长
	private String hr;// 人力资源部门

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAddtype() {
		return addtype;
	}

	public void setAddtype(Integer addtype) {
		this.addtype = addtype;
	}

	public Date getFormdate() {
		return formdate;
	}

	public void setFormdate(Date formdate) {
		this.formdate = formdate;
	}

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public Long getCompanysiteid() {
		return companysiteid;
	}

	public void setCompanysiteid(Long companysiteid) {
		this.companysiteid = companysiteid;
	}

	public String getCompanysitename() {
		return companysitename;
	}

	public void setCompanysitename(String companysitename) {
		this.companysitename = companysitename;
	}

	public String getSuggestsalary() {
		return suggestsalary;
	}

	public void setSuggestsalary(String suggestsalary) {
		this.suggestsalary = suggestsalary;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public Integer getAddreason() {
		return addreason;
	}

	public void setAddreason(Integer addreason) {
		this.addreason = addreason;
	}

	public Date getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(Date arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public Integer getAddcount() {
		return addcount;
	}

	public void setAddcount(Integer addcount) {
		this.addcount = addcount;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAppearance() {
		return appearance;
	}

	public void setAppearance(String appearance) {
		this.appearance = appearance;
	}

	public Integer getMarrystatus() {
		return marrystatus;
	}

	public void setMarrystatus(Integer marrystatus) {
		this.marrystatus = marrystatus;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTrait() {
		return trait;
	}

	public void setTrait(String trait) {
		this.trait = trait;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getProposer() {
		return proposer;
	}

	public void setProposer(String proposer) {
		this.proposer = proposer;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getChairman() {
		return chairman;
	}

	public void setChairman(String chairman) {
		this.chairman = chairman;
	}

	public String getHr() {
		return hr;
	}

	public void setHr(String hr) {
		this.hr = hr;
	}

	public RequirementModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequirementModel(Long id, Integer addtype, Date formdate, Long departmentid, String departmentname,
			Long companysiteid, String companysitename, String suggestsalary, String positionname, Integer addreason,
			Date arrivaldate, Integer addcount, Integer sex, String education, String appearance, Integer marrystatus,
			String major, String others, Integer age, String trait, String experience, String duty, String proposer,
			String manager, String director, String chairman, String hr) {
		super();
		this.id = id;
		this.addtype = addtype;
		this.formdate = formdate;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.companysiteid = companysiteid;
		this.companysitename = companysitename;
		this.suggestsalary = suggestsalary;
		this.positionname = positionname;
		this.addreason = addreason;
		this.arrivaldate = arrivaldate;
		this.addcount = addcount;
		this.sex = sex;
		this.education = education;
		this.appearance = appearance;
		this.marrystatus = marrystatus;
		this.major = major;
		this.others = others;
		this.age = age;
		this.trait = trait;
		this.experience = experience;
		this.duty = duty;
		this.proposer = proposer;
		this.manager = manager;
		this.director = director;
		this.chairman = chairman;
		this.hr = hr;
	}
}
