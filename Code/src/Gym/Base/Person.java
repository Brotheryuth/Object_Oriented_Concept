package Gym.Base;

import Gym.Enum.Gender;
import Gym.Interface.Displayable;

public  class Person implements Displayable{
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

    /**
     * set phone number by using clean text
     */
    protected void setPhoneNumber(String phoneNumber) {
            phoneNumber=cleanText(phoneNumber, "N/A");
    }
    //Getter
    public String getName()       { return name; }
    public int getAge()           { return age; }
    public Gender getGender()     { return gender; }
    public String getPhoneNumber(){ return phoneNumber; }
    public String getID(){
        return this.ID;
    }
    /**
     * @param value a string text that we want to set
     * @param defaultValue set to default value if it's null 
     */
    protected String cleanText(String value, String defaultValue){
        if (value==null || value.trim().isEmpty()){
            return defaultValue;
        }
        return value.trim();
    }

    @Override
    public void displayInfo() {
        System.out.println(this.toString());
        
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
