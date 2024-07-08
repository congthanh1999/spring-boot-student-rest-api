package com.peter.StudentApi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        return studentService.newStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable("id") Long id) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") Long id){
        return studentService.removeStudent(id);
    }
}
