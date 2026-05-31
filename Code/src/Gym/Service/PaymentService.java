package Gym.Service;

import Gym.Entities.Membership;
// import Gym.Entities.MembershipPlan;
import Gym.Entities.Payment;
import Gym.Enum.PaymentMethod;
import Gym.Interface.Displayable;
// import Gym.Model.Members;
import Gym.Interface.Searchable;

import java.util.ArrayList;

public class PaymentService implements Searchable<Payment>,Displayable {
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

    public Payment processPayment(Membership membership){
        if (membership == null){
            System.out.println("Membership cannot be null.");
            return null;
        }
        return processPayment(membership, 0, PaymentMethod.BYCASH);
    }

    public Payment processPayment(Membership membership, PaymentMethod method){
        if (membership == null){
            System.out.println("Membership cannot be null.");
            return null;
        }
        return processPayment(membership, 0, method);
    }

    public 
    //search payment by id
    @Override
    public Payment searchById(String id) {
        if(paymentList.isEmpty()){
            System.out.println("The payment list is empty!");
            return null;
        }
        for (Payment payment : paymentList) {
            if(payment.getPaymentID().equalsIgnoreCase(id)){
                return payment;
            }
        }
        return null;
    }

    @Override
    public void displayInfo() {
        System.out.println("Payment service store #"+paymentList.size()+" Payment");
        
    }

    public void listAll() {
        if (paymentList.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }
        System.out.println("====== ALL PAYMENTS ======");
        for (Payment p : paymentList)
            p.displayInfo();
    }
}
