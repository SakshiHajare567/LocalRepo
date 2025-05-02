package com.avenger.StudentManagement_System;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student") // Common path prefix
public class StudentController {

    @Autowired
    StudentService studentService;

    // Get student information by admission number
    @GetMapping("/get_student")
    public ResponseEntity<Student> getStudent(@RequestParam("admnNo") int admnNo) {
        Student student= studentService.getStudent(admnNo);
        return new ResponseEntity<> (student, HttpStatus.FOUND);
    }

    // Add a new student
    @PostMapping("/add_student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        String response = studentService.addStudent(student);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

   //  Delete student by ID
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity <String>deleteStudent(@PathVariable("id") int id) {

        String response =  studentService.deleteStudent(id);
        if(response.equals("Invalid id")){
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(response,HttpStatus.FOUND);
    }

    // Update student's age by ID
    @PutMapping("/update_student")
    public ResponseEntity <String> updateStudent(@RequestParam("id") int id, @RequestParam("age") int age) {
        String respose = studentService.updateStudent(id, age);
        if(respose == null){
            return new ResponseEntity<>("Invalid respose" , HttpStatus.BAD_REQUEST);
        }
        return  new ResponseEntity<>("update" , HttpStatus.ACCEPTED);

    }
}



