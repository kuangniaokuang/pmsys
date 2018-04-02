package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import cn.labsys.pmsys.entity.Staff;
import cn.labsys.pmsys.entity.StaffModel;

public interface StaffRepository extends JpaRepository<Staff, Long> {
	@Procedure(procedureName = "getStaff")
	List<Staff> getStaff();

	@Query("select NEW cn.labsys.pmsys.entity.StaffModel("
			+ "t1.id,t1.staffno,t1.imgurl,t1.staffname,t1.workingstate,t2.id as departmentid,t5.id as companysiteid,"
			+ "t1.positionname,t1.sex,t1.idcardno,t1.birthday,t1.nationality,t3.id as hukouid,t1.marrystatus,t4.id as politicalid,"
			+ "t1.highesteducation,t1.school,t1.major,t1.joineddate,t1.contractdate,t1.positivedate,t1.nowworkingyears,"
			+ "t1.mobileno,t1.insideno,t1.outsideno,t1.nativeplace,t1.livingaddress,t1.contractperiod,t1.contracttype,t1.profile,t1.cardno,t1.bank,"
			+ "t1.subbank,t1.verifier,t1.staffremark,t1.updatedate,t2.departmentname) from Staff t1 join t1.department t2 join t1.hukou t3 join t1.political t4 join t1.companysite t5")
	List<StaffModel> getStaffList();
	
	Staff findByStaffno(String staffno);
}
