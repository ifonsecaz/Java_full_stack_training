/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contactmanagementapp;

/**
 *
 * @author ifons
 */
public class ContactManagementApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ContactDirectory a=new ContactDirectory("Yo");
        
        a.addContact("h", 8, "h@gmail", "Personal");
        a.addContact("i", 9, "i@gmail", "Professional");
        a.addContact("c", 3, "c@gmail", "Personal");
        a.addContact("d", 4, "d@gmail", "Personal");
        a.addContact("e", 5, "e@gmail", "Professional");
        a.addContact("j", 10, "j@gmail", "School");
        a.addContact("g", 7, "g@gmail", "Personal");
        a.addContact("a", 1, "a@gmail", "Personal");
        a.addContact("b", 2, "b@gmail", "Personal");
        a.addContact("f", 6, "f@gmail", "Professional");
        a.addContactTypes("Hola");
        a.addContactTypes("GGGG");
        
        System.out.println(a.listOfContacts());
        
        System.out.println("Search by name");
        System.out.println(a.searchByName("j"));
        
        System.out.println("update");
        System.out.println(a.updateEmail("d","dd@hotmail" ));
        System.out.println(a.updateEmail(5, "e@hotmail"));
        
        System.out.println("ContactTypes");
        System.out.println(a.listOfContactTypes());
        System.out.println(a.listOfContactsOrdered());
    }
    
}
