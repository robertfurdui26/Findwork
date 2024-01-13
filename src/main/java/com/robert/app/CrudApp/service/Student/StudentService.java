package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.Dto.GetStudentDto;
import com.robert.app.CrudApp.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    public List<GetStudentDto> getAllStudents();

    public GetStudentDto getStudentByid(int id);

    public Student findByName(String name);

    public Student update(Student student);

    public String delete(int id);


}
