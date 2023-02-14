package Controller;


import Model.Contacts;
import Service.AddressBookImp;

import java.util.LinkedList;
import java.util.Scanner;


public class AddressBookMain
{
    public static void main(String[] args)
    {

        //  Linkedlist <Contacts>linkedList = new Linkedlist<>();
        LinkedList <Contacts> linkedList = new LinkedList<>();

        Scanner scann = new Scanner(System.in);
        int choice=1;

        while(choice!=0) ///
        {
            AddressBookImp addressBookImp = new AddressBookImp();


            addressBookImp.showCondition();


            choice = scann.nextInt();

            // String poss;
            switch(choice)
            {
                case 1 :
                    addressBookImp.insertContacts();
                    //insertInfo.insertData(firstName,lastName,address,city,state,email,zip,phoneNumber);
                    break;
                case 2:
                    addressBookImp.showAllContacts();
                break;
                case 3:
                    addressBookImp.editContactByName();
                break;
                case 4:
                   addressBookImp.removeContactByName();
                break;
                case 5:
                    addressBookImp.searchPersonBystateOrCity();
                break;
                case 9:
                    choice=0;
                break;
            }

        }

    }

}
