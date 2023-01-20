package com.CTSIOT.Restfulwebservices.sampleApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.CTSIOT.Restfulwebservices.jpaRepo.JPARepository;
import com.CTSIOT.Restfulwebservices.sensordata.SensorData;

import jakarta.persistence.EntityManager;

@RestController
public class APISample {
	
	@Autowired
	EntityManager em;
	JPARepository Repository;
	
	@GetMapping("/Sample")
	public String smethod() {
		return "This is a sample API";
	}
	
	
	@GetMapping("/SampleID/{id}")
	public SensorData GetSampleID(@PathVariable("id") long id) {
		SensorData sen = em.find(SensorData.class, id);
		return sen;
	}

}
