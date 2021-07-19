package com.cognixia.jump.corejava.finalproject;

public class Employee extends Human {

	private static final long serialVersionUID = 2021088541874623027L;

	private String name;
	private int year;
	private Departments department;
	
	public Employee(String name, int year, Departments department) {
		super();
		this.name = name;
		this.setYear(year);
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Full Name = " + name + ", Years Working = " + year + ", Department = " + department + "]";
	}

	


}
