package com.demoapp.service;

import java.util.List;
import java.util.Optional;

import com.demoapp.entity.Trainer;

public interface TrainerService {
	Trainer saveTrainer(Trainer trainer);
    List<Trainer> getAllTrainers(); // ✅ used in controller
    void deleteTrainer(Long id);    // ✅ used in controller
    Optional<Trainer> getTrainerByEmpId(String empId); // ✅ used in controller
    List<Trainer> getTrainersBySubject(String subject); // ✅ used in controller

}
