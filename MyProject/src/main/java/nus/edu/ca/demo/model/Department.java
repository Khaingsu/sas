package nus.edu.ca.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(mappedBy = "departmentName")
	private List<Staff> staffs;

	@OneToMany(mappedBy = "departmentName")
	private List<Course> courses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Department(String name, List<Staff> staffs, List<Course> courses) {
		super();
		this.name = name;
		this.staffs = staffs;
		this.courses = courses;
	}

	public Department(List<Staff> staffs, List<Course> courses) {
		super();
		this.staffs = staffs;
		this.courses = courses;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", staffs=" + staffs + ", courses=" + courses + "]";
	}

	

}
