/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraysinjava;

/**
 *
 * @author ifons
 */
public class ArraysInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Part 2
        double[] a= {23.3,423.2,45.4,9.3,0.222};
        
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        
        //Part 3
        System.out.println("Part 2");
        int[] b={1,2,3,4,5};
        
        b[2]=10;
        
        for(int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }
        
        //Part 4
        int[] c=new int[10];
        
        for(int i=0;i<c.length;i++){
            c[i]=(i+1)*3;
        }
        
        System.out.println("Length: " + c.length);
        
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
        }
    } 
    
}
