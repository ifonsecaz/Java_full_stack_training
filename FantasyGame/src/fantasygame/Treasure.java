/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fantasygame;

/**
 *
 * @author ifons
 */
class Treasure implements Item {
    private String name;
    private int attackBonus;
    private int defenseBonus;
    private int healthBonus;
    private int x, y;
    
    public Treasure(int x, int y) {
        this.x = x;
        this.y = y;
        this.name = "Treasure";
        this.attackBonus = 0;
        this.defenseBonus = 0;
        this.healthBonus = 0;
    }
    
    public Treasure(String name, int atk, int def, int hp) {
        this.name = name;
        this.attackBonus = atk;
        this.defenseBonus = def;
        this.healthBonus = hp;
    }
    
    public int getX() { 
        return x; 
    }
    
    public int getY() { 
        return y; 
    }
    
    public String getName() { 
        return name; 
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public void setDefenseBonus(int defenseBonus) {
        this.defenseBonus = defenseBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }
   
    public int getAttackBonus() { 
        return attackBonus; 
    }
    
    public int getDefenseBonus() { 
        return defenseBonus; 
    }
    
    public int getHealthBonus() { 
        return healthBonus; 
    }
    
    @Override
    public String toString() {
        return name;
    }
}
