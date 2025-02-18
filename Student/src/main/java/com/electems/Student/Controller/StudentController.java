package com.electems.Student.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.electems.Student.Model.Student;
import com.electems.Student.Service.StudentService;
/*
 * @RestController annotation is used to create the RestFull controller
 * @RestController is the combination of @Controller and @ResponceBody which makes easy to create RestFull API's 
 * By serializing the return ype of controller methods to xml or json formte
 */
@RestController

/*
 * @Requestmapping is used to map the HTTP request to the methods and it can be use as class level, method level annotation
 * to define the url pattern of API's
 */
@RequestMapping("/api/students")
public class StudentController {
    
    /*
     * Loggers are used to capture and record information about an application's behavior,
     *  which helps in debugging, monitoring, and maintaining the system. 
     */
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    
    /*
     * @AutoWired annotation is used for dependency injection,when we annotte a field with @Autowired it allows spring boot to 
     * inject required depenndency automatically by scalnning the aplication ontext for matching bean
     */
    @Autowired
    private StudentService studentService;

    /*
     * @Getmapping,@Putmapping,@Deletemapping,@PostMapping are the HTTP methods to map the 
     *corresponding requests like getRequest,Deleterequest etc.
     */
    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getAllStudents")
    public String getAllStudents() {
//        logger.info("Request to get all students");
//        List<Student> students = studentService.getAllStudents();
//        logger.info("Retrieved {} students", students.size());
        return "Heloo  iugyfy";
    }
    
    @GetMapping("/getList")
    public List<String> getList(){
    	List<String> l =new ArrayList<String> ();
    	l.add("Praduman");
    	l.add("Kumar");
    	return l;
    }

    @GetMapping("/getStudentById")
    public Long getStudentById(@RequestParam(value="idyggg") Long id) {
//        logger.info("Request to get student by id: {}", id);
//        
//        
//        Optional<Student> student = studentService.getStudentById(id);
//        if (student.isPresent()) {
//            logger.info("Student found: {}", student.get());
//            return ResponseEntity.ok(student.get());
//        } else {
//            logger.warn("Student not found with id: {}", id);
//            return ResponseEntity.notFound().build();
//        }
    	
    	return id;
    }

    @PostMapping("/createStudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        logger.info("Request to create student: {}", student);
        Student createdStudent = studentService.saveStudent(student);
        logger.info("Created student: {}", createdStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/updateStudentById/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        logger.info("Request to update student with id: {}", id);
        if (!studentService.getStudentById(id).isPresent()) {
            logger.warn("Student not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
        student.setId(id);
        Student updatedStudent = studentService.saveStudent(student);
        logger.info("Updated student: {}", updatedStudent);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deleteStudentById/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        logger.info("Request to delete student with id: {}", id);
        if (!studentService.getStudentById(id).isPresent()) {
            logger.warn("Student not found with id: {}", id);
            return ResponseEntity.notFound().build();
        }
        studentService.deleteStudent(id);
        logger.info("Deleted student with id: {}", id);
        return ResponseEntity.noContent().build();
    }
}
