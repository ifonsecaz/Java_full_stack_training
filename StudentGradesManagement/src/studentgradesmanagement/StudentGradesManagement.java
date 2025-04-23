/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentgradesmanagement;

import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class StudentGradesManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] grades=new double[10];
        Scanner lec=new Scanner(System.in);
        int counter=0;
        double sum=0;
        double min;
        double max;
                
        while(counter<10){
            System.out.println("Enter your grade: ");
            grades[counter]=lec.nextDouble();
            counter++;
        }
        
        min=grades[0];
        max=grades[0];
                
        for(int i=0;i<grades.length;i++){
            sum+=grades[i];
            if(min>grades[i]){
                min=grades[i];
            }
            if(max<grades[i]){
                max=grades[i];
            }
        }
        System.out.println("Average: " + (sum/grades.length));
        System.out.println("Lowest grade: "+ min);
        System.out.println("Highest grade: "+max);
        
        System.out.println("Grades: ");
        for(int i=0;i<grades.length;i++){
            System.out.println(grades[i]);
        }
        lec.close();
    }
    
}
