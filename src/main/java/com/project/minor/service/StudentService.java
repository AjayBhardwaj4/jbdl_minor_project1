package com.project.minor.service;

import com.project.minor.model.request.StudentCreateRequest;
import com.project.minor.model.Student;
import com.project.minor.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void create(StudentCreateRequest studentCreateRequest) {
        Student student = studentCreateRequest.toStudent();
        studentRepository.save(student);
    }
}
