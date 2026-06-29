package Gym.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Gym.Enum.MemberStatus;
import Gym.Enum.MembershipStatus;
import Gym.Interface.Displayable;
import Gym.Model.Member;
import Gym.Interface.StatusManageable;

public class Membership implements Displayable, StatusManageable {
  private static int count = 0;
  private String membershipId;
  private Member member;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private MembershipStatus status;
  private MembershipPlan plan;

  private static final DateTimeFormatter cleanDate = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");

  // constructor
  public Membership(Member member, MembershipPlan plan) {
    this.membershipId = "SUB-" + (++count);
    // this.member = member;
    this.member = member;
    this.plan = plan;
    this.startDate = LocalDateTime.now();
    this.endDate = LocalDateTime.now().plusMonths(plan.getDuration());
    this.status = MembershipStatus.PENDING;
  }

  /**
   * activate the membership
   */
  public boolean activate() {
    if (member == null) {
     throw new IllegalArgumentException("Membership cannot be activated with a member.");
    }
    if (plan == null) {
     throw new IllegalArgumentException("Membership cannot be activated without a plan.");
    }
    status = MembershipStatus.ACTIVE;
    member.setMemberStatus(MemberStatus.ACTIVE);
    return true;

  }

  // Getters and Setters

  public String getSubcriptionID() {
    return this.membershipId;
  }

  public String getMembershipId() {
    return membershipId;
  }

  public void setStatus(MembershipStatus status) {
    this.status = status;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public LocalDateTime getEnDate() {
    return endDate;
  }

  public MembershipPlan getPlan() {
    return plan;
  }

  /**
   * formate date to look like this 06/12/2026 10:10
   * 
   * @param formatDate
   * @return
   */
  public String cleanDateFormat(LocalDateTime formatDate) {
    if (formatDate != null) {
      return formatDate.format(cleanDate);
    }
    return null;
  }

  public Member getMember() {
    return member;
  }

  // return membership status
  public MembershipStatus getMembershipStatus() {
    return this.status;
  }

  public void setStartDate(LocalDateTime startDate) {
    if (startDate == null) {
      this.startDate = LocalDateTime.now();
    }
    this.startDate = startDate;
    this.endDate = startDate.plusMonths(plan.getDuration());
  }

  @Override
  public String getStatus() {
    return status.toString();
  }

  @Override
  public boolean updateStatus(String statusText) {
    if (statusText == null || statusText.trim().isEmpty()) {
      throw new IllegalArgumentException("Membership status cannot be empty.");
    }
    //
    try {
      MembershipStatus newStatus = MembershipStatus.valueOf(statusText.trim().toUpperCase());
      this.status = newStatus;

      if (member != null && newStatus == MembershipStatus.ACTIVE) {
        member.setMemberStatus(MemberStatus.ACTIVE);
      }
      return true;
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid membership status: " + statusText);
    }

  }

  /**
   * just get the plan price
   */
  public double calculateFee() {
    if (plan == null) {
      return 0;
    }
    return plan.getPlanPrice();
  }

  @Override
  public void displayInfo() {
    System.out.println(this.toString());
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
        Plan Price      : $%s
        Start Date      : %s
        End Date        : %s
        Status          : %s
        ----------------------------------
        """, membershipId, this.member.getID(), this.member.getName(), plan.getName(), plan.getPlanPrice(),
        cleanDateFormat(startDate),
        cleanDateFormat(endDate), status);
  }

}
