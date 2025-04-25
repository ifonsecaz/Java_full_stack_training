/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exceptiont;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class ExceptionT {
    private static final Scanner lec = new Scanner(System.in);
    private static HashMap<Integer,BankAccount> b=new HashMap<>();
    
    private static int getValidInt() {
        while (true) {
            try {
                int input = lec.nextInt();
                if (input < 0) {
                    throw new IllegalArgumentException("Only Positive Numbers"); 
                }     
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                lec.next(); 
            }
        }
    }
    
    private static BankAccount validAccount(int number) {       
        if (!b.containsKey(number)) {
            throw new IllegalArgumentException("You need to create a bank account first"); 
        }     
        return b.get(number);
    }
    
    private static String getValidString() {
        while (true) {
            try {
                String input = lec.next();
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a string: ");
                lec.next(); 
            }
        }
    }
    
    private static double getValidDouble() {
        while (true) {
            try {
                double input = lec.nextDouble();
                if (input < 0) {
                    throw new IllegalArgumentException("Only Positive Numbers"); 
                }     
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                lec.next(); 
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidAmountException, InsufficientFundsException {
        int op;
        String name;
        int bankAccount;
        double fund;
        BankAccount aux;
        
        do{
            System.out.println("Please select an operation:"
                    + "\n1. Open a new account"
                    + "\n2. Get details"
                    + "\n3. Deposit"
                    + "\n4. Withdraw"
                    + "\n5. Exit");
            
            op=getValidInt();
            
            if(op!=5){
                switch(op){
                    case 1:
                        System.out.println("Enter your name");
                        name=getValidString();
                        BankAccount a=new BankAccount(name);
                        b.put(a.getAccountNumber(), a);
                        System.out.println("Your new account number is: " + a.getAccountNumber());
                        break;
                    case 2:
                        System.out.println("Enter your account number");
                        bankAccount=getValidInt();
                        aux=validAccount(bankAccount);
                        System.out.println(aux.toString());
                        break;
                    case 3:
                        System.out.println("Enter your account number");
                        bankAccount=getValidInt();
                        aux=validAccount(bankAccount);
                        
                        System.out.println("Enter the ammount you want to deposit");
                        fund=getValidDouble();
                        System.out.println(aux.depositFounds(fund));
                       
                        break;
                    case 4:
                        System.out.println("Enter your account number");
                        bankAccount=getValidInt();
                        aux=validAccount(bankAccount);
                        
                        System.out.println("Enter the ammount you want to withdraw");
                        fund=getValidDouble();
                        System.out.println(aux.withdrawFound(fund));
                       
                        break;
                }
            }
            else{
                System.out.println("Exiting, Thank you.");
            }
        } while(op!=5);
        lec.close();
    }
    
}
