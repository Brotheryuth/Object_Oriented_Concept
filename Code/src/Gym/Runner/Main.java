
package Gym.Runner;
// import Gym.Entities.Membership;

import java.time.LocalDateTime;

// import Gym.Entities.MembershipPlan;
// import Gym.Entities.Payment;
// import Gym.Enum.Gender;
// import Gym.Enum.PaymentMethod;
// import Gym.Model.Member;

// import Gym.Service.PaymentService;

import java.util.Scanner;

import Gym.Base.Person;
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

public class Main {

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);   
                MembershipService membershipService = new MembershipService();
                MemberService memberService = new MemberService();
                PaymentService paymentService = new PaymentService(membershipService);

                GymManagement gymManagement=new GymManagement();

                Staff cashier= new Cashier("nika", 20, Gender.FEMALE, "098765432", 1200.0, "Night", "YYYY");
                cashier.displayInfo();

                Admin admin = new Admin("admin", 20, Gender.MALE, "0987654321", 22000, "admin");
                admin.displayInfo();

               
                //test work 
                // new GymManagement().run(input);               

        } // end main 

}
