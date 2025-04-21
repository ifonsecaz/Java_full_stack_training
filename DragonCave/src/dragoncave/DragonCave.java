/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dragoncave;

import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class DragonCave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lec=new Scanner(System.in);
        int res;
        System.out.println("You are in a land full of dragons. In front of you, "
                + "\nYou see two caves. In one cave, the dragon is friendly"
                + "\nand will share his treasure with you. The other dragon"
                + "\nis greedy and hungry and will eat you on sight."
                + "\nWhich cave will you go into? (1 or 2)"
        );
        
        res=lec.nextInt();
        
        switch (res) {
            case 1:
                System.out.println("You approach the cave…"
                        + "\nIt is dark and spooky…"
                        + "\nA large dragon jumps out in front of you!"
                        + "\nHe opens his jaws and…"
                        + "\nGobbles you down in one bite!");
                break;
            case 2:
                System.out.println("You approach the cave…"
                        + "\nIt is dark and spooky…"
                        + "\nA faint glow emanates from deep within"
                        + "\nIt is a dusty old library"
                        + "\nshelves stacked with ancient coding tomes"
                        + "\nIn the corner, you spot a gleaming golden chest!");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        
        lec.close();
        

    }
    
}
