package Gym.Model;

import Gym.Enum.Gender;
import Gym.Runner.GymManagement;

public class Cashier extends Staff {
    private static int count = 0;
    private String shift; // Morning, Afternoon, Night

    // Constructor
    public Cashier(String name, int age, Gender gender,
                   String phoneNumber, Double salary, String shift, String password) {

        super(name, age, gender, phoneNumber, salary,password);

        super.ID = "CA-" + (++count);

        this.setShift(shift);
    }

    // Login constructor
    public Cashier(String name, String password) {
        super(name, password);
    }

    // Getter
    public String getShift() {
        return shift;
    }

    @Override
    public boolean can(String action) {
        if(action.equals(GymManagement.PROCESS_PAYMENT)){
            work(action);
            return true;
        }
        return false;
    }

    // Setter
    public void setShift(String shift) {
        if (shift == null || shift.isBlank()) {
            System.out.println("Invalid shift! Setting default: Morning");
            this.shift = "Morning";
            return;
        }
        this.shift = shift;
    }

    // Display info
    @Override
    public void displayInfo() {
        System.out.println(this.toString());
    }
    // toString
    @Override
    public String toString() {
        return String.format("""
            ----------------------------------
                  CASHIER INFORMATION
            ----------------------------------
            %s
            Role            : Cashier
            Shift           : %s
            ----------------------------------
            """,
            super.toString().stripTrailing(),
            this.shift
        );

    }

    @Override
    public void work(String Action) {

       System.out.printf("%s Working on %s\n",super.getName(),Action);
        
    }
    
}