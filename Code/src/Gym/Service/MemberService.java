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
    /**
     * Another way to create member when we want quick login. we would use it when we dont want much information from customer 
     * @param name
     * @param phoneNumber
     * @return
     */
    public Member createMember(String name, String phoneNumber){
        Member newMember = new Member(name, null, 0, phoneNumber);
        memberList.add(newMember);
        return newMember;
    }



 

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
    public void displayAllMember() {
        ArrayList<Displayable> displayAll= new ArrayList<>();
        displayAll.addAll(memberList);
        for( Displayable d : displayAll){
            d.displayInfo();
        }

    }
    
}
