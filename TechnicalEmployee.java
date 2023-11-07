//AF0331405
package mini.project2;

public class TechnicalEmployee extends Employee {
	public int checkins;
	
	//Constructor TechnicalEmployee with parameter name
	public TechnicalEmployee(String name) {
		super(name,75000.00); //has default base salary of 75000
		checkins=0;
	}
	
	//returns String representation of TechnicalEmployee
	public String employeeStatus() {
		return super.toString()+" has "+checkins+" successful check ins";
	}
	
	public void setCheckin() {
		checkins++;
	}
	
	public int getCheckin() {
		return this.checkins;
	}

}
