package org.example.Repository;

import org.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>
{
    Optional<Student> findByEmail(String email);

    List<Student> findByBusId(Long busId);
}
