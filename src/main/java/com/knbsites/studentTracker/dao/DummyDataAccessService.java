package com.knbsites.studentTracker.dao;

import com.knbsites.studentTracker.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("dummyDao")
public class DummyDataAccessService implements StudentDAO{

    private static List<Student> Db = new ArrayList<>();
    private Student student;

    @Override
    public int insertStudent(UUID id, Student student) {
        Db.add(new Student(id, student.getName(), student.getClassroom() ));
        return 1;
    }

    @Override
    public List<Student> getAll() {
        return Db;
    }

    @Override
    public Optional<Student> getById(UUID id) {
        return Db.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteById(UUID id) {
        Optional<Student> maybeStudent = getById(id);
        if(maybeStudent.isEmpty()){
            return 0;
        }
        Db.remove(maybeStudent.get());
        return 1;
    }

    @Override
    public int updateByID(UUID id, Student student) {
        return getById(id)
                .map(s ->{
                    int indexOfStudentToDelete = Db.indexOf(student);
                    if(indexOfStudentToDelete >= 0){
                        Db.set(indexOfStudentToDelete, student);
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }

}

