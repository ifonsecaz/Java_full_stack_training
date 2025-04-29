/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fantasygame;

import java.util.*;

// Main game class
public class HumansVSGoblins {
    
    private static GameWorld world;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Humans VS Goblins!");
        System.out.println("Controls: WASD for movement, Q to quit");
        
        try {
            initializeGame();
            loop();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }

    }

    private static void initializeGame() {
        try {
            world = new GameWorld();
            world.spawnHuman();
            world.spawnGoblins(3);
            world.spawnTreasure();
            world.display();
        } catch (Exception e) {
            System.err.println("Error during game initialization: " + e.getMessage());
            throw e; 
        }

    }

    private static void loop() {
        boolean cont = true;
        boolean resBattle;
        while (cont) {
            try {
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
                resBattle = world.checkCombat();
                
                world.display();
                
                if (world.isGameOver()) {
                    System.out.println("Game Over!");
                    if (world.humanAlive())
                        System.out.println("You won!");
                    else
                        System.out.println("You lose!");
                    cont = false;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input type. Please enter a valid move.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.err.println("An error occurred during the game loop: " + e.getMessage());
                e.printStackTrace();
                cont = false; 
            }

        }
    }
}
