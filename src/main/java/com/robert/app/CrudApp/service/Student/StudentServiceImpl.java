package com.robert.app.CrudApp.service;

import com.robert.app.CrudApp.Dto.GetStudentDto;
import com.robert.app.CrudApp.model.Student;
import com.robert.app.CrudApp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<GetStudentDto> getAllStudents() {

       List<Student> studentList =  studentRepository.findAll();
       return studentList.stream()
               .map(it ->fromEntityToDto(it))
               .collect(Collectors.toList());
    }

    public  GetStudentDto fromEntityToDto(Student student){
        return new GetStudentDto(student.getId(),student.getName(),student.getAddress());
    }

    @Override
    public GetStudentDto getStudentByid(int id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return fromEntityToDto(student);
        }
        return null;
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Student update(Student student) {
        Student existstinStudent = studentRepository.findById(student.getId()).orElse(null );
        existstinStudent.setName(student.getName());
        existstinStudent.setAddress(student.getAddress());

        return  studentRepository.save(existstinStudent);
    }

    @Override
    public String delete(int id) {
        studentRepository.deleteById(id);
        return "Student removed" + id;
    }
}
