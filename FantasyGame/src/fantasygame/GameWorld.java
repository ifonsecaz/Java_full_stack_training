/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fantasygame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ifons
 */
class GameWorld {
    private int size;
    private Human human;
    private List<Goblin> goblins;
    private List<Treasure> treasures;
    private char[][] grid;
    Random rand;
    private int initX;
    private int initY;
    
    public GameWorld() {
        this.size = 10;
        this.grid = new char[10][10];
        this.goblins = new ArrayList<>();
        this.treasures = new ArrayList<>();
        rand= new Random();
        initializeGrid();
    }
    
    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = '.';
            }
        }
    }
    
    public void spawnHuman() {
        int x = size / 2;
        int y = size / 2;
        human = new Human(x, y);
        grid[x][y] = 'H';
        initX=x;
        initY=y;
    }
    
    public void spawnGoblins(int count) {
        for (int i = 0; i < count; i++) {
            int x, y;
            do {
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            } while (grid[x][y] != '.');
            
            Goblin goblin = new Goblin(x, y);
            goblins.add(goblin);
            grid[x][y] = 'G';
        }
    }
    
    public void spawnTreasure() {
        for (int i = 0; i < 3; i++) {
            int x, y;
            do {
                x = rand.nextInt(10);
                y = rand.nextInt(10);
            } while (grid[x][y] != '.');
            
            Treasure newT=new Treasure(x,y);
            treasures.add(newT);
            if(i==0)
               newT.setAttackBonus(3);
            else if(i==1)
               newT.setDefenseBonus(2);
            else
               newT.setHealthBonus(5);
            grid[x][y] = 'T';
        }
    }
    
    public void moveHuman(char direction) {
        int newX = human.getX();
        int newY = human.getY();
        
        switch (direction) {
            case 'W': 
                newX--; 
                break;
            case 'S': 
                newX++; 
                break;
            case 'D': 
                newY++; 
                break;
            case 'A': 
                newY--; 
                break;
        }
        
        if (isValidMove(newX, newY)) {
            grid[human.getX()][human.getY()] = '.';
            human.move(newX, newY);
            
            Iterator<Treasure> it = treasures.iterator();
            while(it.hasNext()){
                Treasure t = it.next();
                if (t.getX() == newX && t.getY() == newY) {
                    human.addToInventory(t);
                    it.remove();
                    System.out.println("Found treasure: " + t);
                    break;
                }
            }

            grid[newX][newY] = 'H';
        }
    }
    
    public void moveGoblins() {
        for (Goblin goblin : goblins) {
            int dx = Integer.compare(human.getX(), goblin.getX());
            int dy = Integer.compare(human.getY(), goblin.getY());
           
            
            int newX = goblin.getX() + dx;
            int newY = goblin.getY() + dy;
            
            if (isValidMove(newX, newY) && grid[newX][newY] == '.') {
                grid[goblin.getX()][goblin.getY()] = '.';
                goblin.move(newX, newY);
                grid[newX][newY] = 'G';
            }
        }
    }
    
    public boolean checkCombat() {
        Iterator<Goblin> it = goblins.iterator();
        boolean res=true;
        while(it.hasNext()){
            Goblin goblin = it.next();
            if (goblin.getX() == human.getX() && goblin.getY() == human.getY()) {
                System.out.println("Combat initiated!");
                boolean humanWins = combat(human, goblin);
                
                if (humanWins) {
                    System.out.println("You defeated the goblin!");
                    human.addToInventory(goblin.getDrop());
                    it.remove();
                    res=true;
                } else {
                    System.out.println("The goblin defeated you!");
                    human.takeDamage(goblin.getDamage());
                    resetHuman();
                    res=false;
                }
                
                if(human.isAlive())
                    grid[human.getX()][human.getY()]='H';
                else
                    grid[human.getX()][human.getY()]='.';
            }
        }
        return res;
    }
    
    private void resetHuman(){
        grid[human.getX()][human.getY()]='G';
        human.setX(initX);
        human.setY(initY);
        grid[human.getX()][human.getY()]='H';
    }
    
    private boolean combat(Human human, Goblin goblin) {
        int humanCombatPower = human.getAttack();
        int goblinCombatPower = goblin.getAttack();
        
        return humanCombatPower > goblinCombatPower;
    }
    
    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < size && y >= 0 && y < size;
    }
    
    public void display() {
        System.out.println("\nHuman Stats: " + human);
        System.out.println("Inventory: " + human.getInventory());
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public Human getHuman(){
        return human;
    }
    
    public boolean isGameOver() {
        return !human.isAlive() || goblins.isEmpty();
    }
    
    public boolean humanAlive() {
        return human.isAlive();
    }
}
