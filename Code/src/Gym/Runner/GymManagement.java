package Gym.Runner;

import Gym.Entities.Membership;
import Gym.Enum.Gender;
import Gym.Enum.PaymentMethod;
import Gym.Model.Member;
import Gym.Model.Staff;
import Gym.Service.MemberService;
import Gym.Service.PaymentService;

import java.util.Scanner;

public class GymManagement {
    public static final String gymName = "SEBA-FITNESS";
    private MemberService memberService = new MemberService();
    private PaymentService paymentService = new PaymentService();

    public GymManagement() {
        Staff currenStaff = new Staff("Yuth", 19, Gender.MALE, "Manager", 500.0);
        System.out.println("Current staff       :" + currenStaff.getName());
       
    }
    public void run() {

        //  System.out.println("-----Add member------");
        Member thonsar = new Member("thonsar", Gender.MALE, 20, "09832134");
        Member mina = new Member("Minalyn", Gender.FEMALE, 18, "098765434");
        Member sovan = new Member("Sovan", Gender.MALE, 20, "094321325");
       
        Membership thonsaMembership = new Membership(thonsar, memberService.getPlan()[0]);
        Membership sovanMembership= new Membership(sovan, memberService.getPlan()[2]);
        Membership minaMembership  = new Membership(mina, memberService.getPlan()[2]);


        // add to service
        memberService.addMembership(thonsaMembership);
        memberService.addMembership(sovanMembership);
        memberService.addMembership(minaMembership);

        // payment 
        paymentService.processPayment(thonsaMembership, 0, PaymentMethod.KHQR);
        paymentService.processPayment(sovanMembership, 0, PaymentMethod.BYCASH);
        memberService.listAll();
    }
    // public void run() {
    // int choice = -1;
    // System.out.println("Welcome To " + gymName);
    // do {
    // System.out.println(
    // """
    // \tMain Menu
    // 1.Manager Members
    // 2.Manage Payment
    // 0.Exit!
    // """);
    // System.out.print("Enter Choice : ");
    // choice = input.nextInt();
    // input.nextLine();
    // switch (choice) {
    // case 1 -> memberMenu();
    // case 2 -> paymentMenu();
    // case 0 -> System.out.println("Good Luck");

    // }
    // } while (choice != 0);
    // }

    // private void memberMenu() {
    // int choice = -1;
    // do {
    // System.out.println("""
    // \n====== MEMBER MENU ======
    // 1. Add Member
    // 2.Add Membership
    // 2. View All Members
    // 0. Back
    // =========================""");
    // System.out.print("Enter choice: ");
    // choice = input.nextInt();
    // input.nextLine();
    // switch (choice) {
    // case 1 -> {
    // Member m = memberService.createMember(input);
    // memberService.addMember(m);
    // }
    // case 2 -> {

    // }
    // case 3 -> {
    // memberService.listAll();
    // }
    // case 0 -> System.out.println("Back...");
    // default -> System.out.println("Invalid choice.");
    // }
    // } while (choice != 0);
    // } // end member menu

    // private void paymentMenu() {
    // int choice = -1;
    // do {
    // System.out.println("""
    // \n====== PAYMENT MENU ======
    // 1. Process Payment
    // 2. View All Payments
    // 0. Back
    // ==========================""");
    // System.out.print("Enter choice: ");
    // choice = input.nextInt();
    // input.nextLine();

    // switch (choice) {
    // case 1 -> {
    // System.out.print("Enter Member ID: ");
    // // Members m = memberService.findByID(input.nextLine());
    // Membership m = membershipService.findByID(input.nextLine());
    // if (m == null) {
    // System.out.println("Member not found.");
    // break;
    // }
    // System.out.print("Enter Discount (0 for none): ");
    // float discount = input.nextFloat();
    // input.nextLine();
    // System.out.print("Enter Payment Method (KHQR/BYCASH/CREDITCARD): ");
    // PaymentMethod method = PaymentMethod.valueOf(input.nextLine().toUpperCase());
    // System.out.println("Pay according to your plan:");double
    // payAmount=input.nextDouble();
    // input.nextLine();
    // paymentService.processPayment(m, discount, method, payAmount );
    // }
    // case 2 -> paymentService.listAll();
    // case 0 -> System.out.println("Back...");
    // default -> System.out.println("Invalid choice.");
    // }
    // } while (choice != 0);
    // }

}
