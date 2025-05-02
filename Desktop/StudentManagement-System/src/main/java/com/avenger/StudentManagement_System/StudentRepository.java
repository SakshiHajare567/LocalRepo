package com.avenger.StudentManagement_System;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository

public class StudentRepository{
    Map<Integer, Student> db = new HashMap<>();
    public Student getStudent(int id) {
        return db.get(id);
    }
    public String addStudent(Student student) {
        int id = student.getAdmnNo();
        db.put(id , student);
        return "Add Succesfully";
    }
    public String deleteStudent(int id){
        if(!db.containsKey(id)){
            return "Invalid id";
        }
        db.remove(id);
        return "Student remove id succesfully";
    }
    public String updateStudent( int id, int age){
        if(!db.containsKey(id)){
            return null;
        }
        db.get(id).setAge(20);
        return "upated age succesfully";
    }
}