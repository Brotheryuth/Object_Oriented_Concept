package Gym.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Interface.Displayable;
import Gym.Interface.Searchable;

public class MembershipService implements Displayable, Searchable<Membership> {
    private ArrayList<Membership> memberships;
    public MembershipService(){
        this.memberships = new  ArrayList<>();
        
    }
     public Membership createMembership(Member member, MembershipPlan plan){
        if (member == null){
            System.out.println("Cannot create membership without a member.");
            return null;
        }

        if (plan == null){
            System.out.println("Cannot create membership without a plan. ");
            return null;
        }

        Membership newMembership = new Membership(member, plan);
        

       
        return newMembership;
     }
     // display all member
      public void displayAllMemberships() {
        System.out.println("\n========== All Memberships ==========");

        if (memberships.isEmpty()) {
            System.out.println("No membership records yet.");
            return;
        }

        for (Membership membership : memberships) {
            membership.displayInfo();
        }
    }

     @Override
     public Membership searchById(String membehipId) {
         if (membehipId == null){
            return null;
         }
         for (Membership membership : memberships){
            
        if (membership.getMembershipId().equalsIgnoreCase(membehipId.trim())){
             return membership;
             } 
            }
            return null;

         }
         @Override
         public void displayInfo() {
             // TODO Auto-generated method stub
             
         }
     }



