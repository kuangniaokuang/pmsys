package cn.labsys.pmsys.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.labsys.pmsys.common.SalaryTool;
import cn.labsys.pmsys.dao.SalaryRepository;
import cn.labsys.pmsys.dao.StaffRepository;
import cn.labsys.pmsys.entity.Salary;
import cn.labsys.pmsys.entity.SalaryDepartmentModel;
import cn.labsys.pmsys.entity.SalaryModel;
import cn.labsys.pmsys.entity.Staff;

@RestController
@RequestMapping("/salary")
public class SalaryController {
	private SalaryTool salaryTool = new SalaryTool();
	@Autowired
	SalaryRepository salaryRepository;
	@Autowired
	StaffRepository staffRepository;

	@RequestMapping("/getsalarylist")
	public List<SalaryModel> getSalaryList() {
		List<SalaryModel> salaryList = salaryRepository.getSalaryList();
		return salaryList;
	}

	@RequestMapping("/getsalarylistbyyearmonth")
	public List<SalaryModel> getSalaryList(String yearmonth) {
		List<SalaryModel> salaryList = salaryRepository.getSalaryListByYearmonth(yearmonth);
		return salaryList;
	}

	@RequestMapping("/getsalarydepartmentlistbyyearmonth")
	public List<SalaryDepartmentModel> getSalaryDepartmentList(String yearmonth) {
		List<SalaryDepartmentModel> salaryList = salaryRepository.getSalaryDepartmentListByYearmonth(yearmonth);
		return salaryList;
	}

	@RequestMapping("/getstaffsalary")
	public List<SalaryModel> getStaffSalary(Long[] departmentids, String yearmonth) {
		List<SalaryModel> salaryList = salaryRepository.getStaffSalary(yearmonth, departmentids);
		return salaryList;
	}

	@RequestMapping("/save")
	public Integer save(String salarymodels) throws JsonParseException, JsonMappingException, IOException {
		List<Salary> salaries = new ArrayList<Salary>();
		ObjectMapper mapper = new ObjectMapper();
		List<SalaryModel> objects = mapper.readValue(salarymodels, new TypeReference<List<SalaryModel>>() {
		});
		for (SalaryModel salaryModel : objects) {
			Staff staff = staffRepository.findByStaffno(salaryModel.getStaffno());
			Long id = salaryModel.getId();
			String yearmonth = salaryModel.getYearmonth();
			// 从员工表获得基本工资
			BigDecimal basic = staff.getBasic();
			BigDecimal performance = salaryModel.getPerformance();
			// 工龄工资，一年以上才有
			BigDecimal seniority = salaryModel.getSeniority();
			// 其他补贴
			BigDecimal subsidies = salaryModel.getSubsidies();
			BigDecimal meal = salaryModel.getMeal();
			// 其他加项
			BigDecimal others = salaryModel.getOthers();
			// 月工资总额=基本工资+绩效工资+工龄工资+补助(现在只有餐补）
			BigDecimal monthtotal = new BigDecimal("0");
			if (basic != null) {
				monthtotal = monthtotal.add(basic);
			}
			if (performance != null) {
				monthtotal = monthtotal.add(performance);
			}
			if (seniority != null) {
				monthtotal = monthtotal.add(seniority);
			}
			if (meal != null) {
				monthtotal = monthtotal.add(meal);
			}
			Integer absencedays = salaryModel.getAbsencedays();
			// 总工资/21.75*缺勤天数
			BigDecimal absenceday = null;
			absenceday = monthtotal.divide(new BigDecimal("21.75"), 2, RoundingMode.HALF_UP)
					.multiply(new BigDecimal(absencedays == null ? 0 : absencedays));
			// 其他扣项
			BigDecimal deductions = salaryModel.getDeductions();
			// 应发合计=基本工资+绩效工资+工龄工资+其他补贴+餐补+其他加项-缺勤-其他扣项
			// 应发合计=月工资总额+其他补贴+其他家乡-缺勤-其他扣项
			BigDecimal paytotal = new BigDecimal("0");
			paytotal = paytotal.add(monthtotal);
			if (subsidies != null) {
				paytotal = paytotal.add(subsidies);
			}
			if (others != null) {
				paytotal = paytotal.add(others);
			}
			if (absenceday != null) {
				paytotal = paytotal.subtract(absenceday);
			}
			if (deductions != null) {
				paytotal = paytotal.subtract(deductions);
			}
			// 0.08
			BigDecimal oldage = paytotal.multiply(new BigDecimal("0.08"));
			// 0.003 城镇有，农村没有
			BigDecimal unemployment = paytotal.multiply(new BigDecimal("0.003"));
			// 0.02
			BigDecimal medical = paytotal.multiply(new BigDecimal("0.02"));

			BigDecimal housing = salaryModel.getHousing();
			// 按照应发合计来算 paytotal
			BigDecimal tax = new BigDecimal(salaryTool.taxCalculation(paytotal.doubleValue()));
			// 扣除合计=养老+失业+医疗+公积金
			BigDecimal deductiontotal = new BigDecimal("0");
			if (oldage != null) {
				deductiontotal = deductiontotal.add(oldage);
			}
			if (unemployment != null) {
				deductiontotal = deductiontotal.add(unemployment);
			}
			if (medical != null) {
				deductiontotal = deductiontotal.add(medical);
			}
			if (housing != null) {
				deductiontotal = deductiontotal.add(housing);
			}
			// 实发工资=应发工资-扣除合计
			BigDecimal takehome = paytotal.subtract(deductiontotal);

			Salary salary = null;
			if (id == null) {
				salary = new Salary(id, yearmonth, staff, basic, performance, seniority, subsidies, meal, others,
						absenceday, absencedays, deductions, paytotal, oldage, unemployment, medical, housing, tax,
						deductiontotal, takehome);
			} else {
				salary = salaryRepository.findOne(salaryModel.getId());
				salary.setBasic(basic);
				salary.setPerformance(performance);
				salary.setSeniority(seniority);
				salary.setSubsidies(subsidies);
				salary.setMeal(meal);
				salary.setOthers(others);
				salary.setAbsencedays(absencedays);
				salary.setAbsenceday(absenceday);
				salary.setDeductions(deductions);
				salary.setPaytotal(paytotal);
				salary.setOldage(oldage);
				salary.setUnemployment(unemployment);
				salary.setMedical(medical);
				salary.setHousing(housing);
				salary.setTax(tax);
				salary.setDeductiontotal(deductiontotal);
				salary.setTakehome(takehome);

			}
			salaries.add(salary);
		}
		Integer count = salaryRepository.save(salaries).size();
		return count;
	}
}
