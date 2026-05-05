package Gym.Service;

import Gym.Entities.MembershipPlan;
import Gym.Enum.Gender;
import Gym.Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {
    ArrayList<Member> memberList = new ArrayList<>();
    private MembershipPlan[] plans = {
            new MembershipPlan("Basic", 19.99, 1),
            new MembershipPlan("Premium", 39.99, 3),
            new MembershipPlan("Annual", 59.99, 12)
    };

    public Member createMember(Scanner input) {
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

        return new Member(name, genderType, age, phoneNumber);
    }
    //add member func
    public void addMember(Member member){
        memberList.add(member);
        System.out.println("Member added successful! ");
    }
    //
    public Member findByID(String id){
            for(Member m : memberList){
                if(m.getID().equals(id)){
                    return m;
                }
            }
            return null;
    }
    //list all member
    public void listAll() {
        if (memberList.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        System.out.println("====== ALL MEMBERS ======");
        for (Member m : memberList)
            System.out.println(m);
    }
}
