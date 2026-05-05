package Gym.Entities;


public class MembershipPlan {
    private  static int count =0;
    private  String planName;
    private  String plan_ID;
    private double planPrice;
    private int duration;
// constructor
public MembershipPlan(String planName, double planPrice, int duration) {
    this.plan_ID = "PL-" + (++count);
    setPlanName(planName);
    setPlanPrice(planPrice);
    setDuration(duration);
}

    private void setPlanName(String planName) {
        if (planName == null || planName.isBlank()) {
            System.out.println("Invalid plan name. Setting default: 'Basic'");
            this.planName = "Basic";
            return;
        }
        this.planName = planName;
    }

    private void setPlanPrice(Double planPrice) {
        if (planPrice <= 0) {
            System.out.println("Invalid price. Setting default: 9.99");
            this.planPrice = 9.99;
            return;
        }
        this.planPrice = planPrice;
    }

    private void setDuration(int duration) {
        if (duration <= 0) {
            System.out.println("Invalid duration. Setting default: 1 month");
            this.duration = 1;
            return;
        }
        this.duration = duration;
    }


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
