package edu.utvt.attendance.controller;


import java.util.List;

import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import edu.utvt.attendance.persistence.entities.Student;
import edu.utvt.attendance.persistence.service.StudentService;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/all")
	public List<Student> get() {
		return this.studentService.getAll();
	}
	
	@GetMapping
	public ResponseEntity <Page<Student>> getMethodName(@RequestParam(Value = "page",defaultValue = "0") Integer param, @RequestParam(value = "size")Integer size){
		return ResponseEntity.ok(this.studentService.get(page, size));
	}
	
	
	@GetMapping
	public String  getMethodName(@RequestParam(value = "page",defaultValue = "0") Integer param, @RequestParam(value = "size")Integer size){
		return new String();
	}
	
	
	@PostMapping
	public ResponseEntity<Student> save (@RequestBody Student student) {
		return ResponseEntity.created(null).body(this.studentService.save(student));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") String id, @RequestBody Student student) {
		return ResponseEntity.ok(this.studentService.update(id, student));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> delete(@PathVariable("id") String studentId) {
		return this.studentService.deleteById(studentId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> findById(@PathVariable("id") String Id) {
		return ResponseEntity.of(this.studentService.findBy(id));
	}	
}
