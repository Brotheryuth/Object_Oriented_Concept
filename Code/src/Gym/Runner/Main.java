
package Gym.Runner;
// import Gym.Entities.Membership;
// import Gym.Entities.MembershipPlan;
// import Gym.Entities.Payment;
// import Gym.Enum.Gender;
// import Gym.Enum.PaymentMethod;
// import Gym.Model.Member;


// import Gym.Service.PaymentService;

import java.util.Scanner;

import Gym.Model.Admin;
import Gym.Model.Member;
import Gym.Entities.Membership;
import Gym.Enum.Gender;
import Gym.Enum.PaymentMethod;
import Gym.Interface.Displayable;
import Gym.Model.Staff;
import Gym.Service.MemberService;
import Gym.Service.MembershipService;
import Gym.Service.PaymentService;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutte
public class Main {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                MemberService memberService= new MemberService();
                MembershipService membershipService= new MembershipService();
                PaymentService paymentService= new PaymentService();
                GymManagement gymManagement = new GymManagement();


                
                Member yuth = memberService.createMember("Yuth", Gender.MALE, 20, "0987654321");
                Membership yutMembership = membershipService.creatMembership(yuth, gymManagement.getPlan()[1]);
                membershipService.displayAllMemberships();
                paymentService.processPayment(yutMembership, 0, PaymentMethod.BYCASH);
                membershipService.displayAllMemberships();
                memberService.displayAllMember();

                input.close();
        }

}
