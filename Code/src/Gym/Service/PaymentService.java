package Gym.Service;

import Gym.Entities.Membership;
// import Gym.Entities.MembershipPlan;
import Gym.Entities.Payment;
import Gym.Enum.MemberStatus;
import Gym.Enum.PaymentMethod;
// import Gym.Model.Members;
import Gym.Interface.Searchable;

import java.util.ArrayList;

public class PaymentService implements Searchable {
    private ArrayList<Payment> paymentList = new ArrayList<>();
    public Payment processPayment(Membership membership, float discount, PaymentMethod paymentMethod, double payAmount ){
        Payment payment = new Payment(membership,discount,paymentMethod, payAmount );
        System.out.printf("Payment processed:%s\n",payment.getPaymentID());
        if (payment.getPaymentStatus().equals(Payment.PAID)) {
            payment.getMembership().setStatus(MemberStatus.ACTIVE);
            paymentList.add(payment);
            return payment;
        }
        else{
            return null;
        }
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
