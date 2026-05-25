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
    public static final String ADD_CASHIER = "ADD CASHIER";
    public static final String VIEW_MEMBER = "view member";
    public static final String PROCESS_PAYMENT = "process payment";
    public static final String ADD_STAFF = "add staff";

    public static final String gymName = "SEBA-FITNESS";
    private MemberService memberService;
    private PaymentService paymentService;
    private MembershipService membershipService;

    // array list
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
        membershipService = new MembershipService();
        paymentService = new PaymentService();
        // initialize staffs list before using it
        staffs = new ArrayList<>();
        Admin currenStaff = new Admin("Yuth", 19, Gender.MALE, "Manager", 500.0, "87654321");
        staffs.add(currenStaff);
        System.out.println("Current staff       :" + currenStaff.getName());

    }

    public void run() {
    }

    /**
     * login user by role
     * 
     * @param name
     * @param password
     */

    public void login(String name, String password) {
        Staff temp = new Staff(name, password);
        for (Staff staff : staffs) {
            if (staff.equals(temp)) {
                loginStaff = staff;
                System.out.println("====Login successful by====\nName:" +staff.getName()+"\nRole:"+ whosLogin(loginStaff));
                return;
            }
        }
        System.out.println("Login failed");
    }

    /**
     * Add member
     */
    public void addMember() {
        if (loginStaff == null || !loginStaff.can(ADD_CASHIER)) {
            System.out.println("Access denied!");
            return;
        }

    }

    /**
     * a helper function to identify who's login 
     * @param staff
     * @return
     */
    public  String whosLogin( Staff staff){
        if (isAdmin(staff)) {
            return "Admin";
        }
        else if (isCashier(staff)){
            return "Cashier";
        }
        else{
            return "Unknown";
        }
    }

    /**
     * A boolean to check whether the obj is instance of admin or not 
     * @param staff
     * @return true if it's admi 
     */
    boolean isAdmin(Staff staff){
        if( staff instanceof Admin){
            return true;
        }
        return false;
    }
    /**
     * a boolean to check whether the obj is a cashier or not 
     * @param staff
     * @return true if that's a cahsier 
     */
    boolean isCashier(Staff staff){
        if(staff instanceof Cashier){
            return true;
        }
        return false;
    }

    public void addCashier(String name, int age, Gender gender,String phoneNumber, Double salary, String shift, String password){
        if( loginStaff !=null || loginStaff.can(ADD_CASHIER)){
            Cashier cashier = new Cashier(name, age, gender, phoneNumber, salary, shift, password);
            staffs.add(cashier);
            System.out.println("Cashier addded successful");
            return;
        }
        System.out.println("YOU DONT HAVE PERMISSION TO ADD CASHIER");
    }

    public MembershipPlan[] getPlan() {
        return plans;
    }

    /**
     * list all staff
     */
    public void listAllStaff() {
        if (staffs.isEmpty()) {
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
