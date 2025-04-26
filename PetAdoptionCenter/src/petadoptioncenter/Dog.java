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
class Dog extends Pet implements Serializable{
    private String size; 
    private boolean trained;

    public Dog(int petID, String name, int age, String breed, String adoptionStatus, String size, boolean trained) {
        super(petID,name, "Dog", age, breed, adoptionStatus);
        this.size = size;
        this.trained = trained;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isTrained() {
        return trained;
    }

    public void setTrained(boolean trained) {
        this.trained = trained;
    } 

    @Override
    public String toString() {
        return super.toString() + " Size: "+ size + " trained: " + trained;
    }
}
