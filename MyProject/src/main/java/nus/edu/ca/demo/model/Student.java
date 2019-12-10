package nus.edu.ca.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	private String studentName;
	private String gender;
	@DateTimeFormat(iso=ISO.DATE)
	private Date DOB;
	private String degree;
	private int semester;
	private String address;
	private int mobile;
	private double gpa;
	
	@ManyToOne
	private Staff staffName;
	
@ManyToOne
private Course course;


//	@ManyToMany
//	@JoinTable(name="Student_Course", joinColumns=@JoinColumn(name="studentName_id"), inverseJoinColumns=@JoinColumn(name="courseName_id"))
//	private List<Course> courses;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Student(String studentName, String gender, Date dOB, String degree, int semester, String address, int mobile,
			double gpa, Staff staffName, Course course) {
		super();
		this.studentName = studentName;
		this.gender = gender;
		DOB = dOB;
		this.degree = degree;
		this.semester = semester;
		this.address = address;
		this.mobile = mobile;
		this.gpa = gpa;
		this.staffName = staffName;
		this.course = course;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public Staff getStaffName() {
		return staffName;
	}

	public void setStaffName(Staff staffName) {
		this.staffName = staffName;
	}

	
	

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", gender=" + gender + ", DOB=" + DOB + ", degree=" + degree
				+ ", semester=" + semester + ", address=" + address + ", mobile=" + mobile + ", gpa=" + gpa
				+ ", staffName=" + staffName + ", course=" + course + "]";
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(gpa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
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
		Student other = (Student) obj;
		if (Double.doubleToLongBits(gpa) != Double.doubleToLongBits(other.gpa))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

}
