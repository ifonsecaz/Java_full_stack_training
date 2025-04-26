/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petadoptioncenter;

import java.util.HashMap;
import java.util.Objects;

import java.io.Serializable;
/**
 *
 * @author ifons
 */
public class Adopter implements Serializable{
    private int adopterID;
    private String name;
    private String email;
    private int phoneNumber;
    private HashMap<Integer,Pet> adoptedPets;

    public Adopter(int adopterID,String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adopterID=adopterID;
        
        adoptedPets=new HashMap<>();
    }

    public Adopter(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAdopterID() {
        return adopterID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPet(int id){
        if(adoptedPets.containsKey(id))
            return adoptedPets.get(id).toString();
        else
            return "We couldn't find the id";
    }
    
    public void addPet(Pet a){
        adoptedPets.put(a.getPetID(), a);
    }
    
    @Override
    public String toString() {
        StringBuilder cad=new StringBuilder();
        for(Integer i:adoptedPets.keySet()){
            cad.append("\n" + adoptedPets.get(i).toString());
        }
        return "Adopter{" + "adopterID=" + adopterID + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + " adopted pets: " + cad.toString() + "}";
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
        final Adopter other = (Adopter) obj;
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }
       
    
}
