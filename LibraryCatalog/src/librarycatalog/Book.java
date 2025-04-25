/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycatalog;

import java.util.Objects;

/**
 *
 * @author ifons
 */
public class Book {
    private String title;
    private String author;
    private int bookID;
    private boolean availability;
    private int numExemplars;
    private String genre;
    private static int count=1;
       
    public Book(String title, String author, String genre, int numExemplars){
        this.title=title;
        this.author=author;
        this.bookID=count;
        count++;
        this.numExemplars=numExemplars;
        this.genre=genre;
        if(this.numExemplars>0)
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

    public int getBookID() {
        return bookID;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
    
    public void addNewExemplars(int numExemplars){
        this.numExemplars+=numExemplars;
        if(numExemplars>0)
            availability=true;
    }
    
    public boolean retrieveBook(){
        boolean res=false;
        if(numExemplars>0){
            res=true;
            numExemplars--;
            if(numExemplars==0)
                availability=false;
        }
        
        return res;
    }
    
    public void returnBook(){
        numExemplars++;
        availability=true;
       
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", bookID=" + bookID + ", availability=" + availability + ", numExemplars=" + numExemplars + ", genre=" + genre + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        return Objects.equals(this.genre, other.genre);
    }

   

}
