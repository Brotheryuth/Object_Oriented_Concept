
package Gym.Runner;


import java.util.ArrayList;
import java.util.Scanner;

import Gym.Enum.Gender;
import Gym.Model.Admin;
import Gym.Model.Cashier;
import Gym.Model.Staff;
import Gym.Service.MemberService;
import Gym.Service.MembershipService;
import Gym.Service.PaymentService;


public class Main {

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);   
                MemberService memberService = new MemberService();
                MembershipService membershipService = new MembershipService(memberService);
                PaymentService paymentService = new PaymentService(membershipService);

                // GymManagement gymManagement = new GymManagement();
                ArrayList<Staff> staffs = new ArrayList<>();
                staffs.add(new Admin("Yuth", 20, Gender.MALE, "0987654321", 1550.0, "0000"));
                staffs.add(new Cashier("Sombo", 20, Gender.MALE, "0987654321", 500.0, "Morning", "9877"));
                for (Staff staff : staffs) {
                        staff.displayInfo();
                }
                // Member mm = memberService.createMember("yuth","0987654321"); 
               
                // Membership membership = membershipService.createMembership( mm, membershipService.getPlans().get(0));
                // paymentService.processPayment(membership);
                // paymentService.listAll();


                // System.out.println(membershipService.searchByMember(mm));
                
                // gymManagement.run(input);

                // Staff cashier= new Cashier("nika", 20, Gender.FEMALE, "098765432", 1200.0, "Night", "YYYY");

                // cashier.displayInfo();

                // Admin admin = new Admin("admin", 20, Gender.MALE, "0987654321", 22000, "admin");
                // admin.displayInfo();

               input.close();
                //test work 
                // new GymManagement().run(input);               

        } // end main

}
