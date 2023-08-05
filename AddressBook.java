package com.assignment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class AddressBook {
	private ArrayList<Contact> addressBook = new ArrayList<Contact>();
	public String name;
	public String check;
	public AddressBook() {
		addressBook = new ArrayList<Contact>();
	}
	
	public ArrayList<Contact> getAddressBook(){
		return addressBook;
	}
	public void setAddressBook(ArrayList<Contact> array) {
		this.addressBook = array; 
	}
	public AddressBook(String name) {
		this.name = name;
	}
	
	public void addContactDetails() {
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter your first name : ");
		String fName = sc.next();
		System.out.println("Enter your last name : ");
		String lName = sc.next();
		System.out.println("Enter your address : ");
		String address = sc.next();
		System.out.println("Enter your city name : ");
		String city = sc.next();
		System.out.println("Enter your state name : ");
		String state = sc.next();
		System.out.println("Enter your zip : ");
		int zip = sc.nextInt();
		System.out.println("Enter your phone number : ");
		long pNo = sc.nextLong();
		System.out.println("Enter your Email : ");
		String email = sc.next();
		Contact contact = new Contact(fName,lName,address,city,state,zip,pNo,email);
		boolean duplicate = addressBook.stream().anyMatch(n -> n.equals(contact));
		if(!duplicate)
			addressBook.add(contact);
		else {
			System.out.println("Contact already exists");
		}
		
	}
	public void editContact(String newName) {
		
		for(int i = 0; i < addressBook.size(); i++) {
			Contact contact = addressBook.get(i);
			String editName = addressBook.get(i).getFirstName() + addressBook.get(i).getLastName();
			if(newName.equalsIgnoreCase(editName)) {
				Scanner sc = new Scanner(System.in);
				do {
					System.out.println("Enter what you want to change : ");
					int choice = sc.nextInt();
					switch(choice) {
						case 1:
							System.out.println("Enter your new address : ");
							String newAddress = sc.next();
							System.out.println(newAddress);
							contact.setAddress(newAddress);
							break;
						case 2:
							System.out.println("Enter your new city name : ");
							String newCity = sc.next();
							contact.setCity(newCity);
							break;
						case 3:
							System.out.println("Enter your new state name : ");
							String newState = sc.next();
							contact.setState(newState);
							break;
						case 4:
							System.out.println("Enter your new zip : ");
							int newZip = sc.nextInt();
							contact.setZip(newZip);
							break;
						case 5:
							System.out.println("Enter your new phone number : ");
							long newPNo = sc.nextLong();
							contact.setPhoneNo(newPNo);
							break;
						case 6:
							System.out.println("Enter your new Email : ");
							String newEmail = sc.next();
							contact.setEmail(newEmail);
							break;
						default:
							break;
					}
					System.out.println("Do you want to edit more ? ");
					check = sc.next();
				}while(check.equals("Yes"));
			}
		}
	}
	public void deleteContact(String name) {
		for(int i = 0; i < addressBook.size(); i++) {
			String delName = addressBook.get(i).getFirstName() + addressBook.get(i).getLastName();
			if(name.equals(delName)) {
				addressBook.remove(addressBook.get(i));
			}
		}
	}
	
	public void displayContacts(String disName) {
		for(Contact con : addressBook) {
			String dName = con.getFirstName() + con.getLastName();
			if(disName.equalsIgnoreCase(dName)) {
				System.out.println(con);
			}
		}
	}
	
	public String toString() {
		return "meri AddressBook";
	}
}
