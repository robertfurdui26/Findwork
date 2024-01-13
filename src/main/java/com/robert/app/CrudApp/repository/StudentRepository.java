package com.robert.app.CrudApp.repository;

import com.robert.app.CrudApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByName(String name);
}
