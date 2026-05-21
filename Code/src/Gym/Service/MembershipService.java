package Gym.Service;


import java.util.ArrayList;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Interface.Displayable;
import Gym.Interface.Searchable;
import Gym.Model.Member;

public class MembershipService implements Displayable, Searchable<Membership> {
    private ArrayList<Membership> membershipsList;

    public MembershipService() {
        this.membershipsList = new ArrayList<>();

    }
    public Membership creatMembership(Member member, MembershipPlan plan ){
        if( member ==null){
            System.out.println("Cannot create membership without a Member.");
            return null;
        }
        if(plan==null){
            System.out.println("Cannot crearte membership without a plan");
            return null;
        }
        Membership tempMembership = new Membership(member, plan);
        membershipsList.add(tempMembership);  // added to list 
        member.addMembership(tempMembership);

        return tempMembership;
    }

    // display all member
    public void displayAllMemberships() {
        System.out.println("\n========== All Memberships ==========");

        if (membershipsList.isEmpty()) {
            System.out.println("No membership records yet.");
            return;
        }

        for (Membership membership : membershipsList) {
            membership.displayInfo();
        }
    }

    @Override
    public Membership searchById(String membehipId) {
        if (membehipId == null) {
            return null;
        }
        for (Membership membership : membershipsList) {

            if (membership.getMembershipId().equalsIgnoreCase(membehipId.trim())) {
                return membership;
            }
        }
        return null;

    }

    @Override
    public void displayInfo() {
        System.out.printf("There are %s in the list",membershipsList.size());
    }
}
