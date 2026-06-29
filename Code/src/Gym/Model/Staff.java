package Gym.Model;

import Gym.Enum.Gender;
import Gym.Interface.Role;

import java.time.LocalDate;

import Gym.Base.Person;

public abstract class Staff extends Person implements Role  {
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
        if (salary !=null && salary > 0)
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
        if (password==null|| password.isBlank()|| password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is Null.");
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
                %s
                Salary          : $%.2f
                Hire Date       : %s
                """,
                super.toString().stripTrailing(),
                this.salary,this.hirDate
            );
    }
    /**
     * Authenticated 
     */
    @Override
    public boolean can(String action) {
        return false;
    }
    /**
     * an abstract method for work . different staff work differently 
     */
    public abstract void work(String Action);
}
