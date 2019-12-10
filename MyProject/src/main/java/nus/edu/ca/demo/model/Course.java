package nus.edu.ca.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String courseName;
	private Date startDate;
	private Date endDate;

//	@ManyToMany(mappedBy = "courses")
//	private List<Student> students;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
	private List<Student> students;
	@ManyToOne
	private Staff staffName;

	@ManyToOne
	private Department departmentName;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Course(String courseName, Date startDate, Date endDate, List<Student> students, Staff staffName,
			Department departmentName) {
		super();
		this.courseName = courseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.students = students;
		this.staffName = staffName;
		this.departmentName = departmentName;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Staff getStaffName() {
		return staffName;
	}

	public void setStaffName(Staff staffName) {
		this.staffName = staffName;
	}

	public Department getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(Department departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + courseName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", students=" + students + ", staffName=" + staffName + ", departmentName=" + departmentName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Course other = (Course) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

}
