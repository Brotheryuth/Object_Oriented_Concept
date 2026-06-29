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
       throw new IllegalArgumentException("Plan name cannot be null."); 
    } else {
        this.planName = planName;
    }
    if (planPrice < 0) {
        throw new IllegalArgumentException("Plan price cannot be negative.");
    } else {
        this.planPrice = planPrice;
    }
    if (duration <= 0) {
        throw new IllegalArgumentException("Plan duration must be at least 1 month.");
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
