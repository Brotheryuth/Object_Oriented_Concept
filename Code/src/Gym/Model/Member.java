package Gym.Model;

import Gym.Enum.Gender;

import java.util.ArrayList;

import Gym.Base.Person;
import Gym.Entities.Membership;
import Gym.Enum.MemberStatus;
import Gym.Enum.MembershipStatus;

public class Member extends Person {
    private ArrayList<Membership> memberships;
    private MemberStatus memberStatus;

    private static int count = 0;

    // constructor
    public Member(String name, Gender gender, int age, String phoneNumber) {
        super(name, age, gender, phoneNumber);
        memberships =  new ArrayList<>();
        super.ID = "MEM-" + (++count);
        this.memberStatus=MemberStatus.INACTIVE;
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

    public MemberStatus getMemberStatus(){
        return memberStatus;
    }

    /**
     * if member already create membership 
     * @param membership
     */
    public void addMembership(Membership membership){
        if( membership !=null || !memberships.contains(membership)){
            memberships.add(membership);
         
            if(membership.getMembershipStatus() == MembershipStatus.ACTIVE){
                this.memberStatus = MemberStatus.ACTIVE;
            }
        }
       
    }


    /**
     * Display all membership 
     */
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
                Member Status   : %s
                %n""",
                super.getID(),
                super.getName(),
                super.getAge(),
                super.getGender(),
                super.getPhoneNumber(),
                this.getMemberStatus()
            );
    }
}