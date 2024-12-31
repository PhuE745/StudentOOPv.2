package stms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Valenzuela {
    private String csvFile;

    // Constructor to initialize the csvFile
    public Valenzuela(String csvFile) {
        this.csvFile = csvFile;
    }

    // Method to search for a student by name
    public void searchStudent(String nameToSearch) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String currentLine;
            boolean found = false;

            // Read the header line (optional)
            String header = reader.readLine(); // Read and ignore the header

            // Read each line in the CSV file
            while ((currentLine = reader.readLine()) != null) {
                // Split the line into fields
                String[] fields = currentLine.split(",");

                // Check if the first field (name) matches the search term
                if (fields[0].equalsIgnoreCase(nameToSearch)) {
                    System.out.println("Record found: " + currentLine);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No record found for: " + nameToSearch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void search(Scanner ans) {
        Scanner scanner = new Scanner(System.in);
        
        // Specify the path to your CSV file here
        String csvFilePath = "src/StudentInfo.csv"; // Change this to your actual file path
        Valenzuela searcher = new Valenzuela(csvFilePath);

        System.out.println("Enter the name of the student to search:");
        String nameToSearch = scanner.nextLine();
        
        // Search for the student
        searcher.searchStudent(nameToSearch);

        
    }
}