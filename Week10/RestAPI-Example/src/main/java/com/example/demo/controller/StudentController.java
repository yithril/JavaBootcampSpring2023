package com.example.demo.controller;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("api/student")
    public List<Student> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    @PostMapping("api/student")
    public Student createStudent(@RequestBody Student student){
        return this.studentService.createStudent(student);
    }
}
