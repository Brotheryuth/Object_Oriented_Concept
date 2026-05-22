package Gym.Model;

import Gym.Enum.Gender;

public class Admin extends Staff {
  private static int count =0;
  public Admin(String name, int age, Gender gender, String phoneNumber, double salary, String password) {
    super(name, age, gender, phoneNumber,salary,password);
    super.ID = "ADMIN-" + (++count);
  }

  // Login constructor
  public Admin(String name, String password) {
    super(name, password);
  }

  @Override
  public boolean can(String action) {
      
      return super.can(action);
  }

  @Override
  public void displayInfo() {
    System.out.println(this.toString());
  }

  @Override
  public String toString() {
    return String.format("""
        ----------------------------------
                ADMIN INFORMATION
        ----------------------------------
        ID              : %s
        Name            : %s
        Age             : %d
        Gender          : %s
        Phone Number    : %s
        Role            : Admin
        Salary          : %s
        Hire Date       : %s

        ----------------------------------
        %n""",
        super.getID(),
        super.getName(),
        super.getAge(),
        super.getGender(),
        super.getPhoneNumber(),
        super.getSalary(),
        super.getHirDate());
  }
}