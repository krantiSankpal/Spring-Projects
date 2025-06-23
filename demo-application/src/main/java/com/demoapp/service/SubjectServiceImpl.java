package com.demoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoapp.entity.Subject;
import com.demoapp.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getSubjectWithTrainers(Long id) {
        return subjectRepository.findById(id);
    }

}
