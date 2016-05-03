package org.giri.web.test.service;

import static org.junit.Assert.assertEquals;

import org.giri.web.entity.EmployeeA;
import org.giri.web.service.EmployeeAService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("dev")
@ContextConfiguration(locations={
		"classpath:org/giri/web/test/resources/test-entitymanager-context.xml",
		"classpath:org/giri/web/resources/service-context.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeAServiceTest
{
	@Autowired
	EmployeeAService aService;
	
	@Before
	public void setup(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<< setup method >>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@After
	public void destroy(){
		System.out.println("destroy logic need to add here");
	}
	
	@Test
	public void createUser() throws Exception{
		EmployeeA a = new EmployeeA();
		a.setAge(28);
		a.setName("giri service");
		aService.saveEmployeeA(a);
		System.out.println("EmployeeA created : "+a.getId());
		EmployeeA employeeA=aService.getEmployeeA(a.getId());
		assertEquals("Both Id should be same",a.getId(),employeeA.getId());
		
		
	
	}
	
	
}
