package com.example.demo;

public interface RegistrationDAO {
    public Long persistStudent(Student student);
    public Student findById(Long id);
}
