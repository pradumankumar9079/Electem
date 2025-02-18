	package com.electems.Student.Controller;
	
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electems.Student.Model.Teacher;
import com.electems.Student.Service.TeacherService;
	
	@RestController
	@RequestMapping("/teacher")
	public class TeacherController {
		@Autowired
		private TeacherService teacherService;
		
		 @PostMapping("/createTeacher")
		    public ResponseEntity<Teacher> createStudent(@RequestBody Teacher teacher) {
		        Teacher createdTeacher = teacherService.saveTeacher(teacher);
		        return ResponseEntity.status(HttpStatus.CREATED).body(createdTeacher);
		    }
		 
		 
		 @GetMapping
		    public List<Teacher> getAllTeachers() {
		        return teacherService.getAllTeachers();
		    }
		 @GetMapping("/id")
		    public ResponseEntity<Teacher> getTeacherById(@RequestParam Long id) {
		        Optional<Teacher> teacher = teacherService.getTeacherById(id);
		        if (teacher.isPresent()) {
		            return ResponseEntity.ok(teacher.get());
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }
		 
		 @PutMapping("/updateTeacher")
		    public ResponseEntity<Teacher> updateTeacher(@RequestParam Long id, @RequestBody Teacher teacherDetails) {
		        return teacherService.updateTeacher(id, teacherDetails);
		    }
		 
	}
