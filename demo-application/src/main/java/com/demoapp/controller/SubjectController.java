package com.demoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.demoapp.entity.Subject;
import com.demoapp.service.SubjectService;

// @RestController
// @RequestMapping("/subject")
// @CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

	@Autowired
    private SubjectService subjectService;

    // Show all subjects
    @GetMapping
    public String showSubjectPage(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subject"; // /WEB-INF/jsp/subject.jsp
    }

    // Save new subject
    @PostMapping("/save")
    public String saveSubject(@ModelAttribute Subject subject) {
        subjectService.saveSubject(subject);
        return "redirect:/subject";
    }

    // Get subject with trainers
    @PostMapping("/details")
    public String getSubjectWithTrainers(@RequestParam Long id, Model model) {
        Optional<Subject> subject = subjectService.getSubjectWithTrainers(id);
        model.addAttribute("subjectDetail", subject.orElse(null));
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", subjectService.getAllSubjects());
        return "subject";
    }
}
