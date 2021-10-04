package com.example.test.service;

import java.util.ArrayList;
import java.util.List;

import com.example.test.repository.ReitsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.test.model.Reits;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class ReitsService {

	private final ReitsRepository reitsRepository;

	@Autowired
	public ReitsService(ReitsRepository reitsRepository) {
		this.reitsRepository = reitsRepository;
	}

	@GetMapping
	public List<Reits> getReits() {
		return reitsRepository.findAll();
	}
}
