package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Log4j2
public class StudentController {

    @Autowired
    private StudentService studentService;


//***************************************************************************************************************


    //GET THE ALL ELEMENTS OF THE ARRAYLIST
    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> student = studentService.getAllStudents();
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(student));
    }

    //    GET THE ELEMENT BY THE ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable("id") Integer id) {
        Optional<Student> student = studentService.getStudent(id);
        if (!student.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student is not found for the particular id");
        }
        return ResponseEntity.of(Optional.of(student));
    }

    //  ADD THE STUDENT INTO THE ARRAYLIST
    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
          studentService.addStudent(student);
        return  ResponseEntity.status(HttpStatus.OK).body("The Data is successfully added into the database");
    }

    //  UPDATE THE ELEMENT FROM THE LIST
    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }

    //    DELETE THE ELEMENT FROM THE LIST
    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
    }


}
