package com.example.atelier_jpa_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.atelier_jpa_hibernate.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

}
