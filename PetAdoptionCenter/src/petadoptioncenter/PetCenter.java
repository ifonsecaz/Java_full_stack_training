/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petadoptioncenter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.io.Serializable;
/**
 *
 * @author ifons
 */
public class PetCenter implements Serializable{
    private String name;
    private HashMap<Integer,Adopter> listAdopters;
    private HashMap<Integer,Pet> listPets;
    private static int numA=1000;
    private static int numP=100;

    public PetCenter(String name) {
        this.name = name;
        listAdopters=new HashMap<>();
        listPets=new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String registerAdopter(String name, String email, int phoneNumber){
        Adopter aux=new Adopter(name,email,phoneNumber);
        for(Integer i:listAdopters.keySet()){
            if(listAdopters.get(i).equals(aux))
                return "You are already registered";
        }
        Adopter nuevo=new Adopter(numA,name,email,phoneNumber);
        listAdopters.put(numA, nuevo);
        numA++;
        return "Your ID is " + nuevo.getAdopterID();
    }
    
    public void addPet(String name, int age, String breed, String size, boolean trained){
        Dog nuevo=new Dog(numP,name,age,breed,"SearchingForHome",size,trained);
        listPets.put(numP, nuevo);
        numP++;
    }
    
    public void addPet(String name, int age, String breed, boolean indoor, boolean getsAlongWithOtherCats){
        Cat nuevo=new Cat(numP,name,age,breed,"SearchingForHome",indoor,getsAlongWithOtherCats);
        listPets.put(numP, nuevo);
        numP++;
    }
    
    public void addPet(String name, int age, String breed, String size){
        Bird nuevo=new Bird(numP,name,age,breed,"SearchingForHome",size);
        listPets.put(numP, nuevo);
        numP++;
    }
    
    public boolean removePet(int petID){
        boolean res=false;
        if(listPets.containsKey(petID)){
            listPets.remove(petID);
            res=true;
        }
        return res;
    }
    
    public boolean adoptPet(int petID, int adopterID){
        boolean res=false;
        if(listAdopters.containsKey(adopterID)&&listPets.containsKey(petID)&&listPets.get(petID).getAdoptionStatus().equals("SearchingForHome")){
            listAdopters.get(adopterID).addPet(listPets.get(petID));
            listPets.get(petID).setAdoptionStatus("Adopted");
            res=true;
        }
        return res;
    }
    
    public String searchPet(int petID){
        String res="No results found";
        if(listPets.containsKey(petID))
            res=listPets.get(petID).toString();
                
        return res;
    }
    
    public String searchPetBySpecies(String species){
        String res="";
        for(Integer i:listPets.keySet()){
            if(listPets.get(i).getSpecies().equals(species))
            res+=listPets.get(i).toString();
        }
        return res;
    }
    
    public String searchPetByAge(int age){
        String res="";
        for(Integer i:listPets.keySet()){
            if(listPets.get(i).getAge()==age)
            res+=listPets.get(i).toString();
        }
        return res;
    }
    
    public String searchPetByBreed(String breed){
        String res="";
        for(Integer i:listPets.keySet()){
            if(listPets.get(i).getBreed().equals(breed))
            res+=listPets.get(i).toString();
        }
        return res;
    }
    
    public String searchAdopter(int adopterID){
        String res="No results found";
        if(listAdopters.containsKey(adopterID))
            res=listAdopters.get(adopterID).toString();
        return res;
    }
    
    public String listPets(){
        StringBuilder cad=new StringBuilder();
        for(Integer i:listPets.keySet()){
            cad.append("\n"+listPets.get(i).toString());
        }
        return cad.toString();
    }
    
    public String listAvailablePets(){
        StringBuilder cad=new StringBuilder();
        for(Integer i:listPets.keySet()){
            if(listPets.get(i).getAdoptionStatus().equals("SearchingForHome"))
                cad.append("\n"+listPets.get(i).toString());
        }
        return cad.toString();
    }
    
    public String listAdopters(){
        StringBuilder cad=new StringBuilder();
        for(Integer i:listAdopters.keySet()){
            cad.append("\n"+listAdopters.get(i).toString());
        }
        return cad.toString();
    }

    @Override
    public String toString() {
        return "PetCenter{" + "name=" + name + '}' + listPets() + listAdopters();
    }
    
    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static PetCenter loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (PetCenter) ois.readObject();
        }
    }
    
    public void loadID(){
        int max=0;
        for(Integer i: listAdopters.keySet()){
            if(max<i)
                max=i;
        }
        numA=max+1;
        max=0;
        for(Integer i: listPets.keySet()){
            if(max<i)
                max=i;
        }
        numP=max+1;
    }
    
}
