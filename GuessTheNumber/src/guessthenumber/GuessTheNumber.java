/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guessthenumber;

/**
 *
 * @author ifons
 */
import java.util.Scanner;
import java.util.Random;
import java.time.Instant;
import java.time.Duration;
import java.util.InputMismatchException;

public class GuessTheNumber {
    private static final Scanner lec = new Scanner(System.in);
    private static final Random random = new Random();
    
    private static int maxRange = 100;
    private static int maxAttempts = 10;
    private static int timeLimitSeconds = 0;
    private static int[] highScores={-1,-1,-1};
    private static int difficulty=1;
    
    private static void selectDifficulty() {
        System.out.println("Select Difficulty Level:"
                + "\n1. Easy (1-100, 10 attempts, no time limit) "
                + "\n2. Medium (1-200, 7 attempts, 60 second limit)"
                + "\n3. Hard (1-250, 5 attempts, 30 second limit)"
                + "\nEnter your choice (1-3): ");
        
        int choice = getValidInt();
        difficulty=choice;
        switch (choice) {
            case 1:
                maxRange = 100;
                maxAttempts = 10;
                timeLimitSeconds = 0;
                break;
            case 2:
                maxRange = 200;
                maxAttempts = 7;
                timeLimitSeconds = 60;
                break;
            case 3:
                maxRange = 250;
                maxAttempts = 5;
                timeLimitSeconds = 30;
                break;
        }
    }
    
    private static void playGame() {
        int targetNumber = random.nextInt(maxRange + 1);
        int attempts = 0;
        boolean hasWon = false;
        
        System.out.println("\nI'm thinking of a number between 1 and " + maxRange);
        System.out.println("You have " + maxAttempts + " attempts");
        if (timeLimitSeconds > 0) {
            System.out.println("And you have " + timeLimitSeconds + " seconds");
        }
        
        Instant startTime = Instant.now();
        
        while (attempts < maxAttempts && !hasWon) {
            System.out.println("Attempt number " + attempts);
            if (timeLimitSeconds > 0) {
                long seconds = Duration.between(startTime, Instant.now()).getSeconds();
                long remainingSeconds = timeLimitSeconds - seconds;
                if (remainingSeconds <= 0) {
                    System.out.println("\nTime's up!");
                    break;
                }
                System.out.println("Remaining seconds " + remainingSeconds);
            }
            System.out.println("Enter your guess: ");
            
            int guess = getValidInt();
            attempts++;
            
            if (guess == targetNumber) {
                hasWon = true;
                System.out.println("\nCongratulations! You won"); 
                
                if(highScores[difficulty-1]==-1 || attempts<highScores[difficulty-1]){
                    highScores[difficulty-1]=attempts;
                    System.out.println("New high score");
                }
                
                System.out.println("Current high scores:");
                for (int i=0;i<highScores.length;i++) {
                    System.out.println("Difficulty: " + (i+1) + " attempts: " + highScores[i]);
                }
            } else if (guess < targetNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Too high");
            }
        }
        
        if (!hasWon) {
            System.out.println("\nSorry, you didn't guess the number. It was " + targetNumber);
        }
    }
    
    private static int getValidInt() {
        while (true) {
            try {
                int input = lec.nextInt();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                lec.next(); 
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome to Guess the Number");
        
        boolean playAgain = true;
        
        while (playAgain) {
            selectDifficulty();
            playGame();
            
            System.out.print("Would you like to play again? (y/n): ");
            String response = lec.next();
            playAgain = response.equals("y");
        }
        
        System.out.println("\nThanks for playing");
        lec.close();
    }
    
    
}
