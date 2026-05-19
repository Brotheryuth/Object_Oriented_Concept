package Gym.Enum;

/**
 * MembershipStatus stores the lifecycle status of one membership/subscription record
 */
public enum MembershipStatus {
    ACTIVE,PENDING, EXPIRED, CANCELLED

}

/**
 * @ PENDING = membership created but not paid yet*
 * ACTIVE = payment completed and membership is active
 * EXPIRED = membership period ended
 * CANCELLED = membership was cancelled
This status belongs in Membership, not in MembershipPlan, because each member’s subscription has its own lifecycle.
*/