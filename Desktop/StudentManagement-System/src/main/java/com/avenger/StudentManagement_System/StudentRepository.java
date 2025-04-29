package com.avenger.StudentManagement_System;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentRepository {
    Map<Integer, Student> db = new HashMap<>();
    public Student getStudent(int admnNo) {

        return db.get(admnNo);
    }

    //adding informatio
    public String addStudent( Student student) {
        int admnNo = student.getAdmnNo();
        db.put(admnNo, student);
        return "Student added successfully";
    }
    //delete information
    public String deleteStudent( int id) {
        if (!db.containsKey(id)) {
            return "Invalid ID";
        }
        db.remove(id);
        return "Student removed successfully";
    }
    //put infomation
    public String updateStudent( int id,  int age) {
        if (!db.containsKey(id)) {
            return "Invalid id";
        }
        Student student = db.get(id);
        student.setAge(age);
        return "Age updated successfully";
    }

}




}
