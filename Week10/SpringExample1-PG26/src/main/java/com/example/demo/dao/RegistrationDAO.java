package com.example.demo.dao;

import com.example.demo.models.Student;

public interface RegistrationDAO {
    public Long persistStudent(Student student);
    public Student findById(Long id);
}
