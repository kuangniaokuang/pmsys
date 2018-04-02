package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.labsys.pmsys.entity.Requirement;
import cn.labsys.pmsys.entity.RequirementModel;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
	@Query("select NEW cn.labsys.pmsys.entity.RequirementModel("
			+ "t1.id,t1.addtype,t1.formdate,t2.id as departmentid,t2.departmentname,t3.id as companysiteid,t3.companysitename,"
			+ "t1.suggestsalary,t1.positionname,t1.addreason,t1.arrivaldate,t1.addcount,t1.sex,t1.education,t1.appearance,"
			+ "t1.marrystatus,t1.major,t1.others,t1.age,t1.trait,t1.experience,t1.duty,"
			+ "t1.proposer,t1.manager,t1.director,t1.chairman,t1.hr) from Requirement t1 join t1.department t2 join t1.companysite t3")
	List<RequirementModel> getRequirementList();

	@Query("select NEW cn.labsys.pmsys.entity.RequirementModel("
			+ "t1.id,t1.addtype,t1.formdate,t2.id as departmentid,t2.departmentname,t3.id as companysiteid,t3.companysitename,"
			+ "t1.suggestsalary,t1.positionname,t1.addreason,t1.arrivaldate,t1.addcount,t1.sex,t1.education,t1.appearance,"
			+ "t1.marrystatus,t1.major,t1.others,t1.age,t1.trait,t1.experience,t1.duty,"
			+ "t1.proposer,t1.manager,t1.director,t1.chairman,t1.hr) from Requirement t1 join t1.department t2 join t1.companysite t3 "
			+ "where t1.positionname=?1 and t2.id=?2")
	List<RequirementModel> findByDepartmentidAndPositionname(String positionname, Long departmentid);
}
