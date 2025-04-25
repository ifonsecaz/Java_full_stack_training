/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycatalog;

/**
 *
 * @author ifons
 */

import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author ifons
 */
public class Catalog {
    private String name;
    private HashMap<Integer,Book> bookCollection;
    private HashSet<String> genreCollection;

    public Catalog(String name) {
        this.name = name;
        bookCollection=new HashMap<>();
        genreCollection=new HashSet<>();
        genreCollection.add("Action");
        genreCollection.add("Adventure");
        genreCollection.add("Horror");
        genreCollection.add("Comedy");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean addBook(String title, String author, String genre, int numEx){
        boolean res=false;
        Book nuevo=new Book(title,author,genre,numEx);
        for(Integer i:bookCollection.keySet()){
            if(nuevo.equals(bookCollection.get(i))){
                bookCollection.get(i).addNewExemplars(numEx);
                return true;
            }
        }
        if(genreCollection.contains(genre)){
            nuevo.addNewExemplars(numEx);
            res=true;
        }
        return res;
    }
      
    public boolean borrowBook(int bookID){
        boolean res=false;
        if(bookCollection.containsKey(bookID)&&bookCollection.get(bookID).getAvailability()){
            bookCollection.get(bookID).retrieveBook();
            res=true;
        }
        
        return res;
    }
    
    public boolean returnBook(int bookID){
        boolean res=false;
        if(bookCollection.containsKey(bookID)){
            bookCollection.get(bookID).returnBook();
            res=true;
        }
        return res;
    }
    
    public boolean bookAvailable(int bookID){
        boolean res=false;
        if(bookCollection.containsKey(bookID)&&bookCollection.get(bookID).getAvailability())
            res=true;
        return res;
    }
    
    public String getBookDetails(int bookID){
        String res="";
        if(bookCollection.containsKey(bookID))
            res=bookCollection.get(bookID).toString();
        return res;
    }
    
    public String searchBooksByTitle(String title){
        StringBuilder cad=new StringBuilder();
        
        for(Integer i:bookCollection.keySet()){
            if(bookCollection.get(i).getTitle().equals(title)){
                cad.append("\n"+bookCollection.get(i).toString());
            }
        }
        return cad.toString();
    }
    
    public String searchBooksByAuthor(String author){
        StringBuilder cad=new StringBuilder();
        
        for(Integer i:bookCollection.keySet()){
            if(bookCollection.get(i).getAuthor().equals(author)){
                cad.append("\n"+bookCollection.get(i).toString());
            }
        }
        return cad.toString();
    }
    
    public String searchBooksByGenre(String genre){
        StringBuilder cad=new StringBuilder();
        
        for(Integer i:bookCollection.keySet()){
            if(bookCollection.get(i).getGenre().equals(genre)){
                cad.append("\n"+bookCollection.get(i).toString());
            }
        }
        return cad.toString();
    }
    
    public boolean addGenre(String genre){
        return genreCollection.add(genre);
    }
   
    public String getListGenres(){
        StringBuilder cad = new StringBuilder();
        for(String genre:genreCollection){
            cad.append("\n"+genre);
        }
        return cad.toString();
    }
    
    public String getListBooks(){
        StringBuilder cad=new StringBuilder();
        for(Integer i:bookCollection.keySet()){
            cad.append("\n"+bookCollection.get(i).toString());
        }
        return cad.toString();
    }
    

    @Override
    public String toString() {
        StringBuilder cad=new StringBuilder();
        cad.append("\nLibrary name= "+name);
        cad.append(getListGenres());
        cad.append(getListBooks());
        return cad.toString();
    }
    
}