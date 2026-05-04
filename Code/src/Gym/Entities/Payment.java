package Gym.Entities;

import java.time.LocalDateTime;

import Gym.Enum.PaymentMethod;

public class Payment {
    private  static int count=0;
    private double payAmount; // base amount
    private String paymentID; //
    private float discount; // if there's a discount
    private String subcriptionID;
    private LocalDateTime paymentDate;
    private PaymentMethod method; // in what method ? KHQR ? credit card?
    private double finalAmount;
    private  Membership membership;

    public Payment( Membership memShip, float discount , PaymentMethod method){
        this.paymentID="PM-"+(++count);
        this.membership=memShip;
        this.subcriptionID= memShip.getSubcriptionID();
        this.discount=discount;
        this.method=method;
        this.paymentDate=LocalDateTime.now();
        this.payAmount=memShip.getPlan().getPlanPrice();
        this.finalAmount= calculateFinalAmount();
    }
    // accessor
    public void setDiscount(float discount){
        if(discount>0)
            this.discount=discount;
        else{
            this.discount=0;
        }
    }
    public float getDiscount(){
        return discount;
    }

    public LocalDateTime getPaymentDate(){
        return this.paymentDate;
    }
    public String getPaymentID()    { return paymentID; }
    public PaymentMethod getMethod(){ return method; }
    public double getPayAmount()    { return payAmount; }
    public Membership getMembership(){
        return membership;
    }
    public double calculateFinalAmount() {
        return switch (method) {
            case KHQR -> payAmount * (1 - discount);
            case BYCASH -> payAmount * (1 - discount);
            case CREDITCARD -> payAmount * (1 - discount) * 1.05;
        };
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
            """.formatted(paymentID, subcriptionID,membership.getMember().getID(),membership.getMember().getName(), discount * 100, method.name(), finalAmount);
}
}
