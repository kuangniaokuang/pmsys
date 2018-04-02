package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.labsys.pmsys.entity.Salary;
import cn.labsys.pmsys.entity.SalaryDepartmentModel;
import cn.labsys.pmsys.entity.SalaryModel;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
	@Query("select NEW cn.labsys.pmsys.entity.SalaryModel("
			+ "t1.id,t1.yearmonth,t2.staffno,t2.staffname,t3.id as departmentid,t3.departmentname,t1.basic,t1.performance,"
			+ "t1.seniority,t1.subsidies,t1.meal,t1.others,t1.absencedays,t1.deductions,t1.paytotal,t1.oldage,"
			+ "t1.unemployment,t1.medical,t1.housing,t1.tax,t1.deductiontotal,t1.takehome)"
			+ " from Salary t1 join t1.staff t2 join t2.department t3")
	List<SalaryModel> getSalaryList();

	@Query("select NEW cn.labsys.pmsys.entity.SalaryModel("
			+ "t1.id,t1.yearmonth,t2.staffno,t2.staffname,t3.id as departmentid,t3.departmentname,t1.basic,t1.performance,"
			+ "t1.seniority,t1.subsidies,t1.meal,t1.others,t1.absencedays,t1.deductions,t1.paytotal,t1.oldage,"
			+ "t1.unemployment,t1.medical,t1.housing,t1.tax,t1.deductiontotal,t1.takehome)"
			+ " from Salary t1 join t1.staff t2 join t2.department t3 where t1.yearmonth = ?1")
	List<SalaryModel> getSalaryListByYearmonth(String yearmonth);
	
	@Query("select NEW cn.labsys.pmsys.entity.SalaryDepartmentModel("
			+ "t1.yearmonth,t3.id as departmentid,t3.departmentname,sum(t1.basic),sum(t1.performance),"
			+ "sum(t1.seniority),sum(t1.subsidies),sum(t1.meal),sum(t1.others),sum(t1.absenceday),sum(t1.deductions),sum(t1.paytotal),sum(t1.oldage),"
			+ "sum(t1.unemployment),sum(t1.medical),sum(t1.housing),sum(t1.tax),sum(t1.deductiontotal),sum(t1.takehome))"
			+ " from Salary t1 join t1.staff t2 join t2.department t3 where t1.yearmonth = ?1 group by t1.yearmonth,t3.id,t3.departmentname")
	List<SalaryDepartmentModel> getSalaryDepartmentListByYearmonth(String yearmonth);

	@Query("select NEW cn.labsys.pmsys.entity.SalaryModel( t3.id,t3.yearmonth,t1.staffno,t1.staffname,t2.id as departmentid,t2.departmentname,t1.basic,t3.performance,"
			+ "t3.seniority,t3.subsidies,t3.meal,t3.others,t3.absencedays,t3.deductions,t3.paytotal,t3.oldage,"
			+ "t3.unemployment,t3.medical,t3.housing,t3.tax,t3.deductiontotal,t3.takehome)"
			+ " from Staff t1 join t1.department t2 left join t1.salaries t3 on t3.yearmonth=?1 where t2.id in ?2")
	List<SalaryModel> getStaffSalary(String yearmonth, Long[] departmentids);
	
}
