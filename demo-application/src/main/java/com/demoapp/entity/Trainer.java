package com.demoapp.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainer {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empId;
    private String name;
    private String email;

    @ManyToMany
    private List<Subject> subjects;


}
