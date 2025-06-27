package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentManager studentManager;

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentManager.getAllStudents();
    }

    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentManager.getStudentById(id);
    }

    // POST add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentManager.addStudent(student);
    }

    // PUT update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentManager.updateStudent(id, student);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean deleted = studentManager.deleteStudent(id);
        return deleted ? "Student deleted" : "Student not found";
    }
}
