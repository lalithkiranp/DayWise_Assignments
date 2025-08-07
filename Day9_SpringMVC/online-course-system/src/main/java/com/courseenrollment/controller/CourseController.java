package com.courseenrollment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.courseenrollment.model.Course;
import com.courseenrollment.model.Student;

@Controller
public class CourseController {
    
    private List<Course> getCourseList() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "Java Programming", "Prof. Smith", "3 months", 15000.0));
        courses.add(new Course("CS102", "Spring Framework", "Prof. Johnson", "2 months", 12000.0));
        courses.add(new Course("CS103", "Web Development", "Prof. Williams", "4 months", 18000.0));
        courses.add(new Course("CS104", "Database Management", "Prof. Brown", "2 months", 10000.0));
        return courses;
    }
    

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courseList = getCourseList();
        model.addAttribute("courses", courseList);
        return "courses";
    }
    
    @GetMapping("/enroll")
    public String showEnrollmentForm(@RequestParam("courseId") String courseId, Model model) {
   
        List<Course> courses = getCourseList();
        Course selectedCourse = null;
        
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                selectedCourse = course;
                break;
            }
        }
        
        model.addAttribute("course", selectedCourse);
        model.addAttribute("student", new Student()); 
        return "enroll"; 
    }
    
    @PostMapping("/submitEnrollment")
    public String submitEnrollment(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        model.addAttribute("message", "Enrollment Successful!");
        return "success"; 
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/courses";
    }
}