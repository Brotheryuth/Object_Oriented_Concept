package Gym.Entities;

import java.time.LocalDateTime;
import Gym.Enum.PaymentMethod;
import Gym.Interface.Displayable;

public class Payment implements Displayable {
    private static int count = 0;
    private double payAmount; // base amount
    private String paymentID; //
    private float discount; // if there's a discount
    private String subcriptionID;
    private LocalDateTime paymentDate;
    private PaymentMethod method; // in what method ? KHQR ? credit card?
    private double finalAmount;
    private Membership membership;

    //for payment status
    public static final String PAID = "PAID";
    public static final String FAILED="FAILED";
    private String paymentStatus;


    

    public Payment( Membership memShip, float discount , PaymentMethod method, double payAmount){
        this.paymentID="PM-"+(++count);
        this.membership=memShip;
        this.subcriptionID= memShip.getSubcriptionID();
        this.setDiscount(discount);
        this.setMethod(method);
        this.paymentDate=LocalDateTime.now();
        this.setPayAmount(payAmount);
        this.finalAmount= calculateFinalAmount();
    }

    // accessor
    /**
     * set amount base on the the plan if success change paymentStatus to PAID
     * @param payAmount 
     */
    public void setPayAmount(double payAmount) {
        if (payAmount == membership.getPlan().getPlanPrice()) {
            this.payAmount = payAmount; 
            // paid 
            paymentStatus=PAID;
           
        } else {
            this.payAmount = 0;
            System.out.println("Invalid amount. Expected: $" + membership.getPlan().getPlanPrice());
            paymentStatus=FAILED;
            
        }
    }
    public void setDiscount(float discount) {
        if (discount >= 0)
            this.discount = discount;
        else {
            this.discount = 0;
        }
    }

    public float getDiscount() {
        return discount;
    }

    public LocalDateTime getPaymentDate() {
        return this.paymentDate;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public Membership getMembership() {
        return membership;
    }
     
    public String getPaymentStatus(){
        return paymentStatus;
    }
   
    //set method 
    private void setMethod(PaymentMethod method){
        if (method ==null) {
            System.out.println("Method cannot be null! it will be set to BY CASH as default");
            this.method=PaymentMethod.BYCASH;
        }
        this.method=method;
    }
    public double calculateFinalAmount() {
        return switch (method) {
            case KHQR -> payAmount * (1 - discount);
            case BYCASH -> payAmount * (1 - discount);
            case CREDITCARD -> payAmount * (1 - discount) * 1.05;
        };
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return """
                Payment ID      : %s
                Subscription ID : %s
                Member ID       : %s
                Member Name     : %s
                Discount        :%.0f%%
                Method          :%s
                Final Amount    :$%.2f
                """.formatted(paymentID, subcriptionID, membership.getMember().getID(),
                membership.getMember().getName(), discount * 100, method.name(), finalAmount);
    }
}
