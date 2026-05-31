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

    public Membership creatMembership(Member member, MembershipPlan plan) {
        if (member == null) {
            System.out.println("Cannot create membership without a Member.");
            return null;
        }

        if (plan == null) {
            System.out.println("Cannot create membership without a plan.");
            return null;
        }

        Membership tempMembership = new Membership(member, plan);
        membershipsList.add(tempMembership);
        member.addMembership(tempMembership);

        return tempMembership;
    }

    // NEW METHOD
    public Membership createMembership(String memberId, String planId,
            MemberService memberService,
            ArrayList<MembershipPlan> plans) {

        // Find member
        Member member = memberService.searchById(memberId);
        if (member == null) {
            System.out.println("Member not found: " + memberId);
            return null;
        }

        // Find plan
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

        return creatMembership(member, selectedPlan);
    }

    // display all memberships
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
    public Membership searchById(String membershipId) {
        if (membershipId == null) {
            return null;
        }

        for (Membership membership : membershipsList) {
            if (membership.getMembershipId().equalsIgnoreCase(membershipId.trim())) {
                return membership;
            }
        }

        return null;
    }

    @Override
    public void displayInfo() {
        System.out.printf("There are %s in the list", membershipsList.size());
    }
}