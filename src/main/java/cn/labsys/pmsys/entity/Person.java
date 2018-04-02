package cn.labsys.pmsys.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Person.withStaffNameAndAddressNamedQuery", query = "select p from Person p where p.staffName=?1 and address=?2")
public class Person {
	@Id
	@GeneratedValue
	private Long id;

	private String staffName;
	private Integer age;
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Person() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Person(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.staffName = name;
		this.age = age;
		this.address = address;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
}
