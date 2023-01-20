package com.CTSIOT.Restfulwebservices.jpaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.CTSIOT.Restfulwebservices.sensordata.SensorData;

@Component
public class JpaCommandLineRunner implements CommandLineRunner{
	
	
	//@Autowired
	//private JDBCRepository repo;
	
	@Autowired
	private JPARepository repo;
	
	
	@Override
	public void run(String... args) throws Exception {
		repo.insert(new SensorData(1,"0thfloor", 70));
		repo.insert(new SensorData(2,"1stfloor", 69));
		repo.insert(new SensorData(3,"2ndfloor", 68));
		repo.insert(new SensorData(4,"3rdfloor", 78));
		
		repo.FindById(2);
		
	}
	
}
