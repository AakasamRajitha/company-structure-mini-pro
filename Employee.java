//AF0331405
package mini.project2;

public abstract class Employee{
	
	public String name;
	public double baseSalary;
	public int employeeID;
	public Employee manager;
	public double bonusBudget;
	public double bonus;
	public Accountant accountantSupport;
	public int headcount=0;
	static int countID;
	
	 //Constructor Employee with two parameters
	public Employee(String name,double baseSalary) {
		this.name=name;
		this.baseSalary=baseSalary;
		countID++;   
		this.employeeID=countID; //ID issued at the time they are constructed
	}
	
	//returns employee's base salary
	public double getBaseSalary() {
		return this.baseSalary;
	}
	
	//returns employee's name
	public String getName() {
		return this.name;
	}
	
	//returns employee's ID
	public int getEmployeeID() {
		return this.employeeID;
	}
	
	//returns a reference to the Employee object that represents this employee's manager
	public Employee getManager() {
		return manager;
	}
	
	//setting Manager for Employee object
	public void setManager(Employee manager) {
		this.manager=manager;
	}
	
	public Accountant getAccountantSupport() {
		return accountantSupport;
	}
	
	//returns True if two employee's ID are same else false
	public boolean equals(Employee other) {
		return this.getEmployeeID()==other.getEmployeeID();
	}
	
	//returns String representation of employee ID followed by their name
	public String toString() {
		return getEmployeeID()+" "+getName();
	}
	
	//different for every subclass of Employee
	public abstract String employeeStatus();
}
