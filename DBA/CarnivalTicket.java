/**
 * This program generates a ticket and applies discounts based on Age, Name, and first responder and veteran status.
 *
 * @author Garrison Winters
 * @version 12-5-2025
 *
 *
 */

import java.util.Scanner;

public class CarnivalTicket {

    public static void printTicket(String name, String id, double price) {
        System.out.println("----------------------------------------");
        System.out.println("Welcome to the APCS Carnival, " + name + "!");
        System.out.println("Your user ID is " + id);
        System.out.println("The cost of your ticket is $" + price);
        System.out.println("Have a great time at the APCS Carnival today!");
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String continuePurchasing = "yes";

        while (continuePurchasing.equalsIgnoreCase("yes")) {
            
            System.out.print("Enter your name (First Last): ");
            String name = input.nextLine();

            System.out.print("Enter your age: ");
            int age = input.nextInt();
            
            input.nextLine(); 

            System.out.print("Are you a first responder? (yes/no): ");
            String isResponder = input.nextLine();

            System.out.print("Are you a veteran? (yes/no): ");
            String isVeteran = input.nextLine();

            double price = 0.0;

            if (age < 3) {
                price = 2.0; 
            } else if (age <= 5) {
                price = 9.0; 
            } else if (age <= 18) {
                price = 11.0; 
            } else {
                price = 12.0; 
            }

            if (age > 18) {
                if (isResponder.equalsIgnoreCase("yes") || isVeteran.equalsIgnoreCase("yes")) {
                    price = price * 0.50; 
                }
            }

            String firstInitial = name.substring(0, 1);
            
            int spaceIndex = name.indexOf(" ");
            String lastName = name.substring(spaceIndex + 1);
            
            int randomNum = (int)(Math.random() * 1000) + 1;
            
            String userId = firstInitial + lastName + randomNum;

            printTicket(name, userId, price);

            System.out.print("Do you want to purchase another ticket? (yes/no): ");
            continuePurchasing = input.nextLine();
            System.out.println(); 
        }
        
        input.close();
    }
}
