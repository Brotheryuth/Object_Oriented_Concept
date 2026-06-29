package Gym.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Gym.Enum.PaymentMethod;
import Gym.Enum.PaymentStatus;
import Gym.Interface.Displayable;
import Gym.Interface.Payable;

public class Payment implements Displayable, Payable {
    private static final DateTimeFormatter cleanDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
    private static int count = 0;
    private double payAmount; // base amount
    private String paymentID; //
    private float discount; // if there's a discount
    private final String subcriptionID;
    private LocalDateTime paymentDate;
    private PaymentMethod method; // in what method ? KHQR ? credit card?
    private double finalAmount;
    private double amount;
    private Membership membership;
    private final LocalDateTime createAt;

    // for payment status
    public static final String PAID = "PAID";
    public static final String FAILED = "FAILED";
    public static final String PENDING = "PENDING";
    private PaymentStatus paymentStatus;

    public Payment(Membership memShip, float discount, PaymentMethod method) {
        this.paymentID = "PM-" + (++count);

        this.setMembership(memShip);
        this.subcriptionID = memShip.getSubcriptionID();
        this.setDiscount(discount);
        this.setMethod(method);
        this.paymentDate = LocalDateTime.now();
        this.payAmount = memShip.calculateFee();
        this.finalAmount = calculateFinalAmount();
        paymentStatus = PaymentStatus.PENDING;
        this.createAt = LocalDateTime.now();
    }

    // accessor
    private void setMembership(Membership membership) {
        if (membership == null) {
            throw new IllegalArgumentException("Membership cannot be null");
        }
        this.membership = membership;

    }

    public void setDiscount(float discount) {
        if (discount >= 0 && discount <= 1)
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    // set method
    private void setMethod(PaymentMethod method) {
        if (method == null) {
            throw new IllegalArgumentException("Method cannot be null! it will be set to BY CASH as default");
        }
        this.method = method;
    }

    public double calculateFinalAmount() {
        double discountBase = payAmount * (1 - discount);
        return switch (method) {
            case KHQR -> discountBase;
            case BYCASH -> discountBase;
            case CREDITCARD -> discountBase * 1.05;
        };
    }

    @Override
    public boolean pay() {
        if (membership == null) {
            paymentStatus = PaymentStatus.FAILED;
            throw new IllegalArgumentException("Payment failed no membership connect");
        }

        finalAmount = calculateFinalAmount();
        if (finalAmount <= 0) {
            paymentStatus = PaymentStatus.FAILED;
            throw new IllegalArgumentException("Payment failed: final amount must be greater than 0.");
        }
        // activate membership
        boolean activated = membership.activate();
        if (!activated) {
            paymentStatus = PaymentStatus.FAILED;
            throw new IllegalArgumentException("Payment failed: menbership cannot be activated.");
        }
        this.paymentDate = LocalDateTime.now();
        paymentStatus = PaymentStatus.PAID;
        return true;
    }

    @Override
    public boolean isPaid() {
        return paymentStatus == PaymentStatus.PAID; // if theyre the same return true ( paid=paid)
    }

    public String cleanDateFormat(LocalDateTime formatDate) {
        if (formatDate != null) {
            return formatDate.format(cleanDate);
        }
        return null;
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
                Discount        : %.0f%%
                Method          : %s
                Final Amount    :$%.2f
                Paymentstatus   : %s
                Create At       : %s
                Payment Date    : %s
                """.formatted(
                    paymentID, 
                    subcriptionID, 
                    membership.getMember().getID(),
                    membership.getMember().getName(),
                    discount * 100,
                    method.name(),
                    finalAmount, 
                    paymentStatus,  
                    this.cleanDateFormat(createAt), 
                    this.cleanDateFormat(paymentDate));
    }
}
