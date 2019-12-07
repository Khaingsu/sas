package nus.edu.ca.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nus.edu.ca.demo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	

}
