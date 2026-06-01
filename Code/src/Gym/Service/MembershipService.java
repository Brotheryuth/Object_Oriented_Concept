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
    private MemberService memberService;

        private final MembershipPlan[] plans = {
            new MembershipPlan("Basic", 19.99, 1),
            new MembershipPlan("Premium", 29.99, 3),
            new MembershipPlan("Silver", 39.99, 6),
            new MembershipPlan("Annual", 59.99, 12)
    };

    public MembershipService(MemberService memberService) {
        this.membershipsList = new ArrayList<>();
        this.memberService=memberService;


    }

    public Membership createMembership(Member member, MembershipPlan plan ){
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
    public Membership createMembership(Member member , MembershipPlan plan, LocalDateTime startDate ){
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
    
    /**
     * Create membership by using memmberID since it useful since if member already exist and we wanna input via console 
     * @param memberId
     * @param planId
     * @return
     */
    public Membership createMembership(String memberId, String planId) {
        // find member first
        Member member = memberService.searchById(memberId);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
            return null;
        }

        MembershipPlan selectedPlan = null;

        for (MembershipPlan plan : plans) {
            if (plan.getPlan_ID().equalsIgnoreCase(planId)) {
                selectedPlan = plan;
                break;
            }
        }
        if (selectedPlan == null) {
            System.out.println("Plan not found: " + planId);
            return null;
        }
        // calling main method
        return createMembership(member, selectedPlan);
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
    /**
     * Search membership by 
     * @param member
     * @return
     */
    public Membership searchByMember(Member member){
        if(member==null){
            System.out.println("Member Cannot be null");
            return null;
        }
        for (Membership membership : membershipsList) {
            if(membership.getMember().getID().equals(member.getID())) // compare ID with ID which i think more accurate than pure object
                {
                System.out.println("Search Found");
                return membership;
            }
        } // end forloop 
        System.out.println("No Member is Found!");
        return null;

    }

    @Override
    public void displayInfo() {
        System.out.printf("There are %s in the list",membershipsList.size());
    }

    /**
     * Allow other class to use plan 
     * @return matched plan 
     */
    public MembershipPlan[] getPlans(){
        return plans;
    }
}
