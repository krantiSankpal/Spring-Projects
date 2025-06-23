package com.demoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.entity.Subject;
import com.demoapp.entity.Trainer;
import com.demoapp.repository.SubjectRepository;
import com.demoapp.repository.TrainerRepository;

@Service
public class TrainerServiceImpl implements TrainerService {
	
	@Autowired
    private TrainerRepository trainerRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;

    @Override
    public Trainer saveTrainer(Trainer trainer) {
    	if (trainer.getSubjects() != null && !trainer.getSubjects().isEmpty()) {
            List<Long> subjectIds = trainer.getSubjects().stream()
                .map(subject -> subject.getId())
                .toList();

            List<Subject> fullSubjects = subjectRepository.findAllById(subjectIds);
            trainer.setSubjects(fullSubjects);
        }

        return trainerRepository.save(trainer);
    }

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public void deleteTrainer(Long id) {
        trainerRepository.deleteById(id);
    }

    @Override
    public Optional<Trainer> getTrainerByEmpId(String empId) {
        return trainerRepository.findByEmpId(empId);
    }

    @Override
    public List<Trainer> getTrainersBySubject(String subject) {
        return trainerRepository.findBySubjects_Name(subject);
    }

}
