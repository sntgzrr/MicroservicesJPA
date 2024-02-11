package com.sntzrr.controllers;

import com.sntzrr.models.Course;
import com.sntzrr.services.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    @Autowired
    private final CourseServiceImpl courseService;

    @PostMapping
    public Course createTeacher (@Validated @RequestBody Course course){
        return this.courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> getCourses(){
        return this.courseService.findCourses();
    }

    @PutMapping("/{id}")
    public Course updateCourse (@PathVariable String id, @Validated @RequestBody Course course){
        return this.courseService.saveCourse(course);
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id){
        this.courseService.deleteCourse(id);
    }
}
