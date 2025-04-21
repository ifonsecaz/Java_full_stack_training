/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaconcepts;
import java.util.Scanner;
/**
 *
 * @author ifons
 */
public class JavaConcepts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int age=24;
        double height=1.78;
        char initial='I';
        boolean isStudent=false;
        int counter=10;

        System.out.println("Age: " + age);
        System.out.println("Height: " + height);
        System.out.println("Initial: " + initial);
        System.out.println("Student: " +  isStudent);

        //Part 2
        counter++;
        System.out.println("Counter: " + counter);
        counter--;
        System.out.println("Counter: " + counter);

        for(int i=10;i<15;i++){
            System.out.println(counter++);
        }
        System.out.println(counter);

        while(counter>=10){
            System.out.println(counter);
            counter--;
        }

        //Part 3
        Scanner lec=new Scanner(System.in);

        System.out.println("Enter your name: ");
        String firstName=lec.nextLine();
        System.out.println("Enter your last name: ");   
        String lastName=lec.nextLine();

        String fullname=firstName + " " + lastName;
        String fullnameUpper=fullname.toUpperCase();

        int i=1;
        int count=1;
        while(i<fullnameUpper.length()){
            if(fullnameUpper.charAt(i)==fullnameUpper.charAt(0)){
                count++;
            }
            i++;
        }
        System.out.println(fullname);
        System.out.println(fullnameUpper);
        System.out.println("Number of times first letter appears: "+count);

        //part 4
        int test1=98;
        int test2=69;
        int test3=80;

        int averageScore=(test1+test2+test3)/3;

        if (averageScore>=90){
            System.out.println("Excellent");
        }
        else if(averageScore>=70){
            System.out.println("Good");
        }
        else if(averageScore>=50){
            System.out.println("Average");
        } 
        else{
            System.out.println("Poor");
        }

        int day=5;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }

        //part 5
        System.out.println("Enter number 1: ");
        double num1=lec.nextDouble();
        System.out.println("Enter number 2: ");
        double num2=lec.nextDouble();
        double res;
        System.out.println("Enter operation: ");
        String operation=lec.next();

        switch(operation){
            case "+":
                res=num1+num2;
                break;
            case "-":
                res=num1-num2;
                break;
            case "*":
                res=num1*num2;
                break;
            case "/":
                res=num1/num2;
                break;
            default:
                res=0;
                break;
        }

        System.out.println("Do you want to increment the result? (Y/N)");
        String increment=lec.next();
        if(increment.equals("Y")){
            res++;
        }else{
            System.out.println("Do you want to decrement the result? (Y/N)");
            increment=lec.next();
            if(increment.equals("Y")){
                res--;
            }
        }
        System.out.println("Result: " + res);


        lec.close();
        
    }
    
}
