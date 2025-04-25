/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarycatalog;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class LibraryCatalog {
    private static final Scanner lec = new Scanner(System.in);

    
    private static int getValidInt() {
        while (true) {
            try {
                int input = lec.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                lec.next(); 
            }
        }
    }
    
    private static String getValidString() {
        while (true) {
            try {
                String input = lec.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a string: ");
                lec.next(); 
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op, op2;
        String title, author, genre;
        int numExemplars, bookID;
        boolean res;
        Catalog a=new Catalog("a");
        do{
            System.out.println("Please select an operation:"
                    + "\n1. Add a book"
                    + "\n2. Add a genre"
                    + "\n3. Search a book"
                    + "\n4. Check if a book is available"
                    + "\n5. Retreive a book"
                    + "\n6. Return a book"
                    + "\n7. List of books"
                    + "\n8. List of genres"
                    + "\n9. Exit");
            
            op=getValidInt();
            
            if(op!=9){
                switch(op){
                    case 1:
                        System.out.println("Enter the book details: ");
                        System.out.println("Title: ");
                        title=getValidString();
                        System.out.println("Author: ");
                        author=getValidString();
                        System.out.println("Genre: ");
                        genre=getValidString();
                        System.out.println("Number of exemplars: ");
                        numExemplars=getValidInt();
                        
                        res=a.addBook(title, author, genre,numExemplars);
                        if(res)
                            System.out.println("Book added");
                        else
                            System.out.println("Invalid genre");
                        break;
                    case 2:
                        System.out.println("Enter the genre");
                        genre=getValidString();
                        res=a.addGenre(genre);
                        if(res)
                            System.out.println("Genre added");
                        else
                            System.out.println("Genre already exists");
                        break;
                    case 3:
                        System.out.println("Please select an operation:"
                            + "\n1. Search by ID"
                            + "\n2. Search by title"
                            + "\n3. Search by author"
                            + "\n4. Search by genre");
                            op2=getValidInt();
                            switch(op2){
                                case 1:
                                    System.out.println("Enter the book ID");
                                    bookID=getValidInt();
                                    System.out.println(a.getBookDetails(bookID));
                                    break;
                                case 2:
                                    System.out.println("Enter the book title");
                                    title=getValidString();
                                    System.out.println(a.searchBooksByTitle(title));
                                    break;
                                case 3:
                                    System.out.println("Enter the book author");
                                    author=getValidString();
                                    System.out.println(a.searchBooksByAuthor(author));
                                    break;
                                case 4:
                                    System.out.println("Enter the book genre");
                                    genre=getValidString();
                                    System.out.println(a.searchBooksByGenre(genre));
                                    break;
                            }
                        break;
                    case 4:
                        System.out.println("Enter the book ID");
                        bookID=getValidInt();
                        if(a.bookAvailable(bookID))
                            System.out.println("The book is available");
                        else
                            System.out.println("Sorry, the book is not available");
                        break;
                    case 5: 
                        System.out.println("Enter the book ID");
                        bookID=getValidInt();
                        if(a.borrowBook(bookID))
                            System.out.println("Operation succesful");
                        else
                            System.out.println("The book is not available");
                        break;  
                    case 6:
                        System.out.println("Enter the book ID");
                        bookID=getValidInt();
                        if(a.returnBook(bookID))
                            System.out.println("Operation succesful");
                        else
                            System.out.println("We couldn't finde the book");
                        break;                          
                    case 7:
                        System.out.println(a.getListBooks());
                        break;
                    case 8:
                        System.out.println(a.getListGenres());
                        break;
                }
            }
            else{
                System.out.println("Exiting the library catalog, Thank you.");
            }
        } while(op!=9);
    }
    
}
