package org.example.Service;

import org.example.Repository.StudentRepo;
import org.example.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService
{
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo)
    {
        this.studentRepo = studentRepo;
    }

    // Register a student
    public Student registerStudent(Student student)
    {
        return studentRepo.save(student);
    }

    // Find a student by email
    public Optional<Student> findStudentByEmail(String email)
    {
        return studentRepo.findByEmail(email);
    }

    // Get all students for specific bus
    public List<Student> getStudentByBusId(Long busId)
    {
        return studentRepo.findByBusId(busId);
    }

    // Delete a student by ID
    public void deleteStudent(Long studentId)
    {
        studentRepo.deleteById(studentId);
    }
}
