package org.giri.beans;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private Integer empid;
	private String name;
	private Double slary;

	public Employee() {
		super();
	}

	public Employee(Integer empid, String name, Double slary) {
		super();
		this.empid = empid;
		this.name = name;
		this.slary = slary;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSlary() {
		return slary;
	}

	public void setSlary(Double slary) {
		this.slary = slary;
	}
	
	@Override
	public int compareTo(Employee emp) {
		return this.getName().compareTo(emp.getName());
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", slary="
				+ slary + "]";
	}
	
	
	public static Comparator<Employee> EmployeNameDesending= new Comparator<Employee>() {
		
		@Override
		public int compare(Employee emp1, Employee emp2) {
			
			return - emp1.getName().compareTo(emp2.getName());
			
		}
	};
	
	
	public static Comparator<Employee> EmployeeByEmpId = new Comparator<Employee>() {
		
		@Override
		public int compare(Employee emp1, Employee emp2) {
			
			if(emp1.getEmpid() > emp2.getEmpid()){
				return 1;
			}else if(emp1.getEmpid() < emp2.getEmpid()){
				return -1;
			}else{
				return 0;
			}
		}
	};

}
