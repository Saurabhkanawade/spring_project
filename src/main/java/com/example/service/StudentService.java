package com.example.service;

import com.example.repository.StudentRepository;
import com.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;



    //GET THE ALL ELEMENTS OF THE ARRAYLIST

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    //    GET THE ELEMENT BY THE ID
    public Optional<Student>  getStudent(Integer id) {
        return studentRepository.findById(id);
    }

    // ADD THE ELEMENTS INTO THE LIST
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    //  UPDATE THE ELEMENT FROM THE LIST
    public void updateStudent(Integer id, Student student) {
        student.setId(id);
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }


}