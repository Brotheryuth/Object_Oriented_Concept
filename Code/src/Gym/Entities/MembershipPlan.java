package Gym.Entities;

//not used anywhere

import Gym.Interface.Displayable;
public class MembershipPlan implements Displayable{
    private   static int count =0;
    private final String planName;
    private final String plan_ID;
    private final double planPrice;
    private final int duration;
// constructor

public MembershipPlan(String planName, double planPrice, int duration) {
    this.plan_ID = "PL-" + (++count);
    
    if (planName == null || planName.isBlank()) {
        System.out.println("Plan name cannot be null. Setting to UNKNOWN.");
        this.planName = "UNKNOWN";
    } else {
        this.planName = planName;
    }
    if (planPrice < 0) {
        System.out.println("Plan price cannot be negative. Setting to 0.0.");
        this.planPrice = 0.0;
    } else {
        this.planPrice = planPrice;
    }
    if (duration <= 0) {
        System.out.println("Plan duration must be at least 1 month. Setting to 1.");
        this.duration = 1;
    } else {
        this.duration = duration;
    }
}
    // accessor
    
    public  String getName(){
        return planName;
    }
    public String getPlan_ID(){
        return plan_ID;
    }
    public double getPlanPrice(){
        return planPrice;
    }
    public int getDuration(){ return  duration;}
    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
    //to output
    @Override
    public String toString() {
        return String.format("""
            ----------------------------------
                    MEMBERSHIP PLAN
            ----------------------------------
            ID              : %s
            Plan Name       : %s
            Price           : $%.2f
            Duration        : %d month(s)
            ----------------------------------
            """, getPlan_ID(),getName(), getPlanPrice(),getDuration());
    }
}
