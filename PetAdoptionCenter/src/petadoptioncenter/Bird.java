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
public class Bird extends Pet implements Serializable{
    private String size;

    public Bird(int petID, String name, int age, String breed, String adoptionStatus, String size) {
        super(petID, name, "Bird", age, breed, adoptionStatus);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + " Size: "+ size;
    }
}
