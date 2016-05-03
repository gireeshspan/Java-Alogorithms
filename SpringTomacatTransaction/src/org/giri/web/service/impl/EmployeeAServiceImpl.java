package org.giri.web.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.giri.web.controller.HomeController;
import org.giri.web.dao.EmployeeADao;
import org.giri.web.entity.EmployeeA;
import org.giri.web.service.EmployeeAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeAServiceImpl implements EmployeeAService
{
	Log log = LogFactory.getLog(EmployeeAServiceImpl.class);
	
	@Autowired
	EmployeeADao employeeADao;

	@Override
	public void saveEmployeeA(EmployeeA a) throws Exception
	{
		employeeADao.create(a);
		log.info("Servive saveEmployeeA method completede successfully");
	}

	@Override
	public void updateEmployeeA(EmployeeA a) throws Exception
	{
		employeeADao.update(a);
	}

	@Override
	public void deleteEmployeeA(EmployeeA a) throws Exception
	{
		employeeADao.delete(a);
	}

	@Override
	public EmployeeA getEmployeeA(String empId) throws Exception
	{
		return employeeADao.load(EmployeeA.class, empId);
	}

}
