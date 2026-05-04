package Gym.Entities;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Gym.Enum.MemberStatus;
import Gym.Model.Members;


public class Membership {
  private static int count=0;
  private String membershipId;
  private Members members;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private MemberStatus status;
  private MembershipPlan plan;
  // constructor
  public Membership(Members member, MembershipPlan plan) {
    this.membershipId ="SUB-"+(++count);
    // this.member = member;
    this.members=member;
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
  public Members getMember(){
    return members;
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
            """, membershipId, this.members.getID(),this.members.getName(), plan.getName(),startDate, endDate, status);
}

}
