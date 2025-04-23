/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oopjavaapp;

/**
 *
 * @author ifons
 */
public class Member {
    private String name;
    private int memberId;
    private static int count=1;
    protected Book[] borrowedBooks;
    private int numBooks;

    public Member(String name) {
        this.name = name;
        this.memberId = count;
        count++;
        borrowedBooks=new Book[5];
        numBooks=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Member.count = count;
    }

    public Book getBorrowedBook(int isbn) {
        Book res=null;
        int i=0;
        while(i<numBooks&&res==null){
            if(borrowedBooks[i].getIsbn()==isbn){
                res=borrowedBooks[i];
            }
        }
        
        return res;
    }
    
    public boolean canBorrow(){
        if(numBooks<borrowedBooks.length){
            return true;
        }
        else
            return false;
    }

    public boolean addBook(Book a) {
        boolean res=false;
        if(numBooks<borrowedBooks.length){
            borrowedBooks[numBooks]=a;
            numBooks++;
            res=true;
        }
        return res;
    }

    public boolean returnBook(Book a){
        boolean res=false;
        int i=0;
        while(i<numBooks&&borrowedBooks[i].getIsbn()!=a.getIsbn()){
            i++;
        }
        if(i<numBooks){
            borrowedBooks[i].returnBook();
            borrowedBooks[i]=null;
            borrowedBooks[i]=borrowedBooks[numBooks-1];
            numBooks--;
            res=true;
        }
        return res;
    }
    
    @Override
    public String toString() {
        StringBuilder cad=new StringBuilder();
        cad.append("\nName= " + name);
        cad.append("\nmemberId= "+memberId);
        cad.append("\nBorrowed books= "+numBooks);
        for(int i=0;i<numBooks;i++){
            cad.append("\n"+borrowedBooks[i].toString());
        }
        return cad.toString();
    }
    
}
