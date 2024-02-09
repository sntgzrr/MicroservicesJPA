package com.sntzrr.services;

import com.sntzrr.models.Student;
import com.sntzrr.repositories.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {
    @Autowired
    private final IStudentRepository iStudentRepository;

    public Student saveStudent (Student student){
        return this.iStudentRepository.save(student);
    }

    public List<Student> findStudents(){
        return this.iStudentRepository.findAll();
    }
}
