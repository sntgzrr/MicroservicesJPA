package com.sntzrr.controllers;

import com.sntzrr.models.Teacher;
import com.sntzrr.services.PersonServiceImpl;
import com.sntzrr.services.TeacherServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    @Autowired
    private final TeacherServiceImpl teacherService;

    @Autowired
    private final PersonServiceImpl personService;

    @PostMapping
    public Teacher createTeacher (@Validated @RequestBody Teacher teacher){
        return this.teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> getTeachers(){
        return this.teacherService.findTeachers();
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher (@PathVariable String id, @Validated @RequestBody Teacher teacher){
        return this.teacherService.saveTeacher(teacher);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable String id){
        this.personService.deletePerson(id);
    }

}
