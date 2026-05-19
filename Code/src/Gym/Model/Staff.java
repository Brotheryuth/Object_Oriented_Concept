package Gym.Model;

import Gym.Enum.Gender;

import java.time.LocalDate;

import Gym.Base.Person;

public class Staff extends Person  {
    private static int count = 0;
    private LocalDate hirDate;
    private Double salary;

    // constructor
    public Staff(String name, int age, Gender gender, String phoneNumber,Double salary) {
        super(name, age, gender, phoneNumber);
        super.ID = "ST" + (++count);
        this.setSalary(salary);
        this.hirDate=LocalDate.now();
    }

    // accessor

    public Double getSalary() {
        return this.salary;
    }

    public String getID() {
        return ID;
    }

    public LocalDate getHirDate(){
        return hirDate;
    }

    protected void setSalary(Double salary) {
        if (salary > 0)
            this.salary = salary;
        else
            this.salary = 0.0;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public void setGender(Gender gender) {
        super.setGender(gender);
    }



    // display information 
    @Override
    public void displayInfo() {
        System.out.println(this.toString()); // use this output
    }

    @Override
    public String toString() {
        return String.format("""
                ----------------------------------
                        STAFF INFORMATION
                ----------------------------------
                ID              : %s
                Name            : %s
                Age             : %d
                Gender          : %s
                Phone Number    : %s
                Salary          : $%.2f
                ----------------------------------
                """, this.ID,
                super.getName(),
                super.getAge(),
                super.getGender(),
                super.getPhoneNumber(),
                this.salary);
    }
}
