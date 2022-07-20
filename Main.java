import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

import models.*;

public class Main {
    static ContactManager manager = new ContactManager();
    public static void main(String[] args) {
   
        try {
            loadContacts("contacts.txt");
            System.out.println("contacts loaded\n\n");
            System.out.println(manager);
         }catch (FileNotFoundException e ){
            System.out.println(e.getMessage());
        }
    }



    public static void loadContacts(String fileName) throws FileNotFoundException{
        FileInputStream file = new FileInputStream(fileName);
        Scanner scanFile = new Scanner(file);
        while (scanFile.hasNextLine()){
            try{
                Contact contact = new Contact(scanFile.next(), scanFile.next(), scanFile.next());
                manager.addContact(contact);
            } catch (ParseException e ) {
                System.out.println(e.getMessage());
            }
        }
        scanFile.close();
    }
}
