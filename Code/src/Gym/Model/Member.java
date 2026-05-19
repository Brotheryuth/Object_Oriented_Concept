package Gym.Model;

import Gym.Enum.Gender;

import java.util.ArrayList;

import Gym.Base.Person;
import Gym.Entities.Membership;
import Gym.Enum.MemberStatus;

public class Member extends Person {
    private ArrayList<Membership> memberships;
    private MemberStatus memberStatus;


    private static int count = 0;
    // constructor
    public Member(String name, Gender gender, int age, String phoneNumber) {
        super(name, age, gender, phoneNumber);
        super.ID =  "MEM-" + (++count);
    }
    // setter
    public void setName(String name) {
        super.setName(name);
    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public void setGender(Gender gender) {
        super.setGender(gender);
    }

    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

     public void displayMembershipHistory() {
        System.out.println("\nMembership History for " + name + ":");

        if (memberships.isEmpty()) {
            System.out.println("No membership records yet.");
            return;
        }

        for (Membership membership : memberships) {
            membership.displayInfo();
        }
    }

    
    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
    
    @Override
    public String toString() {

        return String.format("""
                ----------------------------------
                        Member INFORMATION
                ----------------------------------
                ID              : %s
                Name            : %s
                Age             : %d
                Gender          : %s
                Phone Number    : %s
                %n""",
                super.getID(),
                super.getName(),
                super.getAge(),
                super.getGender(),
                super.getPhoneNumber());
    }
}