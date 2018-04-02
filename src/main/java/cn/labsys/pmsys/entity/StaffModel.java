package cn.labsys.pmsys.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 职工信息表
 * 
 * @author ChrisBerger
 *
 */
public class StaffModel {
	private Long id;
	private String staffno;// 序号
	private String imgurl;// 照片
	private String staffname;// 姓名
	// 0 离职；1 在职
	private Integer workingstate;// 状态 Integer
	private Long departmentid;// 部门
	private Long companysiteid;// 市
	private String positionname;// 职位
	// 0 女；1 男
	private Integer sex;// 性别 Integer
	private String idcardno;// 身份证号码
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date birthday;// 出生日期 Date
	private String nationality;// 民族
	// 1 本地城镇;2 本地农村;3 外埠城镇;4 外埠农村
	private Long hukouid;// 户口类型 Long
	// 0 未婚；1 已婚
	private Integer marrystatus;// 婚否 Integer
	// 1 党员；2 团员；3 群众
	private Long politicalid;// 政治面貌 Long
	private String highesteducation;// 学历
	private String school;// 毕业院校
	private String major;// 专业
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date joineddate;// 入职时间 Date
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date contractdate;// 签合同时间 Date
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date positivedate;// 转正时间 Date
	private Integer nowworkingyears;// 司龄 Integer
	private String mobileno;// 联系电话
	private String insideno;// 内线座机
	private String outsideno;// 外线座机
	private String nativeplace;// 籍贯
	private String livingaddress;// 现居住地址
	private Integer contractperiod;// 劳动合同期限 Integer
	// 固定期限
	private Integer contracttype;// 合同形式 Integer
	// 0 不接收；1 接收
	private Integer profile;// 是否接收档案 Integer
	private String cardno;// 银行卡号
	private String bank;// 开户行
	private String subbank;// 支行
	private String verifier;// 档案审核人
	private String staffremark;// 备注
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	private Date updatedate;// 更新时间 Date

	private String departmentname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffno() {
		return staffno;
	}

	public void setStaffno(String staffno) {
		this.staffno = staffno;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getWorkingstate() {
		return workingstate;
	}

	public void setWorkingstate(Integer workingstate) {
		this.workingstate = workingstate;
	}

	public Long getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(Long departmentid) {
		this.departmentid = departmentid;
	}

	public Long getCompanysiteid() {
		return companysiteid;
	}

	public void setCompanysiteid(Long companysiteid) {
		this.companysiteid = companysiteid;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getIdcardno() {
		return idcardno;
	}

	public void setIdcardno(String idcardno) {
		this.idcardno = idcardno;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Long getHukouid() {
		return hukouid;
	}

	public void setHukouid(Long hukouid) {
		this.hukouid = hukouid;
	}

	public Integer getMarrystatus() {
		return marrystatus;
	}

	public void setMarrystatus(Integer marrystatus) {
		this.marrystatus = marrystatus;
	}

	public Long getPoliticalid() {
		return politicalid;
	}

	public void setPoliticalid(Long politicalid) {
		this.politicalid = politicalid;
	}

	public String getHighesteducation() {
		return highesteducation;
	}

	public void setHighesteducation(String highesteducation) {
		this.highesteducation = highesteducation;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Date getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(Date joineddate) {
		this.joineddate = joineddate;
	}

	public Date getContractdate() {
		return contractdate;
	}

	public void setContractdate(Date contractdate) {
		this.contractdate = contractdate;
	}

	public Date getPositivedate() {
		return positivedate;
	}

	public void setPositivedate(Date positivedate) {
		this.positivedate = positivedate;
	}

	public Integer getNowworkingyears() {
		return nowworkingyears;
	}

	public void setNowworkingyears(Integer nowworkingyears) {
		this.nowworkingyears = nowworkingyears;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getInsideno() {
		return insideno;
	}

	public void setInsideno(String insideno) {
		this.insideno = insideno;
	}

	public String getOutsideno() {
		return outsideno;
	}

	public void setOutsideno(String outsideno) {
		this.outsideno = outsideno;
	}

	public String getNativeplace() {
		return nativeplace;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getLivingaddress() {
		return livingaddress;
	}

	public void setLivingaddress(String livingaddress) {
		this.livingaddress = livingaddress;
	}

	public Integer getContractperiod() {
		return contractperiod;
	}

	public void setContractperiod(Integer contractperiod) {
		this.contractperiod = contractperiod;
	}

	public Integer getContracttype() {
		return contracttype;
	}

	public void setContracttype(Integer contracttype) {
		this.contracttype = contracttype;
	}

	public Integer getProfile() {
		return profile;
	}

	public void setProfile(Integer profile) {
		this.profile = profile;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getSubbank() {
		return subbank;
	}

	public void setSubbank(String subbank) {
		this.subbank = subbank;
	}

	public String getVerifier() {
		return verifier;
	}

	public void setVerifier(String verifier) {
		this.verifier = verifier;
	}

	public String getStaffremark() {
		return staffremark;
	}

	public void setStaffremark(String staffremark) {
		this.staffremark = staffremark;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public StaffModel() {
		// TODO Auto-generated constructor stub
		super();
	}

	public StaffModel(Long id, String staffno, String imgurl, String staffname, Integer workingstate, Long departmentid,
			Long companysiteid, String positionname, Integer sex, String idcardno, Date birthday, String nationality,
			Long hukouid, Integer marrystatus, Long politicalid, String highesteducation, String school,
			String major, Date joineddate, Date contractdate, Date positivedate, Integer nowworkingyears,
			String mobileno, String insideno, String outsideno, String nativeplace, String livingaddress,
			Integer contractperiod, Integer contracttype, Integer profile, String cardno, String bank, String subbank,
			String verifier, String staffremark, Date updatedate, String departmentname) {
		super();
		this.id = id;
		this.staffno = staffno;
		this.imgurl = imgurl;
		this.staffname = staffname;
		this.workingstate = workingstate;
		this.departmentid = departmentid;
		this.companysiteid = companysiteid;
		this.positionname = positionname;
		this.sex = sex;
		this.idcardno = idcardno;
		this.birthday = birthday;
		this.nationality = nationality;
		this.hukouid = hukouid;
		this.marrystatus = marrystatus;
		this.politicalid = politicalid;
		this.highesteducation = highesteducation;
		this.school = school;
		this.major = major;
		this.joineddate = joineddate;
		this.contractdate = contractdate;
		this.positivedate = positivedate;
		this.nowworkingyears = nowworkingyears;
		this.mobileno = mobileno;
		this.insideno = insideno;
		this.outsideno = outsideno;
		this.nativeplace = nativeplace;
		this.livingaddress = livingaddress;
		this.contractperiod = contractperiod;
		this.contracttype = contracttype;
		this.profile = profile;
		this.cardno = cardno;
		this.bank = bank;
		this.subbank = subbank;
		this.verifier = verifier;
		this.staffremark = staffremark;
		this.updatedate = updatedate;
		this.departmentname = departmentname;
	}
}
