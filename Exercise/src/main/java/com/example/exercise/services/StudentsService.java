package com.example.exercise.services;

import com.example.exercise.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exercise.repositories.StudentsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    public List<Student> loadAll() {
        return studentsRepository.findAll();
    }

    public Student getById(int id) {
        Optional<Student> byId = studentsRepository.findById(id);
        if(byId.isPresent()) {
            return byId.get();
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(int id) {
        studentsRepository.deleteById(id);
    }

    public Student create(Student student) {
        return studentsRepository.save(student);
    }

    public Student update(Student newStudent, int id) {
        Student student = studentsRepository.findById(id).get();
        student.setFirstname(newStudent.getFirstname());
        student.setLastname(newStudent.getLastname());
        student.setSerialnumber(newStudent.getSerialnumber());
        return studentsRepository.save(student);
    }
}
