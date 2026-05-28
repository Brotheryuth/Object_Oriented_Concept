
package Gym.Runner;
// import Gym.Entities.Membership;

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
import Gym.Model.Member;
import Gym.Model.Staff;

public class Main {

        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);                     
                int op;

                Staff memo = new Staff("yuth", 19, Gender.MALE,"098765432",500.0,"1234");
                System.out.println(memo);

                GymManagement gymManagement = new GymManagement();
                do {
                        //main menu 
                        System.out.println("=====================");
                        System.out.println("1. Login");
                        System.out.println("2. Exits");
                        System.out.print("Enter your Choice             :");
                        op = input.nextInt();
                        input.nextLine();
                        switch (op) {
                                case 1:
                                        System.out.println("========Login========");
                                        swtichLogin(gymManagement, input);
                                        System.out.println("=====================");

                        }
                } while (op != 2);
                System.out.println("Thank you for using our service!");
                input.close();
        }

        /**
         * if staff is authorized navigate to this function and perform another switch
         * @param gymManagement
         * @param input
         */
        public static void staffOption(GymManagement gymManagement , Scanner input) {
                int op;
                do{
                        System.out.println("=====================");
                        System.out.println("1.Add Cashier.");
                        System.out.println("0.Exit.");
                        op=input.nextInt();
                        input.nextLine();
                        switch (op) {
                                case 1:
                                        gymManagement.addCashier("kiko", 19, Gender.FEMALE, "0987654321", 250.0, "Morning", "12345678");
                                        break;
                                case 0:
                                        System.out.println("||||||||||||||||||||");
                                        break;
                                default:
                                        System.out.println("Invalide Output!");
                                        break;
                        }
                }while(op !=0);
                
        }

        public static void swtichLogin(GymManagement gymManagement, Scanner input) {
                System.out.print("Enter Name          :");
                String name = input.nextLine();
                System.out.print("Enter Password      :");
                String password = input.nextLine();
                gymManagement.login(name, password);

                if (gymManagement.loginStaff != null) {
                        // if is a staff, go to staff option
                        staffOption(gymManagement,input);
                        return;
                }
                return;
        }
}
