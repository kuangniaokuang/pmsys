package cn.labsys.pmsys.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.labsys.pmsys.dao.RequirementRepository;
import cn.labsys.pmsys.entity.Companysite;
import cn.labsys.pmsys.entity.Department;
import cn.labsys.pmsys.entity.Requirement;
import cn.labsys.pmsys.entity.RequirementModel;

@RestController
@RequestMapping("/requirement")
public class RequirementController {

	@Autowired
	RequirementRepository requirementRepository;

	@RequestMapping("/save")
	public Requirement save(Long id, Integer addtype, String formdateStr, Long departmentid, Long companysiteid,
			String suggestsalary, String positionname, Integer addreason, String arrivaldateStr, Integer addcount,
			Integer sex, String education, String appearance, Integer marrystatus, String major, String others,
			Integer age, String trait, String experience, String duty, String proposer, String manager, String director,
			String chairman, String hr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date formdate = null;
		if (formdateStr != "") {
			formdate = (Date) format.parse(formdateStr);
		}
		Date arrivaldate = null;
		if (arrivaldateStr != "") {
			arrivaldate = (Date) format.parse(arrivaldateStr);
		}
		Department department = new Department();
		department.setId(departmentid);
		Companysite companysite = new Companysite();
		companysite.setId(companysiteid);
		Requirement newRequirement;
		if (id == 0) {
			id = null;
			newRequirement = new Requirement(id, addtype, formdate, department, companysite, suggestsalary,
					positionname, addreason, arrivaldate, addcount, sex, education, appearance, marrystatus, major,
					others, age, trait, experience, duty, proposer, manager, director, chairman, hr);
		} else {
			// update
			newRequirement = requirementRepository.findOne(id);
			newRequirement.setAddtype(addtype);
			newRequirement.setFormdate(formdate);
			newRequirement.setDepartment(department);
			newRequirement.setCompanysite(companysite);
			newRequirement.setSuggestsalary(suggestsalary);
			newRequirement.setPositionname(positionname);
			newRequirement.setAddreason(addreason);
			newRequirement.setArrivaldate(arrivaldate);
			newRequirement.setAddcount(addcount);
			newRequirement.setSex(sex);
			newRequirement.setEducation(education);
			newRequirement.setAppearance(appearance);
			newRequirement.setMarrystatus(marrystatus);
			newRequirement.setMajor(major);
			newRequirement.setOthers(others);
			newRequirement.setAge(age);
			newRequirement.setTrait(trait);
			newRequirement.setExperience(experience);
			newRequirement.setDuty(duty);
			newRequirement.setProposer(proposer);
			newRequirement.setManager(manager);
			newRequirement.setDirector(director);
			newRequirement.setChairman(chairman);
			newRequirement.setHr(hr);
		}
		Requirement requirement = requirementRepository.save(newRequirement);
		return requirement;
	}

	@RequestMapping("/r")
	public Requirement getById(Long id) {
		Requirement requirement = requirementRepository.findOne(id);
		return requirement;
	}

	@RequestMapping("/getlist")
	public List<RequirementModel> getAll() {
		List<RequirementModel> requirements = requirementRepository.getRequirementList();
		return requirements;
	}

	@RequestMapping("/search")
	public List<RequirementModel> findByDepartmentidAndPositionname(String positionname, Long departmentid) {
		List<RequirementModel> requirements = requirementRepository.findByDepartmentidAndPositionname(positionname,
				departmentid);
		return requirements;
	}
}
