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
    protected void setName(String name){
        if( name==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannont be empty");
        }
        this.name=name;
    } // (Staff newStaff) (String name)
    protected  void  setGender(Gender gender){
        if( gender ==null ){
            throw new IllegalArgumentException("Invalid gender.");
        }
        this.gender=gender;

    }
    protected void setAge(int age){
        if (age<5 || age>100){
            throw new IllegalArgumentException("Age must between 5 and 100");
        }
        this.age=age;
    }
    protected  void setPhoneNumber(String phoneNumber){
        if (phoneNumber==null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null");
        }
        this.phoneNumber=phoneNumber;
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
