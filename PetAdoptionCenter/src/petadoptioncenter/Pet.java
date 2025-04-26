/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package petadoptioncenter;

import java.io.Serializable;
/**
 *
 * @author ifons
 */
public class Pet implements Serializable{
    private int petID;
    private String name;
    private String species;
    private int age;
    private String breed;
    private String adoptionStatus;

    public Pet(int petID, String name, String species, int age, String breed, String adoptionStatus) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.adoptionStatus = adoptionStatus;
        this.petID=petID;
    }

    public int getPetID() {
        return petID;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getAdoptionStatus() {
        return adoptionStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAdoptionStatus(String adoptionStatus) {
        this.adoptionStatus = adoptionStatus;
    }

    @Override
    public String toString() {
        return "Pet{" + "petID=" + petID + ", name=" + name + ", species=" + species + ", age=" + age + ", breed=" + breed + ", adoptionStatus=" + adoptionStatus + '}';
    }
    
    
}
