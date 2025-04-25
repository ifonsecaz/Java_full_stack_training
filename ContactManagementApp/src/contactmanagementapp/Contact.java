/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactmanagementapp;

/**
 *
 * @author ifons
 */
public class Contact {
    private int contactID;
    private String name;
    private int phoneNumber;
    private String email;
    private String contactType;
    private static int count=1;
    
    public Contact(String name, int phoneNumber, String email, String contactType) {
        this.contactID = count;
        count++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.contactType = contactType;
        
    }
    
    public int getContactID() {
        return contactID;
    }

    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    @Override
    public String toString() {
        return "Contact{" + "contactID=" + contactID + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", contactType=" + contactType + '}';
    }
    
}
