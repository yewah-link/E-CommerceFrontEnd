package com.crud.crud.controller;

import com.crud.crud.Entity.Student;
import com.crud.crud.exception.ResourceNotFoundException;
import com.crud.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("api/students")
public class StudentContoller {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent (@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity < Student> getStudentById (long id){
        Student student = studentRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("Employee with  "+id +" does not exist"));
        return  ResponseEntity.ok(student);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable("id") long id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student with id " + id + " does not exist"));
        student.setName(updatedStudent.getName());
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.ok(savedStudent);
    }

    @DeleteMapping("/id")
    public ResponseEntity < HttpStatus> deleteById (@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(()
                ->new ResourceNotFoundException("Employee with  "+id +" does not exist"));

        studentRepository.delete(student);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
