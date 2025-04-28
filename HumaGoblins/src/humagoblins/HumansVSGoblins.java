/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package humagoblins;

import java.util.*;

// Main game class
public class HumansVSGoblins {
    
    private static GameWorld world;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Humans VS Goblins!");
        System.out.println("Controls: WASD for movement, Q to quit");
        
        initializeGame();
        loop();
        
        scanner.close();
    }

    private static void initializeGame() {
        world = new GameWorld();
        world.spawnHuman();
        world.spawnGoblins(3);
        world.spawnTreasure();
        world.display();
    }

    private static void loop() {
        boolean cont = true;
        boolean resBattle;
        while (cont) {
            System.out.print("Enter move WASD: ");
            String input = scanner.nextLine().toUpperCase();
            
            if (input.equals("Q")) {
                cont = false;
                System.out.println("Thanks for playing!");
                continue;
            }
            
            if (!input.matches("[WASD]")) {
                System.out.println("Invalid input!");
                continue;
            }
            
            world.moveHuman(input.charAt(0));
            world.moveGoblins();
            resBattle=world.checkCombat();
            
            
            world.display();
            
            if (world.isGameOver()) {
                System.out.println("Game Over! " );
                if(world.humanAlive())
                    System.out.println("You won!");
                else
                    System.out.println("You loose!"); 
                cont = false;
            }
        }
    }
}
