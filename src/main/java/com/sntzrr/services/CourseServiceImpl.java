package com.sntzrr.services;

import com.sntzrr.models.Course;
import com.sntzrr.repositories.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl {

    @Autowired
    private final ICourseRepository iCourseRepository;

    public Course saveTeacher (Course course){
        return this.iCourseRepository.save(course);
    }

    public List<Course> findCourses(){
        return this.iCourseRepository.findAll();
    }

    public void deleteCourse(Long id){
        this.iCourseRepository.deleteById(id);
    }

}
