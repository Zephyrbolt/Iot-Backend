package com.CTSIOT.Restfulwebservices.jpaRepo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.CTSIOT.Restfulwebservices.repository.SensorRepository;
import com.CTSIOT.Restfulwebservices.sensordata.SensorData;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Repository
@Transactional
public class JPARepository {
	
	@Autowired
	SensorRepository sensorRepo;
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	public void insert(SensorData sensor) {
		entitymanager.merge(sensor);
	}
	
	public SensorData FindById(long id) {
		return entitymanager.find(SensorData.class, id);
	}
	public void Delete_by_id(long id) {
		SensorData sen = FindById(id);
		entitymanager.remove(sen);
	}
	
	public List<SensorData> getAllData(){
		List <SensorData> sen = new ArrayList<SensorData>();
		sensorRepo.findAll().forEach(SensorData -> sen.add(SensorData));
		return sen;
	}
		
}
