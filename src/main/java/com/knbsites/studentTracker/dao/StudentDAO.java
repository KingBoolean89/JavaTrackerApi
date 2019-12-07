package com.knbsites.studentTracker.dao;

import com.knbsites.studentTracker.domain.Student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentDAO {

    int insertStudent(UUID id, Student student);

    default int insertStudent(Student student){
        UUID id = UUID.randomUUID();
        return insertStudent(id, student);
    }

    List<Student> getAll();

    Optional<Student> getById(UUID id);

    int deleteById(UUID id);

    int updateByID(UUID id, Student student);


}
