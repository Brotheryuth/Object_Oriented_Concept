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
    private MembershipService membershipService;

    public PaymentService(MembershipService membershipService){
        this.membershipService = membershipService;
    }

    /**
     * a method do perform paymennt which take these
     * @param membership
     * @param discount
     * @param paymentMethod
     * @return
     * as parameter
     */

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
    /**
     *  if membership already exist in the system and they wanna renew it 
     * @param membershipID
     * @param discount
     * @param method
     * @return
     */
    public Payment processPayment(String membershipID, double discount, PaymentMethod method) {
        Membership membership = membershipService.searchById(membershipID);
        if (membership == null) {
            System.out.println("Membership not found" + membershipID);
            return null;
        }
        return processPayment(membership, 0, method);
    }


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
