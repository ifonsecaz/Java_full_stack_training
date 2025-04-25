/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptiont;

/**
 *
 * @author ifons
 */
public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private static int num=1000;

    public BankAccount(String accountHolder) {
        this.accountNumber = num;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        num++;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
    
    public double depositFounds(double founds)throws InvalidAmountException{
        if(founds<100||founds>1000000){
            throw new InvalidAmountException("You have to insert above 100 and less than 1000000");
        }
        balance+=founds;
        
        return balance;
    }
    
    public double withdrawFound(double founds)throws InvalidAmountException,InsufficientFundsException{
        if(founds<100||founds>1000000){
            throw new InvalidAmountException("You can only retire between 100 and less than 10000");
        }
        double res=balance;
        if(founds<=balance){
            balance-=founds;
            res=balance;
        }
        else{
            throw new InsufficientFundsException("Not enough cash in your account");
        }
        return res;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + ", accountHolder=" + accountHolder + ", balance=" + balance + '}';
    }
    
}
