package Gym.Model;

import Gym.Enum.Gender;
import Gym.Interface.Role;

import java.time.LocalDate;

import Gym.Base.Person;

public class Staff extends Person implements Role  {
    private static int count = 0;
    private LocalDate hirDate;
    private Double salary;
    private String password;

    /**
     * create staff constructor
     * @param name
     * @param age
     * @param gender
     * @param phoneNumber
     * @param salary
     * @param password
     */ 
    public Staff(String name, int age, Gender gender, String phoneNumber,Double salary, String password ) {
        super(name, age, gender, phoneNumber);
        super.ID = "ST" + (++count);
        this.setSalary(salary);
        this.setPassword(password);
        this.hirDate=LocalDate.now();
    }

    /**
     * LOgin 
     * @param name
     * @param password
     */
   
    public Staff(String name, String password){
        super(name, 0, null, "");
        this.setPassword(password);
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

    public void setPassword(String password){
        if (password.isBlank()|| password.isEmpty()) {
            System.out.println("Password is Null. set to 87654321 as default");
            this.password="87654321";
            return;
        }
        this.password=password;
    }

    public String getPassword(){
        return password;
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
    /**
     * Authenticated 
     */
    @Override
    public boolean can(String action) {
        return false;
    }
}
