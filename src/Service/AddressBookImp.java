package Service;
import Interface.iAddressBook;
import Model.Contacts;
import Utility.RegexUtil;

import java.util.LinkedList;
import java.util.Scanner;


public class AddressBookImp extends AddressBookEdit implements iAddressBook
{
   private static LinkedList<Contacts> linkedList = new LinkedList<>();
   private Scanner SCANNER = new Scanner(System.in);
    public void showCondition()
    {
        System.out.println();
        System.out.println("Enetr your choice");
        System.out.println("1 : Insert the Contacts");
        System.out.println("2 : Display all address in contact book");
        System.out.println("3 : Edit existing contact person using their name");
        System.out.println("4 : Delete existing contact person using their name");
        System.out.println("9 : Terminate the application");
    }
    public void insertContacts()
    {

        AddressBookImp addressBookImp = new AddressBookImp();
        RegexUtil regexUtil = new RegexUtil();
        Contacts contacts = new Contacts();
        System.out.println("Enter the first name");
        contacts.setFirstName(SCANNER.next());

        System.out.println("Enter the last name");
        contacts.setLastnames(SCANNER.next());

        System.out.println("Enter the address");
        contacts.setAddress(SCANNER.next());

        System.out.println("Enter the city");
        contacts.setCity(SCANNER.next());

        System.out.println("Enter the state");
        contacts.setState(SCANNER.next());


        System.out.println("Enter the email");
        contacts.setEmail(SCANNER.next());

        System.out.println("Enter the zip");
        contacts.setZip(SCANNER.nextInt());

        System.out.println("Enter the phone number");
        contacts.setPhoneNumber(SCANNER.nextLong());

        if(regexUtil.isStartWithCapitalLatter(contacts.getFirstName()))
        {
            if(findDuplication(contacts.getFirstName()))
            {

                if(regexUtil.isCheckEmailId(contacts.getEmail()))
                {
                    String mobileNumber = contacts.getPhoneNumber()+"";
                    if(regexUtil.isCheckMobileNumber(mobileNumber))
                    {

                        linkedList.add(contacts);
                        System.out.println();
                        System.out.println("-------------------------------------------");
                        System.out.println("Contact Added Succesfully in Address Book");
                        System.out.println("-------------------------------------------");

                    }
                }
            }
            else
            {
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("First name information allready exist");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            }

        }


    }
    private static boolean findDuplication(String input)
    {

        for(int i=0; i<linkedList.size();i++)
        {
            if((linkedList.get(i).getFirstName()).equals(input))
            {
                return false;
            }
        }
        return true;
    }

    public void showAllContacts()
    {
        for(int counter=0; counter<linkedList.size(); counter++)
        {


            System.out.println("-- Display "+(counter+1)+" Person in Address Book----------");
            System.out.println(" First name :"+linkedList.get(counter).getFirstName());
            System.out.println(" Last name  :"+linkedList.get(counter).getLastnames());
            System.out.println(" Address    :"+linkedList.get(counter).getAddress());
            System.out.println(" City       :"+linkedList.get(counter).getCity());
            System.out.println(" State      :"+linkedList.get(counter).getState());
            System.out.println(" Email ID   :"+linkedList.get(counter).getEmail());
            System.out.println(" Zip        :"+linkedList.get(counter).getZip());
            System.out.println(" Phone No   :"+linkedList.get(counter).getPhoneNumber());
        }
    }
    public  void editContactByName()
    {
        System.out.println("Enter the first name that you want to edit in address book");
        String checkName = SCANNER.next();
        for(int counter=0; counter<linkedList.size(); counter++)
        {

            if((linkedList.get(counter).getFirstName()).equals(checkName))
            {
                System.out.println("Enter the first name");
                linkedList.get(counter).setFirstName(SCANNER.next());

                System.out.println("Enter the last name");
                linkedList.get(counter).setLastnames(SCANNER.next());

                System.out.println("Enter the address");
                linkedList.get(counter).setAddress(SCANNER.next());

                System.out.println("Enter the city");
                linkedList.get(counter).setCity(SCANNER.next());

                System.out.println("Enter the state");
                linkedList.get(counter).setState(SCANNER.next());


                System.out.println("Enter the email");
                linkedList.get(counter).setEmail(SCANNER.next());

                System.out.println("Enter the zip");
                linkedList.get(counter).setZip(SCANNER.nextInt());

                System.out.println("Enter the phone number");
                linkedList.get(counter).setPhoneNumber(SCANNER.nextLong());
            }

        }
    }
    public  void removeContactByName()
    {
        System.out.println("Enter the first name that you want to delete contact in address book");
        String checkNameForDelete = SCANNER.next();
        for(int counter=0; counter<linkedList.size(); counter++)
        {

            if((linkedList.get(counter).getFirstName()).equals(checkNameForDelete))
            {
                linkedList.remove(counter);
                System.out.println();
                System.out.println("Delete contact Successful");
            }

        }
    }

}
