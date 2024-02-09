package com.sntzrr.services;

import com.sntzrr.models.Teacher;
import com.sntzrr.repositories.ITeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl {

    @Autowired
    private final ITeacherRepository iTeacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return this.iTeacherRepository.save(teacher);
    }

    public List<Teacher> findTeachers(){
        return this.iTeacherRepository.findAll();
    }
}
