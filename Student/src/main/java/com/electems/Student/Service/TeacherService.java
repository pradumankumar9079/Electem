package com.electems.Student.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.electems.Student.Model.Teacher;
import com.electems.Student.Repository.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Transactional
	public Teacher saveTeacher(Teacher teacher) {
		Teacher savedTeacher = teacherRepository.save(teacher);
		return savedTeacher;
	}

	public List<Teacher> getAllTeachers() {
		return teacherRepository.findAll();
	}

	public Optional<Teacher> getTeacherById(Long id) {
		return teacherRepository.findById(id);
	}

	public ResponseEntity<Teacher> updateTeacher(Long id, Teacher teacherDetails) {
		Optional<Teacher> existingTeacherOpt = teacherRepository.findById(id);

		if (existingTeacherOpt.isPresent()) {
			Teacher existingTeacher = existingTeacherOpt.get();

			existingTeacher.setName(teacherDetails.getName());
			existingTeacher.setEmail(teacherDetails.getEmail());

			Teacher updatedTeacher = teacherRepository.save(existingTeacher);

			return ResponseEntity.ok(updatedTeacher);
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
