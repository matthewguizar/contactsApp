package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;
    

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone number cannot be null or blank");
        }
        if (phoneNumber.length() < 5){
            throw new IllegalArgumentException("phone number can't be less than 5 characters");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = toAge(birthDate);
      
    }
    public Contact(Contact source){
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }
    public String getName() {
    
        return name;
    }
    public String getPhoneNumber() {
       
        return phoneNumber;
    }
    public String getBirthDate() {
        
        return birthDate;
    }
    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("null or blank");
        }
        this.name = name;
    }
    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(toAge(birthDate));
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()){
            throw new IllegalArgumentException("phone is blank");
        }
        if (phoneNumber.length() < 5){
            throw new IllegalArgumentException("not enough digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public int toAge(String birthDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        Date toDate = formatter.parse(birthDate); //convert String to Date
        long toMilliSeconds = toDate.getTime(); //converts date to milliseconds since 1970
        long diff = new Date().getTime() - toMilliSeconds; //age in milliseconds
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365); //gets age
    
    }

    
    public String toString() {
        return "Name: " + name + "\n" +
        "Phone number: " + phoneNumber + "\n" +
        "Birth Date: " + birthDate + "\n" +
        "Age: " + age + " year old\n";
    }
}
