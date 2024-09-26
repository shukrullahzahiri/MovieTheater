package com.keyin;

import java.util.Scanner;

public class MovieTheater {
    private final int[][] seats;  // 2D array to represent seat availability
    private final int rows;       // Number of rows in the theater
    private final int columns;    // Number of columns in the theater

    // Constructor to initialize the seating chart
    public MovieTheater(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        seats = new int[rows][columns];  // Initialize the 2D array for seats

        // Initially, all seats are available (0 = available, 1 = reserved)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = 0;  // Set all seats to available (0)
            }
        }
    }

    // 1. Method to reserve a seat
    public void reserveSeat(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            if (seats[row][column] == 0) {
                seats[row][column] = 1;  // Reserve the seat
                System.out.println("Seat at row " + row + ", column " + column + " has been reserved.");
            } else {
                System.out.println("Sorry, seat at row " + row + ", column " + column + " is already reserved.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
    }

    // 2. Method to cancel a reserved seat
    public void cancelSeat(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            if (seats[row][column] == 1) {
                seats[row][column] = 0;  // Reset seat to available
                System.out.println("Reservation for seat at row " + row + ", column " + column + " has been cancelled.");
            } else {
                System.out.println("Seat at row " + row + ", column " + column + " is not reserved.");
            }
        } else {
            System.out.println("Invalid seat position.");
        }
    }

    // 3. Method to display the seating chart
    public void printSeatingChart() {
        System.out.println("Current seating chart (0 = available, 1 = reserved):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to run the movie theater system
    public static void main(String[] args) {
        // Create a movie theater with a 5x5 seating arrangement
        MovieTheater theater = new MovieTheater(5, 5);
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1. Reserve Seat");
            System.out.println("2. Cancel Seat");
            System.out.println("3. Print Seating Chart");
            System.out.println("4. Exit");
            System.out.print("Enter your option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter row (0-4): ");
                    int reserveRow = scanner.nextInt();
                    System.out.print("Enter column (0-4): ");
                    int reserveCol = scanner.nextInt();
                    theater.reserveSeat(reserveRow, reserveCol);
                    break;

                case 2:
                    System.out.print("Enter row (0-4): ");
                    int cancelRow = scanner.nextInt();
                    System.out.print("Enter column (0-4): ");
                    int cancelCol = scanner.nextInt();
                    theater.cancelSeat(cancelRow, cancelCol);
                    break;

                case 3:
                    theater.printSeatingChart();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}
