package com.example.service;

import java.util.*;

import com.example.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentManager {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private Long currentId = 1L;

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getStudentById(Long id) {
        return studentMap.get(id);
    }

    public Student addStudent(Student student) {
        student.setId(currentId++);
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentMap.containsKey(id)) {
            updatedStudent.setId(id);
            studentMap.put(id, updatedStudent);
            return updatedStudent;
        }
        return null;
    }

    public boolean deleteStudent(Long id) {
        return studentMap.remove(id) !=null;
}
}