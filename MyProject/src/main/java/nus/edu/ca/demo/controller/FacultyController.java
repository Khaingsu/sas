package nus.edu.ca.demo.controller;

import java.util.ArrayList;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nus.edu.ca.demo.model.Course;
import nus.edu.ca.demo.model.Student;
import nus.edu.ca.demo.repo.CourseRepository;
import nus.edu.ca.demo.repo.StudentRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	@Autowired
	private StudentRepository sturepo;
	@Autowired
	private CourseRepository courserepo;

//	@ModelAttribute("types")
//	public Collection<Course> showTypes(){
//		return courserepo.findAll();
//		
//	}

	@GetMapping("/listStudent")
	public String showStudents(Model model) {
		ArrayList<Student> slist = new ArrayList<Student>();
		// ArrayList<Course> clist=new ArrayList<Course>();
		// clist.addAll(courserepo.findAll());
		// Course c=new Course();
		slist.addAll(sturepo.findAll());
		// courserepo.save(c);
		model.addAttribute("students", slist);
		return "students";

	}

	@GetMapping("/createStudent")
	public String createStudent(Model model) {
		Student student = new Student();
		ArrayList<Course> clist = new ArrayList<Course>();
		clist.addAll(courserepo.findAll());
		model.addAttribute("student", student);
		model.addAttribute("courses", clist);

		return "studentform";

	}

	@GetMapping("/saveStudent")
	public String saveStudent(@ModelAttribute Student student, @ModelAttribute("course") Course course) {
		System.out.println("--course--" + course);
		System.out.println("--course--" + student);

		sturepo.save(student);
		courserepo.save(course);
		// System.out.println("Course name is"+courserepo.findAll().toString());
		return "forward:/faculty/listStudent";
	}

	@GetMapping("/editStudent/{id}")
	public String editStudent(Model model, @PathVariable("id") Integer id) {
		Student student = sturepo.findById(id).get();
		sturepo.delete(student);
		model.addAttribute("student", student);
		return "studentform";

	}

	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(Model model, @PathVariable("id") Integer id) {
		Student student = sturepo.findById(id).get();

		sturepo.delete(student);
		return "forward:/faculty/listStudent";
	}

	@GetMapping("/score")
	public String scoreCard(Model model) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.addAll(sturepo.findAll());

		model.addAttribute("students", students);
		return "scorecard";

	}

	@GetMapping("/edit/{id}")
	public String editScore(Model model, @PathVariable("id") Integer id) {
		Student student = sturepo.findById(id).get();

		model.addAttribute("student", student);
		return "editform";

	}

	@GetMapping("/saveEdit")
	public String saveEdit(@ModelAttribute Student student) {

		// sturepo.updateGpa(student.getId(), student.getGpa());
		sturepo.delete(student);
		sturepo.save(student);
		return "forward:/faculty/listStudent";
	}

}
