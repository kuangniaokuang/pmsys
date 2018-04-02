package cn.labsys.pmsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.labsys.pmsys.dao.DepartmentRepository;
import cn.labsys.pmsys.entity.Department;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	/***
	 * 
	 * @param departmentno
	 * @param departmentname
	 * @param parentid
	 * @return
	 */
	@RequestMapping("/add")
	public Department save(String departmentname, Long parentid) {
		Integer rankno = (int) departmentRepository.count() + 1;
		Department department = departmentRepository.save(new Department(null, rankno, departmentname, parentid, 0));
		return department;
	}

	/***
	 * 
	 * @param name
	 * @param id
	 * @return
	 */
	@RequestMapping("/update")
	public int setName(String departmentname, Long id) {
		return departmentRepository.setName(departmentname, id);
	}

	@RequestMapping("/all")
	public List<Department> getAll() {
		List<Department> departments = departmentRepository.findByDeleteflag();
		return departments;
	}

	@RequestMapping("/delete")
	public Integer delete(Long id) {
		return departmentRepository.deleteById(id);
	}

	@RequestMapping("/exchange")
	@Transactional
	public Integer exchange(Long departmentid1, Long departmentid2) {
		int rank1 = departmentRepository.findRankno(departmentid1);
		int rank2 = departmentRepository.findRankno(departmentid2);
		departmentRepository.exchange(departmentid1, rank2);
		departmentRepository.exchange(departmentid2, rank1);
		return 1;
	}
}
