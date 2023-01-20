package com.CTSIOT.Restfulwebservices.Repotest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.*;

import com.CTSIOT.Restfulwebservices.jpaRepo.JPARepository;
import com.CTSIOT.Restfulwebservices.sensordata.SensorData;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class JpaRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JPARepository repos;
	@Test
	public void Find_By_ID_Test() {
		
		try {
		SensorData sensor = repos.FindById(3);
		assertEquals(69, sensor.getAirValue());
		} catch (NullPointerException e){
			}
		finally {
			System.out.println("The entry has been deleted! Please try another entry number!");
			logger.info("This is after deleting the entry from database");
		}
	}
	
	@Test
	public void Delete_By_ID_Test() {
		repos.Delete_by_id(3);
		assertNull(repos.FindById(3));
		logger.info("This is before deleting the entry from database");
		
	}
	
	@Test
	public void validate_status_code() throws IOException {
		
		Integer Id = 2;
		HttpUriRequest request = new HttpGet("http://localhost:8080/find/"+Id);
		
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		
		assertEquals(httpResponse.getStatusLine().getStatusCode(),200);
		
		
	}
}
