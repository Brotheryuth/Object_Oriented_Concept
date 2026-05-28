
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
                PaymentService paymentService = new PaymentService();

                GymManagement gymManagement=new GymManagement();
                Member th= memberService.createMember("OKay", "094354");
                memberService.displayAllMember();
                // Member th= new Member("null", Gender.FEMALE, 20, "098765432");
                Membership memo= membershipService.creatMembership(th, gymManagement.getPlan()[1],LocalDateTime.now().plusDays(10));
                membershipService.displayAllMemberships();
                paymentService.processPayment(memo, 0, PaymentMethod.BYCASH);
                memberService.displayAllMember();
                //test work 
                // new GymManagement().run(input);               

        } // end main 

}
