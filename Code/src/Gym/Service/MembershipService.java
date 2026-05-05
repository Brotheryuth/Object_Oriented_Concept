package Gym.Service;

// import java.lang.reflect.Member;
import java.util.ArrayList;

import Gym.Entities.Membership;
import Gym.Entities.MembershipPlan;
import Gym.Model.Member;

public class MembershipService {
    ArrayList<Membership> membershipList= new ArrayList<>();
    public Membership createMembership(Member member, MembershipPlan plan ){
        Membership membership=new Membership(member, plan);
        membershipList.add(membership);
        return membership;
    }

    public Membership findByID(String ID){
        for( Membership ms: membershipList){
            if(ms.getSubcriptionID().equals(ID)) {
                return ms;
            }
        }
        return null;
    }
    public void listAll(){
        if(membershipList.isEmpty()){System.out.println("Membership list is empty!"); 
        return;
        }
        for(Membership ms : membershipList){
            System.out.println(ms);
        }
    }

} // the end of the class 
