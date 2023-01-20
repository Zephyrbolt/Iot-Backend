package com.CTSIOT.Restfulwebservices.sensordata;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*******
 * We are initializing a sample collection of data for IOT in component 1 
 * id field (Auto incremental primary key 
 * Sensor name as the floornames 
 * Airvalue content 
 * will move to SO2, CO2, O2, NO2, types of air content as we move towards the component 3
 * 
 * 
 * inbuilt h2 database has been used and sql properties are defined in application.properties and schema.sql
 * 
 * Unit testing using junit 4 has been done. refer the test class
 * @author 839631
 *
 */

@Entity (name = "AQsensors")
public class SensorData {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String sensorsName;
	
	@Column
	private long AirValue;
	
	
	
	public SensorData(long id, String sensorsName, long airValue) {
		super();
		this.id = id;
		this.sensorsName = sensorsName;
		this.AirValue = airValue;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getSensorsName() {
		return sensorsName;
	}



	public void setSensorsName(String sensorsName) {
		this.sensorsName = sensorsName;
	}



	public long getAirValue() {
		return AirValue;
	}



	public void setAirValue(long airValue) {
		AirValue = airValue;
	}



	@Override
	public String toString() {
		return "SensorData [id=" + id + ", sensorsName=" + sensorsName + ", AirValue=" + AirValue + "]";
	}



	public SensorData() {
		
	}
}
