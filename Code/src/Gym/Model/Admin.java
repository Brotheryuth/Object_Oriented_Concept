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
      work(action);
      return true;
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
        %s
        Role            : Admin
        Salary          : %s
        Hire Date       : %s
        ----------------------------------
        %n""",
        super.toString().stripTrailing(),
        super.getSalary(),
        super.getHirDate());
  }

  @Override
  public void work(String Action) {
    System.out.printf("Admin is Working on %s\n",Action );
  }

}