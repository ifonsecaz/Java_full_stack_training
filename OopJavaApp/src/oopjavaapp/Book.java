/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopjavaapp;

/**
 *
 * @author ifons
 */
public class Book {
    private String title;
    private String author;
    private int isbn;
    private boolean availability;
    private int numExemplars;
       
    public Book(String title, String author, int isbn, int numExemplars){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.numExemplars=numExemplars;
        if(this.numExemplars>0||this.numExemplars==-1)
            this.availability=true;
        else
            this.availability=false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getNumExemplars() {
        return numExemplars;
    }

    public void setNumExemplars(int numExemplars) {
        this.numExemplars = numExemplars;
    }
    
    public boolean retrieveBook(){
        boolean res=false;
        if(numExemplars>0){
            res=true;
            numExemplars--;
            if(numExemplars==0)
                availability=false;
        }
        else{
            if(numExemplars==-1)
                res=true;
        }
        
        return res;
    }
    
    public void returnBook(){
        if(numExemplars!=-1){
            numExemplars++;
            availability=true;
        }
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", isbn=" + isbn + ", availability=" + availability + '}';
    }

}
