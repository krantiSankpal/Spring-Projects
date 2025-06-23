package com.demoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demoapp.entity.Trainer;
import com.demoapp.service.TrainerService;
import com.demoapp.service.TrainerServiceImpl;

// @RestController
// @RequestMapping("/trainer")
// @CrossOrigin(origins = "http://localhost:4200")
public class TrainerController {

	@Autowired
    private TrainerService trainerService;

    // Show form + all trainers
    @GetMapping
    public String showTrainerPage(Model model) {
        model.addAttribute("trainer", new Trainer()); // For the form
        model.addAttribute("trainers", trainerService.getAllTrainers());
        return "trainer"; // /WEB-INF/jsp/trainer.jsp
    }

    // Save trainer from form
    @PostMapping("/save")
    public String saveTrainer(@ModelAttribute Trainer trainer) {
        trainerService.saveTrainer(trainer);
        return "redirect:/trainer";
    }

    // Delete trainer
    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.deleteTrainer(id);
        return "redirect:/trainer";
    }

    // Get trainer by empId (from form input)
    @PostMapping("/findByEmpId")
    public String getTrainerByEmpId(@RequestParam String empId, Model model) {
        Optional<Trainer> trainer = trainerService.getTrainerByEmpId(empId);
        model.addAttribute("trainerById", trainer.orElse(null));
        model.addAttribute("trainers", trainerService.getAllTrainers());
        model.addAttribute("trainer", new Trainer());
        return "trainer";
    }

    // Get trainers by subject (from form input)
    @PostMapping("/findBySubject")
    public String getTrainersBySubject(@RequestParam String subject, Model model) {
        List<Trainer> subjectTrainers = trainerService.getTrainersBySubject(subject);
        model.addAttribute("subjectTrainers", subjectTrainers);
        model.addAttribute("trainers", trainerService.getAllTrainers());
        model.addAttribute("trainer", new Trainer());
        return "trainer";
    }
}

