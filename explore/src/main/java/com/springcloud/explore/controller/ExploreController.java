package com.springcloud.explore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.explore.beans.Explore;
import com.springcloud.explore.service.ExploreService;

@RestController
public class ExploreController {

	@Autowired
	private ExploreService expSrvc;
	
	@GetMapping(value="/getExplore")
	public Explore getExploreById(@RequestParam("id") int id) {
		
		return expSrvc.getExploreByID(id);
	}
}
