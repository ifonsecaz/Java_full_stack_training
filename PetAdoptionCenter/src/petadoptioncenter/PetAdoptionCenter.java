/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package petadoptioncenter;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ifons
 */
public class PetAdoptionCenter {
    private static final Scanner lec = new Scanner(System.in);

    
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
    
    private static boolean getValidBoolean(){
        while(true){
            String input=getValidString().toLowerCase();
            
            if(input.equals("y"))
                return true;
            if(input.equals("n"))
                return false;
            System.out.println("Invalid input, insert (y/n)");
        }
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
    
    private static String getValidSize(){
        while(true){
            String input=getValidString().toLowerCase();
            
            if(input.equals("small")||input.equals("medium")||input.equals("big"))
                return input;
            System.out.println("Invalid input, insert (small/medium/big)");
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        PetCenter a;
        boolean run =true;
        boolean aux,trained,indoor,getAlong;
        int op,op2;
        int petID, adopterID, age, phone;
        String name, breed, size, email, species;
        
        try {
            a = PetCenter.loadFromFile("adoption_center.dat");
            a.loadID();
            System.out.println("Loaded existing data from file.");
        } catch (Exception e) {
            System.out.println("Starting with new adoption center.");
            a = new PetCenter("Ninas Pet");
        }
        
        
        while(run){
            System.out.println("\nPet Adoption Center System"
                    + "\n1. Add a new pet"
                    + "\n2. Register a new adopter"
                    + "\n3. View all available pets"
                    + "\n4. Search for pets"
                    + "\n5. Search for adopters"
                    + "\n6. View all pets"
                    + "\n7. View all adopters"
                    + "\n8. Adopt a pet"
                    + "\n9. Remove pet"
                    + "\n10. Save file"
                    + "\n11. Exit");
            
            System.out.print("Enter your choice: ");
            op=getValidInt();
            
            switch(op){
                case 1:
                    System.out.println("Enter the name of the pet: ");
                    name=getValidString();
                    System.out.println("Enter the age of the pet: ");
                    age=getValidInt();
                    System.out.println("What species is the pet"
                            + "\n1. Dog"
                            + "\n2. Cat"
                            + "\n3. Bird");
                    aux=false;
                    do{
                        op2=getValidInt();
                        switch(op2){
                            case 1:
                                System.out.println("Enter the breed: ");
                                breed=getValidString();
                                System.out.println("Enter the size (small/medium/big): ");
                                size=getValidSize();        
                                System.out.println("Enter is the dog trained Y/N: ");
                                trained=getValidBoolean();
                                a.addPet(name, age, breed, size, trained);
                                aux=true;
                                break;
                            case 2: 
                                System.out.println("Enter the breed: ");
                                breed=getValidString();
                                System.out.println("Is the cat indoor Y/N: ");
                                indoor=getValidBoolean();
                                System.out.println("Does the cat get along with others Y/N: ");
                                getAlong=getValidBoolean();
                                a.addPet(name, age, breed, indoor, getAlong);
                                aux=true;
                                break;
                            case 3:
                                System.out.println("Enter the breed: ");
                                breed=getValidString();
                                System.out.println("Enter the size (small/medium/big): ");
                                size=getValidSize();    
                                a.addPet(name, age, breed, size);
                                aux=true;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }while(!aux);
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    name=getValidString();
                    System.out.println("Enter your email: ");
                    email=getValidString();
                    System.out.println("Enter your phoneNumber: ");
                    phone=getValidInt();
                    System.out.println(a.registerAdopter(name, email, phone));
                    break;
                case 3:
                    System.out.println(a.listAvailablePets());
                    break;
                case 4:
                    System.out.println("Enter your term for the search"
                            + "\n1. By ID"
                            + "\n2. By species"
                            + "\n3. By age"
                            + "\n4. By breed");
                    op2=getValidInt();
                    switch(op2){
                        case 1:
                            System.out.println("Enter the petID");
                            petID=getValidInt();
                            System.out.println(a.searchPet(petID));
                            break;
                        case 2:
                            System.out.println("Enter the species");
                            species=getValidString();
                            System.out.println(a.searchPetBySpecies(species));
                            break;
                        case 3:
                            System.out.println("Enter the age: ");
                            age=getValidInt();
                            System.out.println(a.searchPetByAge(age));
                            break;
                        case 4:
                            System.out.println("Enter the breed: ");
                            breed=getValidString();
                            System.out.println(a.searchPetByBreed(breed));
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    System.out.println("Enter the adopterID");
                    adopterID=getValidInt();
                    System.out.println(a.searchAdopter(adopterID));
                    break;    
                case 6:
                    System.out.println(a.listPets());
                    break;
                case 7:
                    System.out.println(a.listAdopters());
                    break;
                case 8:
                    System.out.println("Enter the petID");
                    petID=getValidInt();
                    System.out.println("Enter the adopterID");
                    adopterID=getValidInt();
                    aux=a.adoptPet(petID, adopterID);
                    if(aux)
                        System.out.println("Congratulations");
                    else
                        System.out.println("Something went wrong, verify the ID's and that the pet is avaliable");
                    break;
                case 9:
                    System.out.println("Enter the petID");
                    petID=getValidInt();
                    System.out.println(a.removePet(petID));
                    break;
                case 10:
                    a.saveToFile("adoption_center.dat");
                    System.out.println("Data saved successfully.");
                    break;
                case 11: 
                    run=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}
