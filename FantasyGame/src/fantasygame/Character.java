/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fantasygame;

/**
 *
 * @author ifons
 */
abstract class Character {
    protected int x, y;
    protected int health;
    protected int attack;
    protected int defense;
    protected boolean alive = true;
    
    public Character(int x, int y, int health, int attack, int defense) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }
    
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void takeDamage(int damage) {
        health -= Math.max(1, damage - defense);
        if (health <= 0) {
            health = 0;
            alive = false;
        }
    }
    
    public boolean isAlive() { 
        return alive; 
    }
    
    public int getX() { 
        return x; 
    }
    
    public int getY() { 
        return y; 
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getAttack() { 
        return attack; 
    }
    
    @Override
    public String toString() {
        return ("HP: " + health +" ATK: "+ attack +" DEF: " + defense);
    }
}
