package com.courseenrollment.model;

public class Student {
    private String studentName;
    private String email;
    private String phone;
    private String selectedCourse;
    
    public Student() {}
    

    public Student(String studentName, String email, String phone, String selectedCourse) {
        this.studentName = studentName;
        this.email = email;
        this.phone = phone;
        this.selectedCourse = selectedCourse;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getSelectedCourse() {
        return selectedCourse;
    }
    
    public void setSelectedCourse(String selectedCourse) {
        this.selectedCourse = selectedCourse;
    }
}