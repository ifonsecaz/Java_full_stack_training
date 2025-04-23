/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopjavaapp;

/**
 *
 * @author ifons
 */
public class PremiumMember extends Member{
    private Book[] borrowedBooks;

    public PremiumMember(String name) {
        super(name);
        super.borrowedBooks = new Book[10];
    }
    
    
}
