package Gym.Service;

import Gym.Entities.MembershipPlan;
import Gym.Enum.Gender;
import Gym.Enum.MemberStatus;
import Gym.Model.Members;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {
    ArrayList<Members> membersList = new ArrayList<>();
    private MembershipPlan[] plans = {
            new MembershipPlan("Basic", 19.99, 1),
            new MembershipPlan("Premium", 39.99, 3),
            new MembershipPlan("Annual", 59.99, 12)
    };

    public Members createMember(Scanner input) {
        System.out.print("Enter Name                : ");
        String name = input.nextLine().trim();

        System.out.print("Enter Age                 : ");
        int age = Integer.parseInt(input.nextLine());

        System.out.print("Enter Gender (MALE/FEMALE): ");
        Gender genderType;
        try {
            genderType = Gender.valueOf(input.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid gender. Defaulting to MALE.");
            genderType = Gender.MALE;
        }

        System.out.print("Enter Phone Number        : ");
        String phoneNumber = input.nextLine().trim();

        return new Members(name, genderType, age, phoneNumber);
    }
    //add member func
    public void addMember(Members member){
        membersList.add(member);
        System.out.println("Member added successful! ");
    }
    //
    public Members findByID(String id){
            for(Members m : membersList){
                if(m.getID().equals(id)){
                    return m;
                }
            }
            return null;
    }
    //list all member
    public void listAll() {
        if (membersList.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("====== ALL MEMBERS ======");
        for (Members m : membersList)
            System.out.println(m);
    }
}
