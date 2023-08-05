package com.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain extends AddressBook {
	static Map<String,AddressBook> addressMapBook = new HashMap<>();
	public static void addAddressBook(String city) {
		AddressBook addNewBook = new AddressBook(city);
		addressMapBook.put(city, addNewBook);
		
	}
	public static void main(String[] args) {
		AddressBook addBook = new AddressBook();
		Scanner input = new Scanner(System.in);
		String check;
				do{	
					System.out.println("Enter the option what you want to execute : 1. AddContact 2. Edit Contact 3. Delete Contact 4. Add an AddressBook "
						        		+ " 5. Display Contacts 6. Exit");
					int perform = input.nextInt();
					switch(perform) {
						case 1:
							addBook.addContactDetails();
							break;
							
						case 2:
							System.out.println("Enter the name of the person you want to edit : ");
							String editName = input.next();
							addBook.editContact(editName);
							break;
							
						case 3:
							System.out.println("Enter the name of the contact you want to delete : ");
							String delName = input.next();
							addBook.deleteContact(delName);
							break;
							
						case 4:
							System.out.println("Enter the name of the city you want to add Address book for: ");
							String city = input.next();
							addAddressBook(city);
							break;
							
						case 5:
							System.out.println("Which contact you want to display ? ");
							String disName = input.next();
							addBook.displayContacts(disName);
							break;
							
						case 6:
							System.out.println("Thank you");
							break;
					}
					System.out.println("Do you want to perform an operation ? Yes/No");
					check = input.next();
				}while(check.equalsIgnoreCase("yes"));
	
		System.out.println("Thankyou for using this application");
	}
}
