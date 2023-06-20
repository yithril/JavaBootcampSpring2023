package com.example.demo.services;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    public Student createStudent(Student student){
        return this.studentRepository.save(student);
    }
}
