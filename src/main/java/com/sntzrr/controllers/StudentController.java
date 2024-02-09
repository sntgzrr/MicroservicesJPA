package com.sntzrr.controllers;

import com.sntzrr.models.Student;
import com.sntzrr.services.PersonServiceImpl;
import com.sntzrr.services.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    @Autowired
    private final StudentServiceImpl studentService;

    @Autowired
    private final PersonServiceImpl personService;

    @PostMapping
    public Student createStudent (@Validated @RequestBody Student student){
        return this.studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getStudents(){
        return this.studentService.findStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent (@PathVariable String id, @Validated @RequestBody Student student){
        return this.studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable String id){
        this.personService.deletePerson(id);
    }
}
