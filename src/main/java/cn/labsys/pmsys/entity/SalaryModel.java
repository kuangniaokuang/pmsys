package cn.labsys.pmsys.entity;

import java.math.BigDecimal;

public class SalaryModel {
	private Long id;
	private String yearmonth;
	private String staffno;
	private String staffname;
	private Long departmentid;
	private String departmentname;
	private BigDecimal basic;
	private BigDecimal performance;
	private BigDecimal seniority;
	private BigDecimal subsidies;
	private BigDecimal meal;
	private BigDecimal others;
	private Integer absencedays;
	private BigDecimal deductions;
	private BigDecimal paytotal;
	private BigDecimal oldage;
	private BigDecimal unemployment;
	private BigDecimal medical;
	private BigDecimal housing;
	private BigDecimal tax;
	private BigDecimal deductiontotal;
	private BigDecimal takehome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYearmonth() {
		return yearmonth;
	}

	public void setYearmonth(String yearmonth) {
		this.yearmonth = yearmonth;
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

	public BigDecimal getBasic() {
		return basic;
	}

	public void setBasic(BigDecimal basic) {
		this.basic = basic;
	}

	public BigDecimal getPerformance() {
		return performance;
	}

	public void setPerformance(BigDecimal performance) {
		this.performance = performance;
	}

	public BigDecimal getSeniority() {
		return seniority;
	}

	public void setSeniority(BigDecimal seniority) {
		this.seniority = seniority;
	}

	public BigDecimal getSubsidies() {
		return subsidies;
	}

	public void setSubsidies(BigDecimal subsidies) {
		this.subsidies = subsidies;
	}

	public BigDecimal getMeal() {
		return meal;
	}

	public void setMeal(BigDecimal meal) {
		this.meal = meal;
	}

	public BigDecimal getOthers() {
		return others;
	}

	public void setOthers(BigDecimal others) {
		this.others = others;
	}

	public Integer getAbsencedays() {
		return absencedays;
	}

	public void setAbsencedays(Integer absencedays) {
		this.absencedays = absencedays;
	}

	public BigDecimal getDeductions() {
		return deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public BigDecimal getPaytotal() {
		return paytotal;
	}

	public void setPaytotal(BigDecimal paytotal) {
		this.paytotal = paytotal;
	}

	public BigDecimal getOldage() {
		return oldage;
	}

	public void setOldage(BigDecimal oldage) {
		this.oldage = oldage;
	}

	public BigDecimal getUnemployment() {
		return unemployment;
	}

	public void setUnemployment(BigDecimal unemployment) {
		this.unemployment = unemployment;
	}

	public BigDecimal getMedical() {
		return medical;
	}

	public void setMedical(BigDecimal medical) {
		this.medical = medical;
	}

	public BigDecimal getHousing() {
		return housing;
	}

	public void setHousing(BigDecimal housing) {
		this.housing = housing;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getDeductiontotal() {
		return deductiontotal;
	}

	public void setDeductiontotal(BigDecimal deductiontotal) {
		this.deductiontotal = deductiontotal;
	}

	public BigDecimal getTakehome() {
		return takehome;
	}

	public void setTakehome(BigDecimal takehome) {
		this.takehome = takehome;
	}

	public SalaryModel() {
		super();
	}

	public SalaryModel(Long id, String yearmonth, String staffno, String staffname, Long departmentid,
			String departmentname, BigDecimal basic, BigDecimal performance, BigDecimal seniority, BigDecimal subsidies,
			BigDecimal meal, BigDecimal others, Integer absencedays, BigDecimal deductions, BigDecimal paytotal,
			BigDecimal oldage, BigDecimal unemployment, BigDecimal medical, BigDecimal housing, BigDecimal tax,
			BigDecimal deductiontotal, BigDecimal takehome) {
		super();
		this.id = id;
		this.yearmonth = yearmonth;
		this.staffno = staffno;
		this.staffname = staffname;
		this.departmentid = departmentid;
		this.departmentname = departmentname;
		this.basic = basic;
		this.performance = performance;
		this.seniority = seniority;
		this.subsidies = subsidies;
		this.meal = meal;
		this.others = others;
		this.absencedays = absencedays;
		this.deductions = deductions;
		this.paytotal = paytotal;
		this.oldage = oldage;
		this.unemployment = unemployment;
		this.medical = medical;
		this.housing = housing;
		this.tax = tax;
		this.deductiontotal = deductiontotal;
		this.takehome = takehome;
	}
}
