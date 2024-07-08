package com.peter.StudentApi.student;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public ResponseEntity<Object> newStudent(Student student) {
        studentRepository.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Object> updateStudent(Long id, Student updatedStudent) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.valueOf(id))
        );

        if (updatedStudent.getFullName() != null) {
            existingStudent.setFullName(updatedStudent.getFullName());
        }

        if (updatedStudent.getDob() != null) {
            existingStudent.setDob(updatedStudent.getDob());
        }

        if (updatedStudent.getGender() != null) {
            existingStudent.setGender(updatedStudent.getGender());
        }

        if (updatedStudent.getAddress() != null) {
            existingStudent.setAddress(updatedStudent.getAddress());
        }

        if (updatedStudent.getAddress() != null) {
            existingStudent.setPhoneNumber(updatedStudent.getPhoneNumber());
        }

        if (updatedStudent.getEmail() != null) {
            existingStudent.setEmail(updatedStudent.getEmail());
        }

        studentRepository.save(existingStudent);
        return new ResponseEntity<>(existingStudent, HttpStatus.OK);
    }

    public ResponseEntity<Object> removeStudent(Long id){
        if(id==null){
            throw new IllegalArgumentException("ID cannot be null");
        }

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Deleted student with id: "+id, HttpStatus.OK);
    }
}
