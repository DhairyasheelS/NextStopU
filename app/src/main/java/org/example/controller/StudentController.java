package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.Service.StudentService;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController
{
    @Autowired
    private final StudentService studentService;

    // Register a student
    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student)
    {
        Student newStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(newStudent);
    }

    // Get student by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email)
    {
        Optional<Student> student = studentService.findStudentByEmail(email);
        return student.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }

    // Get Student by Bus ID
    @GetMapping("/bus/{busId}")
    public ResponseEntity<List<Student>> getStudentsByBusId(@PathVariable Long busId)
    {
        List<Student> students = studentService.getStudentByBusId(busId);
        return ResponseEntity.ok(students);
    }

    // Delete a Student Id
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }
}
