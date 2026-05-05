package Gym.Base;

import Gym.Enum.Gender;

public abstract class Person {
    protected String name;
    protected Gender gender;
    protected int age;
    protected String phoneNumber;
    private static int count=0;
    protected  String ID;

    //constructor
    public Person(String name, int age, Gender gender, String phoneNumber){
        this.ID = "P-"+(++count);
        this.setName(name);
        this.setGender(gender);
        this.setPhoneNumber(phoneNumber);
        this.setAge(age);
    }
    //setter
    protected void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Invalid name. Setting default name: 'Unknown'");
            this.name = "Unknown";
            return;
        }
        this.name = name;
    }

    protected void setGender(Gender gender) {
        if (gender == null) {
            System.out.println("Invalid gender. Setting default: MALE");
            this.gender = Gender.MALE;
            return;
        }
        this.gender = gender;
    }

    protected void setAge(int age) {
        if (age < 5 || age > 100) {
            System.out.println("Invalid age. Setting default: 18");
            this.age = 18;
            return;
        }
        this.age = age;
    }

    protected void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            System.out.println("Invalid phone number. Setting default: 'N/A'");
            this.phoneNumber = "N/A";
            return;
        }
        this.phoneNumber = phoneNumber;
    }
    //Getter
    public String getName()       { return name; }
    public int getAge()           { return age; }
    public Gender getGender()     { return gender; }
    public String getPhoneNumber(){ return phoneNumber; }
    public String getID(){
        return this.ID;
    }
    @Override
    public String toString() {
        return String.format(
                """
                Name            :%s
                Age             :%d
                Gender          :%s
                Phone Number    :%s
                """,
                getName(), getAge(), getGender(), getPhoneNumber()
        );
    }


}
