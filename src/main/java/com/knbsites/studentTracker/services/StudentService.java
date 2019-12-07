package com.knbsites.studentTracker.services;

import com.knbsites.studentTracker.dao.StudentDAO;

import com.knbsites.studentTracker.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDAO studentDao;

    @Autowired
    public StudentService(@Qualifier("dummyDao") StudentDAO studentDao) {
        this.studentDao = studentDao;
    }

    public int addStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> getAll(){
        return studentDao.getAll();
    }

    public Optional<Student> getById(UUID id){
        return studentDao.getById(id);
    }

    public int deleteById(UUID id){
        return studentDao.deleteById(id);
    }

    public int updateById(UUID id, Student newStudent){
        return studentDao.updateByID(id, newStudent);
    }
}

