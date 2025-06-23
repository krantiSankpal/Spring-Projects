package com.demoapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoapp.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
	Optional<Trainer> findByEmpId(String empId);
    List<Trainer> findBySubjects_Name(String subjectName);

}
