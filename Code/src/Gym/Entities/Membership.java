package Gym.Entities;
import java.time.LocalDateTime;

import Gym.Enum.MemberStatus;
import Gym.Model.Member;


public class Membership {
  private static int count=0;
  private String membershipId;
  private Member member;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private MemberStatus status;
  private
  plan;
  // constructor
  public Membership(Member member, MembershipPlan plan) {
    this.membershipId ="SUB-"+(++count);
    // this.member = member;
    this.member =member;
    this.plan=plan;
    this.startDate = LocalDateTime.now();
    this.endDate = LocalDateTime.now().plusMonths(plan.getDuration());
    this.status = MemberStatus.ACTIVE;
  }

  // Getters and Setters

  public String getSubcriptionID(){ return this.membershipId;}
  public LocalDateTime getStartDate() {
    return startDate;
  }
  public LocalDateTime getEnDate(){
    return endDate;
  }
  public MembershipPlan getPlan(){
    return plan;
  }
  public Member getMember(){
    return member;
  }

  public MemberStatus getStatus() {
    return status;
  }
 @Override
public String toString() {
    return String.format("""
            ----------------------------------
                    MEMBERSHIP INFO
            ----------------------------------
            Membership ID   : %s
            Member ID       : %s
            Member Name     : %s
            Plan Name       : %s
            Start Date      : %s
            End Date        : %s
            Status          : %s
            ----------------------------------
            """, membershipId, this.member.getID(),this.member.getName(), plan.getName(),startDate, endDate, status);
}

}
