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
        super(name, 20, Gender.OTHER, "0987654321");
        this.setPassword(password);
    }

    // accessor

    public Double getSalary() {
        return this.salary;
    }

    
    public LocalDate getHirDate(){
        return hirDate;
    }
    
    public String getID() {
        return ID;
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


    @Override
    public boolean equals(Object obj) {
        Staff other = (Staff) obj;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
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
                %s
                Salary          : $%.2f
                ----------------------------------
                """,
                super.toString().stripTrailing(),
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
