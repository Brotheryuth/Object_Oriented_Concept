package Gym.Entities;

import java.time.LocalDateTime;
import Gym.Enum.PaymentMethod;
import Gym.Enum.PaymentStatus;
import Gym.Interface.Displayable;
import Gym.Interface.Payable;

public class Payment implements Displayable, Payable {
    private static int count = 0;
    private double payAmount; // base amount
    private String paymentID; //
    private float discount; // if there's a discount
    private String subcriptionID;
    private LocalDateTime paymentDate;
    private PaymentMethod method; // in what method ? KHQR ? credit card?
    private double finalAmount;
    private double amount;
    private Membership membership;

    //for payment status
    public static final String PAID = "PAID";
    public static final String FAILED="FAILED";
    public static final String PENDING="PENDING";
    private PaymentStatus paymentStatus;


    

    public Payment( Membership memShip, float discount , PaymentMethod method){
        this.paymentID="PM-"+(++count);
        this.membership=memShip;
        this.subcriptionID= memShip.getSubcriptionID();
        this.setDiscount(discount);
        this.setMethod(method);
        this.paymentDate=LocalDateTime.now();
        this.payAmount=memShip.getPlan().getPlanPrice();
        this.finalAmount= calculateFinalAmount();
        paymentStatus= PaymentStatus.PENDING;
    }

    // accessor
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
     
    public PaymentStatus getPaymentStatus(){
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
    public boolean pay() {
        if(membership == null){
            System.out.println("Payment failed no membership connect");
            paymentStatus = PaymentStatus.FAILED;     
            return false;
        }
        amount = membership.calculateFee();
        finalAmount = amount - discount;
        if(finalAmount <= 0 ){
            System.out.println("Payment failed: final amount must be greater than 0.");
            paymentStatus = PaymentStatus.FAILED;
        }   
        //activate membership 
        boolean activated = membership.activate();
         if (!activated) {
            System.out.println("Payment failed: menbership cannot be activated.");
            paymentStatus = PaymentStatus.FAILED;
            return false;
         }
         paymentStatus = PaymentStatus.PAID;
         return true;
     }

     @Override
     public boolean isPaid() {
        return paymentStatus == PaymentStatus.PAID; // if theyre the same return true ( paid=paid)
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
                Paymentstatus   : %s
                """.formatted(paymentID, subcriptionID, membership.getMember().getID(),
                membership.getMember().getName(), discount * 100, method.name(), finalAmount, paymentStatus);
    }
}
