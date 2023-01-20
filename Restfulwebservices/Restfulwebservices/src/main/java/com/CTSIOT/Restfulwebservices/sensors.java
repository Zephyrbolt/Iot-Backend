package com.CTSIOT.Restfulwebservices;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.CTSIOT.Restfulwebservices.Exceptionhandling.UserNotFoundException;
import com.CTSIOT.Restfulwebservices.jpaRepo.JPARepository;
import com.CTSIOT.Restfulwebservices.sensordata.SensorData;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@RestController
public class sensors {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EntityManager em;
	@Autowired
	JPARepository Repos;
	
	@GetMapping("/users")

	public String helloworld() {
		logger.info("Testing the method to print Hello world");
		return "Hello world";
	}
	
	@GetMapping("/find/{id}")
	public SensorData FindById(@PathVariable("id") long id) {
		
		logger.info("Getting the details of the specified Id");
		SensorData sen = em.find(SensorData.class, id);
		if(sen == null) 
			
			throw new UserNotFoundException("Id: " + id+ " is not found. Please try Different Id");
		return sen;
		
	}
	
	@GetMapping("/alldata")
	public List<SensorData> getAllData(){
		
		logger.info("Getting all the data present in the database");
		return Repos.getAllData();
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeleteId(@PathVariable("id") long id) {
		logger.info("Deleting the data with the id");
		Repos.Delete_by_id(id);
	}
	
}
