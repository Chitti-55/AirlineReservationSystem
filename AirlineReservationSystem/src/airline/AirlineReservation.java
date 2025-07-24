package airline;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AirlineReservation {
    static int seats[] = new int[11]; // Index 1 to 10 used
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to XYZ Airlines");

        while (true) {
            System.out.println("\nPlease select an option: ");
            System.out.println("1. View available seats");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Exit");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        displaySeats();
                        break;
                    case 2:
                        reserveSeat();
                        break;
                    case 3:
                        System.out.println("Thank you for using XYZ Airlines");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
    }

    public static void displaySeats() {
        System.out.println("Seats Status:");
        for (int i = 1; i <= 10; i++) {
            System.out.println("Seat " + i + ": " + (seats[i] == 0 ? "Available" : "Reserved"));
        }
    }

    public static void reserveSeat() {
        try {
            System.out.print("Enter seat number to reserve (1-10): ");
            int seat = sc.nextInt();

            if (seat < 1 || seat > 10) {
                System.out.println("Invalid seat number. Please choose between 1 and 10.");
            } else if (seats[seat] == 0) {
                seats[seat] = 1;
                System.out.println("Seat " + seat + " reserved successfully.");
            } else {
                System.out.println("Seat " + seat + " is already reserved.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid seat number.");
            sc.next(); // Clear invalid input
        }
    }
}
