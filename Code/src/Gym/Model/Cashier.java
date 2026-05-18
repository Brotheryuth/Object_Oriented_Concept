package Gym.Model;

import Gym.Enum.Gender;

public class Cashier extends Staff {
    private static int count = 0;
    private String shift; // Morning, Afternoon, Night

    // Constructor
    public Cashier(String name, int age, Gender gender,
                   String phoneNumber, Double salary, String shift) {

        super(name, age, gender, phoneNumber, "Cashier", salary);

        super.ID = "CA" + (++count);

        this.setShift(shift);
    }

    // Getter
    public String getShift() {
        return shift;
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
                ID              : %s
                Name            : %s
                Age             : %d
                Gender          : %s
                Phone Number    : %s
                Role            : %s
                Salary          : $%.2f
                Shift           : %s
                ----------------------------------
                """,
                this.ID,
                getName(),
                getAge(),
                getGender(),
                getPhoneNumber(),
                getRole(),
                getSalary(),
                this.shift
        );
    }
}