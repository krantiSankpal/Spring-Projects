package com.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
