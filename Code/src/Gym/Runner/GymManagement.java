package Gym.Runner;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Enum.Gender;
import Gym.Enum.PaymentMethod;
import Gym.Model.Admin;
import Gym.Model.Cashier;
import Gym.Model.Member;
import Gym.Model.Staff;
import Gym.Service.MemberService;
import Gym.Service.MembershipService;
import Gym.Service.PaymentService;

import java.util.ArrayList;
import java.util.Scanner;

public class GymManagement {
    /**
     * options
     */
    public static final String ADD_MEMBER    = "add member";
    public static final String VIEW_MEMBER   = "view member";
    public static final String PROCESS_PAYMENT = "process payment";
    public static final String ADD_STAFF     = "add staff";
    

    public static final String gymName = "SEBA-FITNESS";
    private MemberService memberService;
    private PaymentService paymentService;
    private MembershipService membershipService;

    //array list 
    public ArrayList<Staff> staffs;
    public Staff loginStaff;
    /**
     * array of plan 
     */
        private MembershipPlan[] plans = {
            new MembershipPlan("Basic", 19.99, 1),
            new MembershipPlan("Premium", 39.99, 3),
            new MembershipPlan("Annual", 59.99, 12)
    };
    
    // constructor
    public GymManagement() {
        memberService = new MemberService();
        membershipService=new MembershipService();
        paymentService= new PaymentService();
        // initialize staffs list before using it
        staffs = new ArrayList<>();
        Admin currenStaff = new Admin("Yuth", 19, Gender.MALE, "Manager", 500.0,"87654321");
        System.out.println("Current staff       :" + currenStaff.getName());
       
    }
    public void run() {
    }
    /**
     * login user by role 
     * @param name
     * @param password
     */

    public void login(String name, String password){
        Staff temp = new Staff(name, password);
        for (Staff staff : staffs) {
            if(staff.equals(temp)){
                loginStaff=staff;
                System.out.println("Login Successful:"+staff.getName());
                return;
            }
        }
        System.out.println("Login failed");
    }

    /**
     * Add member  
     */
    public void addMember(){
        if(loginStaff==null || !loginStaff.can(ADD_MEMBER)){
            System.out.println("Access denied!");
            return;
        }

    }

    public MembershipPlan[] getPlan(){
        return plans;
    } 

    /**
     * list all staff 
     */ 
    public void listAllStaff(){
        if(staffs.isEmpty()){
            System.out.println("Staff is empty!");
            return;
        }
        for (Staff staff : staffs) {
            staff.displayInfo();
        }
    }
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

