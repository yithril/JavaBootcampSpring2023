package com.example.hotelexercise;

public class Employee {
    //variables
    private String employeeId;
    private String name;
    private String department;
    private float hoursWorked;
    private float payRate;

    public Employee(String employeeId, String name, String department, float hoursWorked, float payRate){
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    //65
    //How much of that is regular time?
    //How much of that is overtime?

    public float getOvertimeHours(){
        if(this.hoursWorked > 40){
            return this.hoursWorked - 40;
        }
        else{
            return 0;
        }
    }

    public float getRegularHours(){
        if(this.hoursWorked > 40){
            return 40;
        }
        else{
            return this.hoursWorked;
        }
    }

    public double getTotalPay(){
       //Multiply the regular hours by pay rate
        //If there is overtime multiply by pay rate 25%
        float regularHoursPay = getRegularHours() * payRate;
        float overTimePay = getOvertimeHours() * payRate * 1.25f;

        return regularHoursPay + overTimePay;
    }

    public String getEmployeeId(){
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId){
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

    public float getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(float hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public float getPayRate() {
        return payRate;
    }

    public void setPayRate(float payRate) {
        this.payRate = payRate;
    }
}
