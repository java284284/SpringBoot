package com.ispan.springbootdemo.controller;
//package com.ipsan.springbootdemo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ipsan.springbootdemo.model.Customer;
//import com.ipsan.springbootdemo.model.Student;
//import com.ipsan.springbootdemo.model.StudentRepository;
//
//@RestController
//public class StudentApi {
//	
//	@Autowired
//	private StudentRepository dao;
//	
//	@PostMapping("student/insert")
//	public Student insert() {
//		Student stu1 = new Student();
//		stu1.setName("小張");
//		stu1.setNumber(5);
//		Student responStudent = dao.save(stu1);
//		return responStudent;
//	}
//	@PostMapping("student/insert2")
//	public Student insert2(@RequestBody Student stu) {
//		Student responStudent = dao.save(stu);
//		return responStudent;
//	}
//	
////	@PostMapping("customer/insert3")
////	public List<Student> insert3(@RequestBody List<Student> stu) {
////		return dao.saveAll(stu);
////	}
//	
//
//}
