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
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        Date toDate = formatter.parse(birthDate); //convert String to Date
        long toMilliSeconds = toDate.getTime(); //converts date to milliseconds since 1970
        long diff = new Date().getTime() - toMilliSeconds; //age in milliseconds
        this.age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365); //gets age
    }
}
