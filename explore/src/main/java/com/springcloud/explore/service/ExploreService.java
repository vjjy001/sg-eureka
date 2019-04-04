package com.springcloud.explore.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.springcloud.explore.beans.Explore;

@Service
public class ExploreService {

	public Explore getExploreByID(int id) {
		
		//mock data list
		List<Explore> expList = IntStream.range(1, 10).mapToObj(idx ->{
		
			Explore exp = new Explore();
			exp.setId(idx);
			exp.setName("Exp"+idx);
			return exp;
		}).collect(Collectors.toList());
		
		//filter list by id
		List<Explore> resultList = expList.stream().filter(e -> e.getId() == id).collect(Collectors.toList());
		
		return resultList != null?resultList.get(0): new Explore();
		
		
		
	}
}
