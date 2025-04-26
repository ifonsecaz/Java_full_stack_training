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
public class Cat extends Pet implements Serializable{
    private boolean indoor;
    private boolean getsAlongWithOtherCats;
    
    public Cat(int petID, String name, int age, String breed, String adoptionStatus, boolean indoor, boolean getsAlongWithOtherCats) {
        super(petID, name, "Cat", age, breed, adoptionStatus);
        this.indoor = indoor;
        this.getsAlongWithOtherCats = getsAlongWithOtherCats;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public boolean isGetsAlongWithOtherCats() {
        return getsAlongWithOtherCats;
    }

    public void setGetsAlongWithOtherCats(boolean getsAlongWithOtherCats) {
        this.getsAlongWithOtherCats = getsAlongWithOtherCats;
    }

    @Override
    public String toString() {
        return super.toString() + " indoor=" + indoor + " getsAlongWithOtherCats=" + getsAlongWithOtherCats;
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
        final Cat other = (Cat) obj;
        if (this.indoor != other.indoor) {
            return false;
        }
        return this.getsAlongWithOtherCats == other.getsAlongWithOtherCats;
    }
    
    
    
}
