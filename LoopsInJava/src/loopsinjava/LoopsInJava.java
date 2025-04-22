/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loopsinjava;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class LoopsInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sum=0;
        Scanner lec=new Scanner(System.in);
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            sum+=i;
        }
        System.out.println("Sum first 10 integer numbers " + sum);
        
        System.out.println("Enter a number");
        int num=lec.nextInt();
        
        for (int i = 1; i <= 10; i++) {
            System.out.println(num*i);
        }
        
        //Part 2
        int flag=1;
        
        while(flag==1){
            System.out.println("Enter a positive integer: ");
            try {
                num=lec.nextInt();
                int total=0;

                while(num>0){
                    total+=num%10;
                    num=num/10;
                }
                System.out.println(total);
            }
            catch(InputMismatchException e){
                System.out.println("enter a valid integer");
                lec.next();
            }
            System.out.println("Do you want to continue (1:yes,0:no)");
            flag=lec.nextInt();
        }
        
        //Part 3
        int op;
        do{
            System.out.println("Please select an operation:"
                    + "\n1. Addition"
                    + "\n2. Subtraction"
                    + "\n3. Multiplication"
                    + "\n4. Division"
                    + "\n5. Exit");
            
            op=lec.nextInt();
            
            if(op!=5){
                System.out.println("Enter the first number:");
                double num1=lec.nextDouble();
                System.out.println("Enter the second number:");
                double num2=lec.nextDouble();

                switch(op){
                    case 1:
                        System.out.println(num1+num2);
                        break;
                    case 2:
                        System.out.println(num1-num2);
                        break;
                    case 3:
                        System.out.println(num1*num2);
                        break;
                    case 4:
                        System.out.println(num1/num2);
                        break;                        
                }
            }
            else{
                System.out.println("Exiting the calculator. Thank you!");
            }
        } while(op!=5);
        
        lec.close();
        
    }
    
}
