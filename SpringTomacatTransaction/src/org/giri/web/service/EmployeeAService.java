package org.giri.web.service;

import org.giri.web.entity.EmployeeA;

public interface EmployeeAService
{
	void saveEmployeeA(EmployeeA a) throws Exception;
	
	void updateEmployeeA(EmployeeA a) throws Exception;
	
	void deleteEmployeeA(EmployeeA a) throws Exception;
	
	EmployeeA getEmployeeA(String empId) throws Exception;
}
