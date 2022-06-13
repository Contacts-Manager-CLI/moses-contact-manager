import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class controller {


    public static int mainMenu(){

        System.out.println("1. See contacts.");
        System.out.println("2. Create new contact.");
        System.out.println("3. Search a contact. ");
        System.out.println("4. Delete contact.");
        System.out.println("5. Return.");
        System.out.println("Enter an option (1, 2, 3, 4 or 5):");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        System.out.println();

        return userInput;

    }

    public static void viewList() {
        System.out.println("Name | Phone Number");
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist = null;
        try{
            Personlist = Files.readAllLines(ContactsPath);
        } catch (IOException e){
            e.printStackTrace();
        }
        for(int i = 0; i < Personlist.size(); i += 1){
            System.out.println((i + 1) + ": " + Personlist.get(i));
        }
        System.out.println();
    }

    public static void addContact() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("2. Create new contact.");
        System.out.println("Enter First name of contact.");
        String firstName = sc.nextLine();
        System.out.println("Enter Last name of contact.");
        String lastName = sc.nextLine();
        System.out.println("Enter phone number of contact.");
        String phoneNumber = sc.nextLine();
        Files.write(Paths.get("data", "contacts.txt"),
                Arrays.asList(firstName + " " + lastName + " | " + phoneNumber),
                StandardOpenOption.APPEND);
        //System.out.println(firstName + " " + lastName + " | " + phoneNumber);
        viewList();
    }

    public static void searchContact() {
        System.out.println("3. Search a contact by first of last name.");
        System.out.println("Enter contacts First or Last name.");
        Scanner sc = new Scanner(System.in);
        String searchedName = sc.nextLine();
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist;
        try{
            Personlist = Files.readAllLines(ContactsPath);
            for (String person : Personlist){
                if(person.toLowerCase().contains(searchedName.toLowerCase())){
                    System.out.println("Contact: \n" + person);
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println();
    }

    public static void deleteContact() {
        System.out.println("4. Delete contact.");
        System.out.println("Search by Name or Phone Number: ");
        Scanner sc = new Scanner(System.in);
        String deleteName = sc.nextLine();
        System.out.println("Name | Phone Number");
        Path ContactsPath = Paths.get("data", "contacts.txt");
        List<String> Personlist;
        try {
            Personlist = Files.readAllLines(ContactsPath);
            List<String> newList = new ArrayList<>();
            for (String person : Personlist) {
                if (person.toLowerCase().contains(deleteName)) {
                    continue;
                }
                newList.add(person);
            }
            for (String name : newList) {
                System.out.println(name);
            }

            Files.write(Paths.get("data", "contacts.txt"), newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();

    }

    public static void exit() {
        System.out.println("Have a great day!");
        System.exit(0);
    }
}
//public class Contacts_Manager {
//
//    private String fullName;
//    private int contactNumber;
//
//    public Contacts_Manager(String fullName, int contactNumber) {
//        this.fullName = fullName;
//        this.contactNumber = contactNumber;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public int getContactNumber() {
//        return contactNumber;
//
//    }
//
//    public void setContactNumber(int contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public static void viewContacts() throws IOException {
//
//        String directory = "./src/contacts.txt";
//
//        String contacts = "contact.info.txt";
//
//        Path dataDirectory = Paths.get(directory);
//
//        Path contactFile = Paths.get(directory, contacts);
//
//
//        if (Files.notExists(dataDirectory)) {
//
//            try {
//                Files.createDirectories(dataDirectory);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        if (!Files.exists(contactFile)) {
//            try {
//                Files.createFile(contactFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        List<String> printContacts = Files.readAllLines(contactFile);
//
//        for (int i = 0; i < printContacts.size(); i++) {
//
//            System.out.println((i + 1) + ". " + printContacts.get(i));
//
//
//        }
//    }
//
//    public static void addContact() throws IOException {
//
//        Scanner sc = new Scanner(System.in);
//
//        String directory = "./src/contacts.txt";
//
//        String contacts = "contact.info.txt";
//        Path contactFile = Paths.get(directory, contacts);
//        System.out.println("Enter first and last name of contact");
//        String userInput = sc.nextLine();
//        System.out.println("Enter contact number");
//        int userInputNum = sc.nextInt();
//
//        Contacts_Manager contact1 = new Contacts_Manager(userInput, userInputNum);
////        System.out.println("Enter contact number");
//
//        try {
//            Path write = Files.write(contactFile, Arrays.asList(contact1.fullName), StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void findEntry() {
//
//        Scanner scan = new Scanner(System.in);
//
//        String search;
//
//        String directory = "./src/contacts.txt";
//
//        String contacts = "contact.info.txt";
//
//        Path contactFile = Paths.get(directory, contacts);
//
//        System.out.print("Who would you like to search for: ");
//        search = scan.nextLine();
//
//        List<String> printContacts = Collections.singletonList(search);
//        try {
//            printContacts = Files.readAllLines(contactFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (String printContact : printContacts) {
//
//            if (search.equals(printContact)) {
//
//                System.out.print(printContact);
//
//            }
//        }
//    }

