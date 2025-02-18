package com.electems.Student.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import com.electems.Student.Model.Student;
import com.electems.Student.Repository.StudentRepository;

import jakarta.transaction.Transactional;

//to indicate the class as service class to write Bussiness logic
@Service 
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> getAllStudents() {
        logger.info("Fetching all students from the database");
        List<Student> students = studentRepository.findAll();
        logger.info("Number of students retrieved: {}", students.size());
        return students;
    }
    /*
     * @Cacheable annotation is used Reduce the interaction with database for regular data acces
     * if this method is calledc ,fcircstc spring will check cache for matching data ,if the data is excist in cache the it will the 
     * data from cache ,if data is not exist in cache the it will go for database call
     */
    @Cacheable(value = "student", key = "#id")
    public Optional<Student> getStudentById(Long id) {
        logger.info("Fetching student by id: {}", id);
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            logger.info("Student found: {}", student.get());
        } else {
            logger.warn("Student not found with id: {}", id);
        }
        return student;
    }

    /*
     * @Transactional annotation is used to manage the database transaction
     * if any exception occurs i n the specified method the the transaction is roll backed which already occurs in that metthod
     */
    @Transactional
    public Student saveStudent(Student student) {
        logger.info("Saving student: {}", student);
        Student savedStudent = studentRepository.save(student);
        logger.info("Student saved: {}", savedStudent);
        return savedStudent;
    }
    
    /*
     * @Retryable annotationis used to retry the method 
     */
    @Retryable
    public void deleteStudent(Long id) {
        logger.info("Attempting to delete student with id: {}", id);
        try {
            studentRepository.deleteById(id);
            logger.info("Successfully deleted student with id: {}", id);
        } catch (Exception e) {
            logger.error("Failed to delete student with id: {} due to: {}", id, e.getMessage());
            throw e; // Re-throw the exception to ensure retry logic is executed
        }
    }
}
