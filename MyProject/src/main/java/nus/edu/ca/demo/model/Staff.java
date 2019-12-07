package nus.edu.ca.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int role;

	@ManyToOne
	private Department departmentName;

	@OneToMany(mappedBy = "staffName")
	private List<Student> students;

	@OneToMany(mappedBy = "staffName")
	private List<Course> courses;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int role, Department departmentName, List<Student> students, List<Course> courses) {
		super();
		this.role = role;
		this.departmentName = departmentName;
		this.students = students;
		this.courses = courses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Staff(String name, int role, Department departmentName, List<Student> students, List<Course> courses) {
		super();
		this.name = name;
		this.role = role;
		this.departmentName = departmentName;
		this.students = students;
		this.courses = courses;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Department getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(Department departmentName) {
		this.departmentName = departmentName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", role=" + role + ", departmentName=" + departmentName + ", students=" + students
				+ ", courses=" + courses + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + role;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (id != other.id)
			return false;
		if (role != other.role)
			return false;
		return true;
	}


}
