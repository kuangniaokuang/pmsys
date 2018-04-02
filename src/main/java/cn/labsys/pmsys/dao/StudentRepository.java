package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.labsys.pmsys.entity.Student;
import cn.labsys.pmsys.entity.StudentResult;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(nativeQuery = true, value = "select t1.id,t1.studentname,t2.gradename from student t1 inner join grade t2 on t1.gradeid=t2.id")
	List<StudentResult> getStudentResults();

	@Query(nativeQuery = true, value = "select t1.id,t1.studentname,t2.gradename from student t1 inner join grade t2 on t1.gradeid=t2.id")
	List<Object> getObjectResults();

	// @Query("select t1.id,t1.studentname,t2.gradename from Student t1 inner join
	// Grade t2 on t1.gradeid=t2.id ")
	@Query("select new cn.labsys.pmsys.entity.StudentResult(t1.id,t1.studentname,t2.gradename) from Student t1 join t1.grade t2")
//	@Query("select t1.id,t1.studentname,t2.gradename from Student t1 join t1.grade t2")
	List<StudentResult> getStuResults();
}
