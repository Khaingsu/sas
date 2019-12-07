package nus.edu.ca.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import nus.edu.ca.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
//	 @Modifying(clearAutomatically = true)
//	 @Transactional
//	    @Query("UPDATE Student s SET s.gpa = :gpa WHERE s.id = :sid")
//	    int updateGpa(@Param("sid") int id, @Param("gpa") double gpa);
//	 
	


}
