//AF0331405
package mini.project2;

public class Accountant extends BusinessEmployee{
	public TechnicalLead teamSupported;
	
	//Constructor Accountant with parameter name
	public Accountant(String name) {
		super(name);
        bonusBudget=0;	//starting with bonusBudget 0
	}
	
	//returns a reference to TechnicalLead that this Accountant is supporting
	public TechnicalLead getTeamSupported(){
		return teamSupported;
	}
	
	//passing a reference to TechnicalLead
	public void supportTeam(TechnicalLead lead){
		this.teamSupported=lead;
		double budget=0;
		for(SoftwareEngineer e: lead.team) {
			budget=budget+e.getBaseSalary();
		}
	}
	
	//checking to approve Bonus
	public boolean canApproveBonus(double bonus){
		double requestedBonus=bonus;  //taking suggested bonus amount
        if (requestedBonus<=this.getBonusBudget()){   //checking if there is still enough in the budget
            return true;
        } 
        else {
            return false;
        }
	}
	
	//returns String representation of Accountant with managed budget and name of TechnicalLead they are supporting
	public String employeeStatus(){
		return this.toString()+" with a budget of "+ getBonusBudget()+" is supporting "+ this.getTeamSupported();
	}
}
