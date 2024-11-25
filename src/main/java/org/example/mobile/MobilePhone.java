package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }
    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) != -1){
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition == -1){
            return false;
        }
        if (findContact(newContact.getName()) != -1 && !oldContact.getName().equals(newContact.getName())) {
            return false;
        }
        myContacts.set(foundPosition,newContact);
        return true;
    }
    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition == -1) {
            return false;
        }
        myContacts.remove(foundPosition);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }
    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public Contact queryContact(String contactName) {
        int position = findContact(contactName);
        if (position != -1) {
            return myContacts.get(position);
        }
        return null;
    }
    public void printContacts() {
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}