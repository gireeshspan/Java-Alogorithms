package org.giri.web.test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.giri.web.dao.EmployeeADao;
import org.giri.web.entity.EmployeeA;
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
		"classpath:org/giri/web/test/resources/test-entitymanager-context.xml"
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeADaoTest
{
	@Autowired
	EmployeeADao employeeADao;
	
	@Before
	public void setup(){
		System.out.println("<<<<<<<<<<<<<<<<<<<<< setup method >>>>>>>>>>>>>>>>>>>>>>>>");
	}
	
	@Test
	public void createEmployeeA(){
		try{
			EmployeeA a = new EmployeeA();
			a.setAge(12);
			a.setName("test giri");
			employeeADao.create(a);
			System.out.println("-------------- EmployeeA is cretaed with id : "+a.getId());
			EmployeeA employeeA=employeeADao.load(EmployeeA.class, a.getId());
			System.out.println(a.getId());
			System.out.println(employeeA.getId());
			assertEquals("Both Id should be same",a.getId(),employeeA.getId());
			System.out.println("------------ Test Done for EmployeeA creation ----------------");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("ERROR>>>>>>>>>>>>>>>"+e.getMessage());
		}
		
	}
	
	@Test
	public void updateEmployeeA(){
		EmployeeA a = new EmployeeA();
		a.setAge(31);
		a.setName("test giri1");
		employeeADao.create(a);
		System.out.println("EmployeeA cretaed with : "+a);
		
		EmployeeA employeeA=employeeADao.load(EmployeeA.class, a.getId());
		employeeA.setName("updated test giri1");
		employeeADao.update(employeeA);
		System.out.println("EmployeeA updated with : "+employeeA);
		
		assertEquals("Updated value", "updated test giri1", employeeA.getName());
	}
	
	@Test
	public void deleteEmployeeA(){
		EmployeeA a = new EmployeeA();
		a.setAge(33);
		a.setName("delete test giri");
		employeeADao.create(a);
		System.out.println("Employee Created for id : "+a.getId());
		
		employeeADao.delete(a);
		
		System.out.println("Employe deleted for id : "+a.getId());
		EmployeeA employeeA = employeeADao.load(EmployeeA.class, a.getId());
		
		assertNull("Employee Deleted",employeeA);
		
	}
	
	@After
	public void destroy(){
		System.out.println("destroy logic need to add here");
	}
	
	
	
}
