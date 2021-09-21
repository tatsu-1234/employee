package model;

public class Account {

	private String employeeId;
	private String name;
	private int age;
	private String sex;
	private String address;
	private String department;

	public Account() {}
	public Account(String employeeId, String name, int age,
			String sex, String address, String department) {
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.department = department;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getSex() {
		return sex;
	}

	public String getAddress() {
		return address;
	}

	public String getDepartment() {
		return department;
	}
}