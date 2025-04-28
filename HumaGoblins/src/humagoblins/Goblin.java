/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humagoblins;

import java.util.Random;

/**
 *
 * @author ifons
 */
class Goblin extends Character {
    public Goblin(int x, int y) {
        Random rand=new Random();
        int atk=rand.nextInt(3, 7);
        super(x, y, 15, atk, 1);
    }
    
    public Item getDrop() {
        Random rand=new Random();
        int roll = rand.nextInt(10);
        if (roll < 3) return new Weapon("Rusty Dagger", 2, 0, 0);
        if (roll < 6) return new Armor("Tattered Leather", 0, 2, 0);
        if (roll < 8) return new Potion("Healing Brew", 0, 0, 5);
        return new Treasure("Goblin Trinket", 0, 0, 0);
    }
    
    public int getDamage() {
        return attack;
    }
}