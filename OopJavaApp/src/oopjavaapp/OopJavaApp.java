/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package oopjavaapp;

/**
 *
 * @author ifons
 */
public class OopJavaApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Library a=new Library("Test");
        a.addBook("a", "a1", 1, 4);
        a.addBook("b","b1",2,1);
        a.addBook("c", "c1", 3, 2);
        a.addEBook("d", "d1", 4, "ebook", 100);
        a.addEBook("e", "e1", 5, "ebook", 200);
        a.addBook("f", "f1", 6, 20);
        
        a.addMember("Juan");
        a.addPremiumMember("Cesar");
        
        System.out.println(a.toString());
        System.out.println(a.borrowBook(1, 2));
        System.out.println(a.borrowBook(1, 1));
        System.out.println(a.borrowBook(1, 6));
        System.out.println(a.borrowBook(1, 6));
        System.out.println(a.borrowBook(1, 6));
        System.out.println(a.borrowBook(1, 6));
        System.out.println("PremiumMember");
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        System.out.println(a.borrowBook(2, 6));
        
        System.out.println(a.toString());
        
        System.out.println("Borrow a non available book");
        System.out.println(a.borrowBook(2,2));
        
        System.out.println("Return book");
        System.out.println(a.returnBook(2,2)); //Doesnt have it
        System.out.println(a.returnBook(1,2));
        System.out.println(a.toString());
        System.out.println(a.borrowBook(2,2));
    }
    
}
