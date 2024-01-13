package com.robert.app.CrudApp.controller;

import com.robert.app.CrudApp.model.Student;
import com.robert.app.CrudApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New Student Added!";
    }

    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public Student getStuById(@PathVariable int id){
        return studentService.getStudentByid(id);
    }

    @GetMapping("/getByName/{name}")
    public Student getByName(@PathVariable String name){
        return studentService.findByName(name);
    }

}
