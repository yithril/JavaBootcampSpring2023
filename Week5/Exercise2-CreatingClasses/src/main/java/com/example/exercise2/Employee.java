package com.example.exercise2;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private float payRate;
    private float hoursWorked;
    private LocalDateTime checkedInDateTime;
    private boolean isCheckedIn;

    public Employee(int employeeId, String name, String department, float payRate, float hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchIn(LocalDateTime time){
        this.checkedInDateTime = time;
        this.isCheckedIn = true;
    }

    public void punchOut(LocalDateTime checkoutTime){
        this.isCheckedIn = false;
        this.hoursWorked = Duration.between(this.checkedInDateTime, checkoutTime).toHours();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}