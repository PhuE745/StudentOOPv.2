package stms;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner ans = new Scanner(System.in);
        boolean rep = true; // Use lowercase 'boolean' for the type
        int choice;
        String repans;
        Delfin lagay = new Delfin();
        Lorenz kita = new Lorenz();
        // Specify the path to your CSV file here
        String csvFilePath = "src\\StudentInfo.csv"; // Change this to your actual file path
        Olidan tanggal = new Olidan(csvFilePath); // Initialize Olidan with the CSV file path
        Valenzuela hanap = new Valenzuela(csvFilePath);

        while (rep) {
            try {
                System.out.println("======================");
                System.out.println(" STUDENT REGISTRATION ");
                System.out.println("======================");
                System.out.println("[1] Register a Student");
                System.out.println("[2] Search Student");
                System.out.println("[3] Remove Student");
                System.out.println("[4] Display Student");
                System.out.println("======================");
                System.out.print(" Pick a choice -> "); // Use print instead of println for better formatting
                choice = ans.nextInt();
                ans.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.println("Registering a student...");
                        lagay.input(); // Assuming you have a method to register a student
                        break;
                    case 2:
                        System.out.println("Searching for a student...");
                        hanap.search(ans);
                        break;
                    case 3:
                        System.out.println("Removing a student...");
                        tanggal.remove(ans); // Call the remove method from Olidan
                        break;
                    case 4:
                        System.out.println("Displaying students...");
                        kita.display(); // Assuming you have a method to display students
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                // Clear the invalid input
                ans.nextLine(); // This clears the invalid input from the buffer

                // Prompt the user to continue or exit
                System.out.println("Wrong input. Continue? (y/n)");
                repans = ans.next(); // Read the user's response
                repans = repans.toUpperCase(); // Convert to uppercase for consistency

                switch (repans) {
                    case "Y":
                        rep = true; // Continue the loop
                        break;
                    case "N":
                        System.out.println("Exiting the program.");
                        rep = false; // Exit the loop
                        break;
                    default:
                        System.out.println("Invalid response. Exiting the program.");
                        rep = false; // Exit the loop
                        break;
                }
            }
        }
        ans.close(); // Close the scanner
    }
}