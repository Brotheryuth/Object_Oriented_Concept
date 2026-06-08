package Gym.Base;

import java.util.regex.Pattern;

import Gym.Enum.Gender;
import Gym.Interface.Displayable;

public  class Person implements Displayable{
    protected String name;
    protected Gender gender;
    protected int age;
    protected String phoneNumber;
    private static int count=0;
    private static final Pattern  PHONE_PATTERN = Pattern.compile("^\\+?[0-9\\s\\-\\(\\)]{7,15}$");
    protected   String ID;

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
        if (name == null || name.isBlank() || name.trim().isEmpty()) {
            System.out.println("Invalid name. Setting default name: 'Unknown'");
            this.name = "Unknown "+count;
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
        if(phoneNumber ==null){
            this.phoneNumber = "N/A";
            return; 
        }
        String cleanPhone = phoneNumber.trim();
        // check if phone number incldue invalid charate (e.g. !@#%^&(*)) set it to N/A
        if(!PHONE_PATTERN.matcher(cleanPhone).matches()){
            this.phoneNumber ="N/A";
            return;
        }
        this.phoneNumber=cleanPhone;
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
    public void displayInfo() {
        System.out.println(this.toString());
        
    }
    @Override
    public String toString() {
        return String.format(
                """
                ID              : %s
                Name            : %s
                Age             : %d
                Gender          : %s
                Phone Number    : %s
                """,
                this.ID,getName(), getAge(), getGender(), getPhoneNumber()
        );
    }


}
