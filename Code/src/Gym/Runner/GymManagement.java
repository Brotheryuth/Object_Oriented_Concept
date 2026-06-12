package Gym.Runner;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Entities.Payment;
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
    public static final String VIEW_MEMBER = "VIEW MEMBER";
    public static final String ADD_MEMBER  = "ADD MEMBER";
    public static final String PROCESS_PAYMENT = "PROCESS PAYMENT";
    public static final String ADD_STAFF = "ADD STAFF";

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


    // constructor
    public GymManagement() {
        memberService = new MemberService();
        membershipService = new MembershipService(memberService);
        paymentService = new PaymentService(membershipService);
        // initialize staffs list before using it
        staffs = new ArrayList<>();
        Admin currenStaff = new Admin("Yuth", 19, Gender.MALE, "Manager", 500.0, "87654321");
        staffs.add(currenStaff);
        System.out.println("Current staff       :" + currenStaff.getName());

    }

    public void run(Scanner input) {
        int op;
        do {
            // main menu
            System.out.println("=====================");
            System.out.println("1. Login");
            System.out.println("2. Exits");
            System.out.print("Enter your Choice             :");
            op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    System.out.println("========Login========");
                    switchLogin(input);
                    System.out.println("=====================");

            }
        } while (op != 2);
        System.out.println("Thank you for using our service!");
        input.close();
    }

    /**
     * login user by role
     * * @param name
     * 
     * @param password
     */

    // public void login(String name, String password) {
    //     Staff temp = new Staff(name, password);
    //     for (Staff staff : staffs) {
    //         if (staff.equals(temp)) {
    //             loginStaff = staff;
    //             System.out.println(
    //                     "====Login successful by====\nName:" + staff.getName() + "\nRole:" + whosLogin(loginStaff));
    //             return;
    //         }
    //     }
    //     System.out.println("Login failed");
    // }

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
     * * @param staff
     * 
     * @return  
     */
    public String whosLogin(Staff staff) {
        if (isAdmin(staff)) {
            return "Admin";
        } else if (isCashier(staff)) {
            return "Cashier";
        } else {
            return "Unknown";
        }
    }

    /**
     * A boolean to check whether the obj is instance of admin or not
     * * @param staff
     * 
     * @return true if it's admi
     */
    boolean isAdmin(Staff staff) {
        if (staff instanceof Admin) {
            return true;
        }
        return false;
    }

    /**
     * a boolean to check whether the obj is a cashier or not
     * * @param staff
     * 
     * @return true if that's a cahsier
     */
    boolean isCashier(Staff staff) {
        if (staff instanceof Cashier) {
            return true;
        }
        return false;
    }

    public void addCashier(String name, int age, Gender gender, String phoneNumber, Double salary, String shift,
            String password) {
        if (loginStaff != null && loginStaff.can(ADD_CASHIER)) {
            Cashier cashier = new Cashier(name, age, gender, phoneNumber, salary, shift, password);
            staffs.add(cashier);
            System.out.println("Cashier addded successful");
            return;
        }
        System.out.println("YOU DONT HAVE PERMISSION TO ADD CASHIER");
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

    /**
     * if staff is authorized navigate to this function and perform another switch
     * * @param input
     */
    public void staffOption(Scanner input) {
        int op;
        do {
            System.out.println("=====================");
            System.out.println("1.Add Cashier.");
            System.out.println("2.Log out.");
            System.out.println("0.Exit.");
            op = input.nextInt();
            input.nextLine();
            switch (op) {
                case 1:
                    this.addCashier("kiko", 19, Gender.FEMALE, "0987654321", 250.0, "Morning", "12345678");
                    break;
                case 2:
                    System.out.println(whosLogin(loginStaff) + "\t log out!");
                    loginStaff = null;
                    return;
                case 0:
                    System.out.println("||||||||||||||||||||");
                    this.loginStaff = null;
                    break;
                default:
                    System.out.println("Invalide Output!");
                    break;
            }
        } while (op != 0);

    }

    public void switchLogin(Scanner input) {
        System.out.print("Enter Name          :");
        String name = input.nextLine();
        System.out.print("Enter Password      :");
        String password = input.nextLine();
        // login(name, password);

        if (this.loginStaff != null) {
            // if is a staff, go to staff option
            staffOption(input);
            return;
        }
        return;
    }

    
}