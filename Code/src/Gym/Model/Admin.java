package Gym.Model;

import Gym.Enum.Gender;

public class Admin extends Staff {
  private static int count =0;
  public Admin(String name, int age, Gender gender, String phoneNumber, double salary) {
    super(name, age, gender, phoneNumber,salary);
    super.ID = "ADMIN-" + (++count);
  }

  public void setSalary(double salary){
    super.setSalary(salary);
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