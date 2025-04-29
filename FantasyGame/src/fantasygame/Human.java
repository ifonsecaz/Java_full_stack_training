/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fantasygame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ifons
 */
class Human extends Character {
    private List<Item> inventory = new ArrayList<>();
    
    public Human(int x, int y) {
        super(x, y, 30, 5, 3);
    }
    
    public void addToInventory(Item item) {
        inventory.add(item);
        this.attack += item.getAttackBonus();
        this.defense += item.getDefenseBonus();
        this.health += item.getHealthBonus();
    }
    
    public List<Item> getInventory() {
        return inventory;
    }
    
    @Override
    public String toString() {
        return super.toString() + " | Inventory: " + inventory.size() + " items";
    }
}
