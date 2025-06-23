package com.demoapp.service;

import java.util.List;
import java.util.Optional;

import com.demoapp.entity.Subject;

public interface SubjectService {
	Subject saveSubject(Subject subject);
    List<Subject> getAllSubjects();
    Optional<Subject> getSubjectWithTrainers(Long id);

}
