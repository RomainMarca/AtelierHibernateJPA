package com.example.atelier_jpa_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.atelier_jpa_hibernate.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
