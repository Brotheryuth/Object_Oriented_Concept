
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
import Gym.Enum.Gender;
import Gym.Interface.Displayable;
import Gym.Model.Staff;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutte
public class Main {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                // Member yuth = new Gym.Model.Member(null, null, 0, null);
                // yuth.displayable();
                // Staff vanda = new Staff(null, 0, null, null, null, 0.0);
                // vanda.displayable();

                new GymManagement().run();
                // ArrayList<Displayable> displayLis  = new ArrayList<>();
                // Admin admin = new Admin(null, 22, null, null, 2000);
                // displayLis.add(admin);
                // Staff newStaff = new Staff("null", 19, Gender.FEMALE, "null", 1000.0);
                // displayLis.add(newStaff);
                // for( Displayable d : displayLis){
                //         d.displayInfo();
                // }
      

                


                
                input.close();
        }

}