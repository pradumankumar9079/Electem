package com.electems.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electems.Student.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // JpaRepository provides methods like save, findById, findAll, deleteById, etc., for the Student entity
    // Additional custom query methods can be defined here if we needed
	
	
}
