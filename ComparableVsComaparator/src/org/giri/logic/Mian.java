package org.giri.logic;

import java.util.Set;
import java.util.TreeSet;

import org.giri.beans.Employee;

public class Mian {

	public static void main(String[] args) {
		
		Set<Employee> set=new TreeSet<>(Employee.EmployeNameDesending);
		
		Employee emp1 = new Employee(1, "Sowmya", 100000000.00);
		Employee emp2 = new Employee(2, "Alok", 100000000.00);
		Employee emp3 = new Employee(3, "Giri", 100000000.00);
		
		
		
		set.add(emp1);
		set.add(emp2);
		set.add(emp3);
		
		
		System.out.println(set);
		
	}
	
}
