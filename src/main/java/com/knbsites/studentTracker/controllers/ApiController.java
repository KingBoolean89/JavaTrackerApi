package com.knbsites.studentTracker.controllers;

import com.knbsites.studentTracker.domain.Student;
import com.knbsites.studentTracker.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/student")
@RestController
public class ApiController {

    private final StudentService studentService;

    @Autowired
    public ApiController(StudentService studentService) {
        this.studentService = studentService;
    }



    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    List<Student> getAll(){
        return studentService.getAll();
    }
    @GetMapping(path = "{id}")
    public Student getById(@PathVariable("id") UUID id){
        return studentService.getById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteById(@PathVariable("id") UUID id){
        studentService.deleteById(id);
    }

    @PutMapping(path = "{id}")
    public void updateById(@PathVariable("id") UUID id, @RequestBody Student studentToUpdate){
        studentService.updateById(id, studentToUpdate);
    }

}

