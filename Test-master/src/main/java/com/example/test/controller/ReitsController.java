package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Reits;
import com.example.test.service.ReitsService;

@RestController
@RequestMapping(path="/api/reits")
public class ReitsController {

	private ReitsService reitsService;

	@Autowired
	public ReitsController(ReitsService reitsService) {
		this.reitsService = reitsService;
	}
	
	@GetMapping
	public List<Reits> getReitsList(){
		return reitsService.getReits();
	}
}