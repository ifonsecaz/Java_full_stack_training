/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopjavaapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ifons
 */
public class Library {
    private String name;
    private List<Book> bookCollection;
    private List<Member> memberCollection;

    public Library(String name) {
        this.name = name;
        bookCollection=new ArrayList<>();
        memberCollection=new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addBook(String title, String author, int isbn, int numEx){
        Book nuevo=new Book(title,author,isbn,numEx);
        bookCollection.add(nuevo);
    }
    
    public void addEBook(String title, String author, int isbn, String format, int size){
        EBook nuevo=new EBook(title,author,isbn,format,size);
        bookCollection.add(nuevo);
    }
    
    public void addMember(String name){
        Member nuevo=new Member(name);
        memberCollection.add(nuevo);
    }
    
    public void addPremiumMember(String name){
        PremiumMember nuevo=new PremiumMember(name);
        memberCollection.add(nuevo);
    }
    
    public boolean borrowBook(int memberId, int isbn){
        int i=0;
        Member user=null;
        Book oneBook=null;
        boolean res=false;
        while(i<bookCollection.size()&&oneBook==null){
            if(isbn==bookCollection.get(i).getIsbn()){
                oneBook=bookCollection.get(i);
            }
            i++;
        }
        if(oneBook!=null&&oneBook.getAvailability()){
            i=0;
            while(i<memberCollection.size()&&user==null){
                if(memberId==memberCollection.get(i).getMemberId()){
                    user=memberCollection.get(i);
                }
                i++;
            }
            if(user!=null&&user.canBorrow()){
                oneBook.retrieveBook();
                res=user.addBook(oneBook);
            }
        }
        return res;
    }
    
    public boolean returnBook(int memberId, int isbn){
        int i=0;
        Member user=null;
        Book oneBook=null;
        boolean res=false;
        while(i<bookCollection.size()&&oneBook==null){
            if(isbn==bookCollection.get(i).getIsbn()){
                oneBook=bookCollection.get(i);
            }
            i++;
        }
        if(oneBook!=null){

            i=0;
            while(i<memberCollection.size()&&user==null){
                if(memberId==memberCollection.get(i).getMemberId()){
                    user=memberCollection.get(i);
                }
                i++;
            }
            if(user!=null){
                res=user.returnBook(oneBook);
            }
        }
        return res;
    }
   
    public String getListBooks(){
        StringBuilder cad=new StringBuilder();
        for(int i=0;i<bookCollection.size();i++){
            cad.append("\n"+bookCollection.get(i).toString());
        }
        return cad.toString();
    }
    
    public String getListMembers(){
        StringBuilder cad=new StringBuilder();
        for(int i=0;i<memberCollection.size();i++){
            cad.append("\n"+memberCollection.get(i).toString());
        }
        return cad.toString();
    }

    @Override
    public String toString() {
        StringBuilder cad=new StringBuilder();
        cad.append("\nLibrary name= "+name);
        cad.append(getListBooks());
        cad.append(getListMembers());
        return cad.toString();
    }
    
}
