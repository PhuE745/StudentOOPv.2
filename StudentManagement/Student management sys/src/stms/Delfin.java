package stms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Delfin {
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        String csvFile = "src\\StudentInfo.csv"; 

        // Prompt user for input
        System.out.println("Enter the number of records you want to input:");
        int numberOfRecords = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        File file = new File(csvFile);
        boolean isNewFile = false;

        // Check if the file exists and is empty
        if (!file.exists()) {
            isNewFile = true; // File does not exist, so it will be created
        } else if (file.length() == 0) {
            isNewFile = true; // File exists but is empty
        }

        try (FileWriter writer = new FileWriter(csvFile, true)) { // Open in append mode
            // Write the header only if the file is new or empty
            if (isNewFile) {
                writer.append("Name,Age,Gender,Birthday,LRN,Guardian,Address");
            }

            // Collect user input and write to CSV
            for (int i = 0; i < numberOfRecords; i++) {
                System.out.println("Enter name:");
                String name = scanner.nextLine();

                System.out.println("Enter age:");
                int age = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                System.out.println("Enter Gender:");
                String gender = scanner.nextLine();

                System.out.println("Enter Birthday:");
                String bday = scanner.nextLine();
                
                System.out.println("Enter LRN:");
                int LRN = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                
                System.out.println("Enter Parent name:");
                String pn = scanner.nextLine();
                
                System.out.println("Enter Parent Contact number:");
                String pc = scanner.nextLine(); // Read the full contact number
                
                System.out.println("Enter address:");
                String address = scanner.nextLine(); // Use nextLine for address
                
                // Write the data to the CSV file
                writer.append(name)
                      .append(",")
                      .append(String.valueOf(age))
                      .append(",")
                      .append(gender)
                      .append(",")
                      .append(bday)
                      .append(",")
                      .append(String.valueOf(LRN))
                      .append(",")
                      .append(pn)
                      .append(",")
                      .append(pc)
                      .append(",")
                      .append(address)
                      .append("\n");
            }

            System.out.println("Data has been written to " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}