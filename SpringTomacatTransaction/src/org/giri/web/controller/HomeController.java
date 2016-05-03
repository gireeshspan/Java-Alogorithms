package org.giri.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.giri.web.entity.EmployeeA;
import org.giri.web.service.EmployeeAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController
{
	
	Log log = LogFactory.getLog(HomeController.class);
	
	@Autowired
	EmployeeAService employeeAService;
	
	@RequestMapping("/")
	public String getHomePage() throws Exception{
		log.info("Home page being downloading...");
		EmployeeA a=new EmployeeA();
		a.setAge(123);
		a.setName("Girish");
		employeeAService.saveEmployeeA(a);
		return "home";
	}
	
}
