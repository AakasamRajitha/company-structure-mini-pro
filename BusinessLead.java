//AF0331405
package mini.project2;

import java.util.ArrayList;

public class BusinessLead  extends BusinessEmployee{
    public ArrayList<Accountant> team=new ArrayList<Accountant>();
    
  //Constructor BusinessLead with parameter name
    public BusinessLead(String name){
        super(name);
        this.baseSalary=getBaseSalary()*2;   //salary should be twice of an Accountant
        this.headcount=10;    //starts with headcount of 10
    }
    
    //returns True if the number of direct reports this Manager has is less than their headcount
    public boolean hasHeadCount(){
        if(this.team.size()<this.headcount){
            return true;
        } 
        else {
            return false;
        }
    }
    
    public boolean addReport(Accountant e, TechnicalLead supportTeam){
        if (hasHeadCount()){
            team.add(e);
            e.setManager(this);
            this.bonusBudget+=e.baseSalary*1.1;  //bonuBudget increased by 1.1 times
            e.supportTeam(supportTeam);
            supportTeam.accountantSupport=e;
            return true;
        } 
        else {
            return false;
        }
    }
    
    //checking if the bonus amount requested would fit in BusinessLead's Budget
    public boolean requestBonus(Employee e, double bonus){
       if (bonus<=this.getBonusBudget()){
           this.bonusBudget-=bonus;  //deducting BusinessLead's Budget
           e.bonusBudget+=bonus;	 //Employee getting the bonus
           return true;
       } 
       else {
           return false;
       }
    }
    
    //checks if the bonus could be afforded
    public boolean approveBonus(Employee e, double bonus){
        for (int i=0;i<team.size();i++){
            if((team.get(i).getTeamSupported()).equals(e.manager) && team.get(i).canApproveBonus(bonus)) {
                e.bonus += bonus;
                team.get(i).bonusBudget -= bonus;
                return true;
            }
        }
        return  false;
    }

    public String getTeamStatus(){
        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } 
        else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }
    }
}
