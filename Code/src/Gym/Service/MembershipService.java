package Gym.Service;


import java.time.LocalDateTime;
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
        member.addMembership(tempMembership); // added to membership history list in member 

        return tempMembership;
    }
    /**
     * alternative way to creat membership when user can pick their start time 
     * @param member
     * @param plan
     * @param startDate
     * @return
     */
    public Membership creatMembership(Member member , MembershipPlan plan, LocalDateTime startDate ){
        if(member ==null){
            System.out.println("Cannot create membership without member.");
            return null;
        }
        if( plan == null){
            System.out.println("Cannot create Membership without a plan");
            return null;
        }
        if(startDate.isBefore(LocalDateTime.now())){
            System.out.println("Invalid Start date: Date cannot be in the past");
            return null;
        }
        Membership newMembership = new Membership(member, plan);
        newMembership.setStartDate(startDate);
        membershipsList.add(newMembership);
        return newMembership;
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
        System.out.println("Search Membership with the ID : "+membehipId);
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
