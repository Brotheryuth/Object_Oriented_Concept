package Gym.Service;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Enum.Gender;
import Gym.Interface.Displayable;
import Gym.Interface.Searchable;
import Gym.Model.Member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService implements Searchable<Member> {
    ArrayList<Member> memberList = new ArrayList<>();

        /**
         * add member and membership to the list and add to display list 
         * @param membership
         * 
        */
    // public void addMember(Membership membership){
    //     memberList.add(membership.getMember());
    // }
    public Member createMember(String name, Gender gender, int age , String phoneNumber){
        Member newMember  = new Member(name, gender, age, phoneNumber);
        memberList.add(newMember);
        return newMember;
    }

    // public Membership createMember(Scanner input) {
    //     System.out.print("Enter Name                : ");
    //     String name = input.nextLine().trim(); // trim use to trim the waste space and take the value only 

    //     System.out.print("Enter Age                 : ");
    //     int age = input.nextInt();
    //     input.nextLine();

    //     //ask to input gender
    //     System.out.print("Enter Gender (MALE/FEMALE): ");
    //     Gender genderType;
    //     String gender=input.nextLine().toUpperCase(); // change to upper case since in enum is all uppercase 
    //     if(gender.equals("MALE") || gender.equals("FEMALE")){
    //         genderType= Gender.valueOf(gender); 
    //     }
    //     else{
    //         System.out.println("Invalid input! set to default gender");
    //         genderType=Gender.OTHER;
    //     }
    //     System.out.print("Enter Phone Number        : ");
    //     String phoneNumber = input.nextLine().trim();

    //     // choose plan 
    //     System.out.println("\nAvailable Plan:"+plans.length);
    //     for( int i =0; i < plans.length;i++){
    //        System.out.printf("%d: %s - $%.2f%n",i+1,plans[i].getName(),plans[i].getPlanPrice());
    //     }
    //     int selectPlan=0;
    //     while(selectPlan<1 || selectPlan>plans.length){
    //         System.out.println("Choose Plan:");
    //         selectPlan=input.nextInt();
    //     }
    //     // create object 
    //     Member member = new Member(name, genderType, age, phoneNumber);
    //     Membership membership = new Membership(member, plans[selectPlan-1]);

    //     input.nextLine();   
    //     return membership;
    // }



 

    // search membr by given ID 
    /**
     * @param id the given ID e.g. MEM-1
     * @return member if found otherwise null 
     */
    @Override
    public Member searchById(String id) {
       if(memberList.isEmpty()){
        System.out.println("Member list is empty!");
        return null; 
       }
       for( Member mem:memberList){
        if(mem.getID().equalsIgnoreCase(id.trim())){
            return mem;
        }
       }
    return null; 
    }

    /**
     *list all member and membership by storing data in array list of displayable 
    */
    public void listAll() {
        ArrayList<Displayable> displayAll= new ArrayList<>();
        displayAll.addAll(memberList);
        for( Displayable d : displayAll){
            d.displayInfo();
        }

    }
    // /**
    //  * display all member 
    //  */
    // public void listAllMember() {
    //     if (memberList.isEmpty()) {
    //         System.out.println("No members found.");
    //         return;
    //     }
    //     System.out.println("====== ALL MEMBERS ======");
    //     for (Member m : memberList)
    //         System.out.println(m);
    // }

    // /**
    //  * display all membership
    
    // */
    // public void listAllMembership(){
    //     if(membershipList.isEmpty()){
    //         System.out.println("The array list is empty!");
    //         return;
    //     }
    //     System.out.println("\nAll Membership");
    //     for(Membership memberships: membershipList){
    //         System.out.println(memberships);
    //     }
    // }
}
