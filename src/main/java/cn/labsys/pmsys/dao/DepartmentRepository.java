package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.labsys.pmsys.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	@Modifying
	@Query("update Department d set d.departmentname=?1 where d.id=?2")
	@Transactional
	int setName(String departmentname, Long id);

	@Modifying
	@Query("update Department d set d.deleteflag=1 where d.id=?1")
	@Transactional
	int deleteById(Long id);

	@Query("select d from Department d where d.deleteflag=0 order by d.parentid,d.rankno")
	List<Department> findByDeleteflag();

	@Query("select d.rankno from Department d where d.id=?1")
	int findRankno(Long id);

	@Modifying
	@Query("update Department d set d.rankno=?2 where d.id=?1")
	@Transactional
	int exchange(Long id, Integer rankno);
}
