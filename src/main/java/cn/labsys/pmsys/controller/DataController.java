package cn.labsys.pmsys.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.labsys.pmsys.dao.CompanysiteRepository;
import cn.labsys.pmsys.dao.DepartmentRepository;
import cn.labsys.pmsys.dao.HukouRepository;
import cn.labsys.pmsys.dao.PoliticalRepository;
import cn.labsys.pmsys.entity.Companysite;
import cn.labsys.pmsys.entity.Department;
import cn.labsys.pmsys.entity.DepartmentTree;
import cn.labsys.pmsys.entity.Hukou;
import cn.labsys.pmsys.entity.Political;

@RestController
@RequestMapping("/master")
public class DataController {
	@Autowired
	HukouRepository hukouRepository;
	@Autowired
	CompanysiteRepository companysiteRepository;
	@Autowired
	PoliticalRepository politicalRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@RequestMapping("/all")
	public Map<String, Object> findMaster() {
		Map<String, Object> map = new HashedMap<String, Object>();
		List<Hukou> hukous = hukouRepository.findAll();
		map.put("hukous", hukous);
		List<Companysite> companysites = companysiteRepository.findAll();
		map.put("companysites", companysites);
		List<Political> politicals = politicalRepository.findAll();
		map.put("politicals", politicals);
		return map;
	}

	@RequestMapping("/hukous")
	public List<Hukou> findHukouAll() {
		List<Hukou> hukous = hukouRepository.findAll();
		return hukous;
	}

	@RequestMapping("/companysites")
	public List<Companysite> findCompanysiteAll() {
		List<Companysite> companysites = companysiteRepository.findAll();
		return companysites;
	}

	@RequestMapping("/politicals")
	public List<Political> findPoliticalAll() {
		List<Political> politicals = politicalRepository.findAll();
		return politicals;
	}

	@RequestMapping("/departments")
	public List<DepartmentTree> getTree() {
		List<Department> departments = departmentRepository.findByDeleteflag();
		return buildTree(departments);
	}

	public List<DepartmentTree> buildTree(List<Department> departments) {
		List<DepartmentTree> trees = new ArrayList<DepartmentTree>();
		for (Department department : departments) {

			if (department.getParentid() == 0) {
				DepartmentTree tree = new DepartmentTree();
				tree.setValue(department.getId());
				tree.setText(department.getDepartmentname());
				tree.setSelectable(false);
				build(tree, department, departments);
				trees.add(tree);
			}
		}
		return trees;
	}

	private void build(DepartmentTree tree, Department department, List<Department> departments) {
		List<Department> children = getChildren(department, departments);
		if (!children.isEmpty()) {
			List<DepartmentTree> childrenTrees = new ArrayList<DepartmentTree>();
			for (Department child : children) {
				DepartmentTree childTree = new DepartmentTree();
				childTree.setValue(child.getId());
				childTree.setText(child.getDepartmentname());
				childTree.setSelectable(false);
				childrenTrees.add(childTree);
				build(childTree, child, departments);
			}
			tree.setNodes(childrenTrees);
		}
	}

	private List<Department> getChildren(Department department, List<Department> departments) {
		List<Department> children = new ArrayList<Department>();
		Long id = department.getId();
		for (Department child : departments) {
			if (id.equals(child.getParentid())) {
				children.add(child);
			}
		}
		return children;
	}
}
