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

        super.ID = "CA" + (++count);

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
            Role            : %s
            Salary          : $%.2f
            Shift           : %s
            Gender          : %s
            Phone Number    : %s
            Hire Date       : %s
            ----------------------------------
            """,
            "Cashier",
            super.getSalary(),
            this.shift,
            super.getGender(),
            super.getPhoneNumber(),
            super.getHirDate()
        );

    }
    
}