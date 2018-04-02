package cn.labsys.pmsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.labsys.pmsys.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	// 1
	List<Person> findByAddress(String address);

	// 2
	Person findByStaffNameAndAddress(String name, String address);

	// 3
	@Query("select p from Person p where p.staffName=:name and p.address=:address")
	Person withStaffNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

	// 4
	Person withStaffNameAndAddressNamedQuery(String name, String address);
}
