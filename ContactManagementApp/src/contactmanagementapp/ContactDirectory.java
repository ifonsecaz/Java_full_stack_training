/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contactmanagementapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author ifons
 */
public class ContactDirectory {
    private ArrayList<Contact> allContacts;
    private HashSet<String> contactTypes;
    private TreeMap<String,Contact> orgContacts;
    private String name;

    public ContactDirectory(String name) {
        this.name = name;
        allContacts=new ArrayList<>();
        contactTypes=new HashSet<>();
        orgContacts=new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean addContact(String name, int phoneNumber, String email, String contactType){
        boolean res=false;
        
        if(!orgContacts.containsKey(name)){
            contactTypes.add(contactType);
            Contact nuevo=new Contact(name,phoneNumber,email,contactType);
            allContacts.add(nuevo);
            orgContacts.put(name, nuevo);
            res=true;
        }
        return res;
    }
    
    public boolean updateContactName(int contactID, String name){
        boolean res=false;
        
        int i=0;
        while(i<allContacts.size()&&!res){
            if(allContacts.get(i).getContactID()==contactID){
                allContacts.get(i).setName(name);
                orgContacts.remove(allContacts.get(i).getName());
                orgContacts.put(name,allContacts.get(i));
                res=true;
            }
            i++;
        }
        return res;
    }
    
    public boolean updateEmail(int contactID, String email){
        boolean res=false;
        
        int i=0;
        while(i<allContacts.size()&&!res){
            if(allContacts.get(i).getContactID()==contactID){
                allContacts.get(i).setEmail(email);
                res=true;
            }
            i++;
        }
        return res;
    }
    
    public boolean updateEmail(String name, String email){
        boolean res=false;
       
        if(orgContacts.containsKey(name)){
            res=true;
            orgContacts.get(name).setEmail(email);
        }
           
        return res;
    }
    
    public boolean updateNumber(int contactID, int number){
        boolean res=false;
        
        int i=0;
        while(i<allContacts.size()&&!res){
            if(allContacts.get(i).getContactID()==contactID){
                allContacts.get(i).setPhoneNumber(number);
                res=true;
            }
            i++;
        }
        return res;
    }
    
    public boolean updateNumber(String name, int number){
        boolean res=false;
       
        if(orgContacts.containsKey(name)){
            res=true;
            orgContacts.get(name).setPhoneNumber(number);
        }
           
        return res;
    }
    
    public boolean updateContactType(int contactID, String type){
        boolean res=false;
        
        int i=0;
        while(i<allContacts.size()&&!res){
            if(allContacts.get(i).getContactID()==contactID){
                allContacts.get(i).setContactType(type);
                contactTypes.add(type);
                res=true;
            }
            i++;
        }
        return res;
    }
    
    public boolean updateContactType(String name, String type){
        boolean res=false;
       
        if(orgContacts.containsKey(name)){
            res=true;
            orgContacts.get(name).setContactType(type);
        }
           
        return res;
    }
    
    public boolean remove(int contactID){
        boolean res=false;
        
        int i=0;
        while(i<allContacts.size()&&!res){
            if(allContacts.get(i).getContactID()==contactID){
                String aux=allContacts.get(i).getName();
                allContacts.remove(i);
                orgContacts.remove(aux);
            }
            i++;
        }
        return res;
    }
    
    public String searchByName(String name){
        String res="";
        if(orgContacts.containsKey(name))
            res=orgContacts.get(name).toString();
        
        return res;
    }
    
    
    public String listOfContacts(){
        StringBuilder cad=new StringBuilder();
        for(int i=0;i<allContacts.size();i++){
            cad.append("\n"+allContacts.get(i).toString());
        }
        return cad.toString();
    }
    
    public boolean addContactTypes(String type){
        return contactTypes.add(type);
    }
    
    public String listOfContactTypes(){
        Iterator<String> it=contactTypes.iterator();
        StringBuilder cad = new StringBuilder();
        while(it.hasNext()){
            cad.append("\n"+it.next());
        }
        return cad.toString();
    }
    
    public String listOfContactsOrdered(){
        StringBuilder cad=new StringBuilder();
        for(String name:orgContacts.keySet()){
            cad.append("\n"+orgContacts.get(name).toString());

        }
        return cad.toString();
    }
}
