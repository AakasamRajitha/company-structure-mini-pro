//AF0331405
package mini.project2;

public class BusinessEmployee extends Employee {
	
	//Constructor BusinessEmployee with parameter name
	public BusinessEmployee(String name) {
		super(name,50000.00);   //has default base salary of 50000
	}
	
	//returns remaining bonusBudget
	public double getBonusBudget() {
		return bonusBudget;
	}
	
	//determining bonusBudget
	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;
	 }
	
	//returns String representation of BusinessEmployee
	public String employeeStatus() {
		String s=String.format("%.2f",bonusBudget);
		return super.toString()+" with a budget of "+s;
	}

}
