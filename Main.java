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
            manageContacts();
         }catch (FileNotFoundException e ){
            System.out.println(e.getMessage());
        }
    }

    public static void manageContacts() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Would you like to \n\ta) add another contact\n\tb) remove a contact \n\tc) exit");
           String response = scan.nextLine();
           if(response.equalsIgnoreCase("a")) {
                System.out.print("\tName: ");
                String name = scan.nextLine();
                System.out.print("\tPhone Number: ");
                String phoneNumber = scan.nextLine();
                System.out.println("\tBirth date: ");
                String birthDate = scan.nextLine();
                if (name.isBlank() || phoneNumber.isBlank() || phoneNumber.length() < 5) {
                    System.out.println("Not valid. Registration Failed.");

                } else {
                try {
                    manager.addContact(new Contact(name, phoneNumber, birthDate));
                } catch (ParseException e) {
                   
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("\n\nUpdated Contacts\n\n" + manager);
                }
             }
           } else if(response.equalsIgnoreCase("b")) {
               System.out.println("\nWho would you like to remove?");
               manager.removeContact(scan.nextLine());
               System.out.println("\n\nUpdated Contacts\n\n" + manager); 
           } else {
                break;
           }
        }
        scan.close();
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
