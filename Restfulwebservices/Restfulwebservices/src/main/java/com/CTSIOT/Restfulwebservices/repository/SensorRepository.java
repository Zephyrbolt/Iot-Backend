package com.CTSIOT.Restfulwebservices.repository;

import org.springframework.data.repository.CrudRepository;

import com.CTSIOT.Restfulwebservices.sensordata.SensorData;

public interface SensorRepository extends CrudRepository <SensorData, Integer>{

}
