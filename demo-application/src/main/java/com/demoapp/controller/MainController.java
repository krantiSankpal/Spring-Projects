package com.demoapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demoapp.entity.Subject;
import com.demoapp.entity.Trainer;
import com.demoapp.service.SubjectServiceImpl;
import com.demoapp.service.TrainerServiceImpl;

@Controller
@RequestMapping("/")
public class MainController {

	 @Autowired
	    private TrainerServiceImpl trainerService;

	    @Autowired
	    private SubjectServiceImpl subjectService;
	    
	    
	    @GetMapping("/")
		public String showDashboard() {
			return "index";
		}
	    @GetMapping("/navbar")
		public String shownavbar() {
			return "navbar";
		}

	    // ======================= Trainer Section =======================

	    @GetMapping("trainer")
	    public String showTrainerPage(Model model) {
	        model.addAttribute("trainer", new Trainer());
	        model.addAttribute("trainers", trainerService.getAllTrainers());
	        model.addAttribute("subjects", subjectService.getAllSubjects());
	        return "trainer";
	    }

	    @PostMapping("/trainer/save")
	    public String saveTrainer(@ModelAttribute Trainer trainer) {
	        trainerService.saveTrainer(trainer);
	        return "redirect:/trainer";
	    }

	    @GetMapping("/trainer/delete/{id}")
	    public String deleteTrainer(@PathVariable Long id) {
	        trainerService.deleteTrainer(id);
	        return "redirect:/trainer";
	    }

	    @PostMapping("/trainer/findByEmpId")
	    public String getTrainerByEmpId(@RequestParam String empId, Model model) {
	        Optional<Trainer> trainer = trainerService.getTrainerByEmpId(empId);
	        model.addAttribute("trainerById", trainer.orElse(null));
	        model.addAttribute("trainers", trainerService.getAllTrainers());
	        model.addAttribute("trainer", new Trainer());
	        return "trainer";
	    }

	    @PostMapping("/trainer/findBySubject")
	    public String getTrainersBySubject(@RequestParam String subject, Model model) {
	        List<Trainer> subjectTrainers = trainerService.getTrainersBySubject(subject);
	        model.addAttribute("subjectTrainers", subjectTrainers);
	        model.addAttribute("trainers", trainerService.getAllTrainers());
	        model.addAttribute("trainer", new Trainer());
	        return "trainer";
	    }

	    // ======================= Subject Section =======================

	    @GetMapping("subject")
	    public String showSubjectPage(Model model) {
	        model.addAttribute("subject", new Subject());
	        model.addAttribute("subjects", subjectService.getAllSubjects());
	        return "subject";
	    }

	    @PostMapping("/subject/save")
	    public String saveSubject(@ModelAttribute Subject subject) {
	        subjectService.saveSubject(subject);
	        return "redirect:/subject";
	    }

	    @PostMapping("/subject/details")
	    public String getSubjectWithTrainers(@RequestParam Long id, Model model) {
	        Optional<Subject> subject = subjectService.getSubjectWithTrainers(id);
	        model.addAttribute("subjectDetail", subject.orElse(null));
	        model.addAttribute("subject", new Subject());
	        model.addAttribute("subjects", subjectService.getAllSubjects());
	        return "subject";
	    }
}