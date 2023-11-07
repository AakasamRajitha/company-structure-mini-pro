//AF0331405
package mini.project2;
import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    public ArrayList<SoftwareEngineer> team=new ArrayList<SoftwareEngineer>();
    
  //Constructor TechnicalLead with parameter name
    public TechnicalLead(String name){
        super(name);
        this.baseSalary*=1.3; //salary 1.3 times that of TechnicalEmployee
        headcount=4;  //default head count of 4
    }
    
    //returns True if the number of direct reports this Manager has is less than their headcount
    public boolean hasHeadCount(){
        if(team.size()<headcount){
            return true;
        } 
        else {
            return false;
        }
    }
 
    public boolean addReport(SoftwareEngineer e){
        if(hasHeadCount()){
            team.add(e);     //if the TechnicalLead has head count left should add this employee to their list of direct reports
            e.setManager(this);  //setting the TechnicalLead as manager of the SoftwareEngineer.
            return true;   //if the employee is successfully added to the TechnicalLead's direct reports true should be returned
        } 
        else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){
        if(e.getManager().equals(this) && e.getCodeAccess()){//should see if the employee passed in does report to this manager and if their code access is currently set to "true".
            return true;        // if both those things are true, true is returned
        }
        else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus){
        BusinessLead businessLead= (BusinessLead)getAccountantSupport().getManager();
        if (businessLead.approveBonus(e, bonus)){  //checking whether the bonus amount requested is approved by BusinessLead or not
            return true;
        } 
        else {
            return false;
        }
    }
    
    //returns String representation that gives insight into Manager and all direct reports
    public String getTeamStatus(){
       //if TechnicalLead has no reports
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } 
        else {  //if TechnicalLead has reports
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }
}
