package com.avenger.StudentManagement_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping("/student") // Common path prefix
public class StudentController {

@Autowired
StudentService studentService

    //get the information
    @GetMapping("/get_Student")
    public Student getStudent(@RequestParam("q") int admnNo) {

        return studentService.getStudent(admnNo);
    }

    //adding information
    @PostMapping("/add_Student")
    public String addStudent(@RequestBody Student student) {
     return studentService.addStudent(student);
    }
    //delete information
    @DeleteMapping("/delete_Student/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }
        //put infomation
        @PutMapping("/update_Student")
        public String updateStudent(@RequestParam("id") int id, @RequestParam("age") int age) {
            return studentService.updateStudent(id,age);

    }



