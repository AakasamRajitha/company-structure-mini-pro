//AF0331405
package mini.project2;

public class SoftwareEngineer extends TechnicalEmployee{
	public boolean CodeAccess;
	
	//Constructor SoftwareEngineer with parameter name
	public SoftwareEngineer(String name) {
		super(name);
        setCodeAccess(true);  //checking 0 code check ins
	}
	
	//returns whether or not this SoftwareEngineer has access to make changes to code
	public boolean getCodeAccess() {
		return CodeAccess;
	}
	
	//setting access to allow update of code
	public void setCodeAccess(boolean access) {
		this.CodeAccess=access;
	}
	
	//returns the current count of times this SoftwareEngineer has successfully checked in code
	public int getSuccessfulCheckIns() {
		return checkins;
	}
	
	//checking whether the manager approves check in or not 
	public boolean checkInCode() {
		boolean managerApproval=false;
		Employee manager=this.getManager();
		if(manager==null)
			return true;
		TechnicalLead t1=(TechnicalLead)manager;
		managerApproval = t1.approveCheckIn(this);
		if(managerApproval && this.getCodeAccess()) {
			this.checkins++;
			return true;
		}
		else
			return false;
	}
}
