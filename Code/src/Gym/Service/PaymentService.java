package Gym.Service;

import Gym.Entities.Membership;
// import Gym.Entities.MembershipPlan;
import Gym.Entities.Payment;
import Gym.Enum.PaymentMethod;
// import Gym.Model.Members;
import Gym.Interface.Searchable;

import java.util.ArrayList;

public class PaymentService implements Searchable {
    private ArrayList<Payment> paymentList = new ArrayList<>();
    public Payment processPayment(Membership membership, float discount, PaymentMethod paymentMethod ){
        Payment payment = new Payment(membership,discount,paymentMethod);
        boolean paid = payment.pay();
        //check if it's paid 
        if(paid){
            paymentList.add(payment);
            System.out.println("Payment successful");
            return payment;
        }
            System.out.println("Paymennt failed");
            return null;
    }
    //search payment by id
    
    @Override
    public Payment findByID(String ID) {
        System.out.println("Find payment with this ID :"+ID);
        for(Payment payment: paymentList){
            if(payment.getPaymentID().equals(ID)){
                return payment;
            }
        }
        return null;
    }

    public void listAll() {
        if (paymentList.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }
        System.out.println("====== ALL PAYMENTS ======");
        for (Payment p : paymentList)
            System.out.println(p);
    }

}
