package com.example.exercise.controllers;

import com.example.exercise.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.exercise.services.StudentsService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/test")
    @CrossOrigin("*")
    public String test() {
        return "ok";
    }


    @GetMapping("")
    @CrossOrigin("*")
    public List<Student> loadAll() {
        return studentsService.loadAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin("*")
    public Student getStudentById(@PathVariable int id) {
        return studentsService.getById(id);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin("*")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        studentsService.delete(id);
    }

    @PostMapping("")
    @CrossOrigin("*")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student add(@RequestBody Student student) {
        return studentsService.create(student);
    }

    @PutMapping("/{id}")
    @CrossOrigin("*")
    public Student update(@RequestBody Student student, @PathVariable int id) {
        return studentsService.update(student, id);
    }
}
