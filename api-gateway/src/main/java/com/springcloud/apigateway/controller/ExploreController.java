package com.springcloud.apigateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ExploreController {

	 @Autowired
	 RestTemplate restTemplate;
	 
	    @Bean
	    @LoadBalanced
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
	 
	    @GetMapping(value = "/exploreDetails/{id}")
	    @HystrixCommand(fallbackMethod = "fallbackMethod")
	    public String getStudents(@PathVariable int id)
	    {
	        System.out.println("Getting Employee details for " + id);
	        //http://explore-service/getExplore?id="+id
	        String response = restTemplate.exchange("http://localhost:8011/getExplore?id="+id,
	                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, id).getBody();
	  
	        System.out.println("Response Body " + response);
	  
	        return "Employee Id -  " + id + " [ Employee Details " + response+" ]";
	    }
	     
	    public String  fallbackMethod(int id){
	         
	        return "Fallback response:: No employee details available temporarily";
	    }
}
