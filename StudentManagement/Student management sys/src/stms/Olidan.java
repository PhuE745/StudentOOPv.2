package stms;


import java.io.*;
import java.util.Scanner;

public class Olidan {
    private String csvFile;

    public Olidan(String csvFile) {
        this.csvFile = csvFile;
    }

    public void removeRecord(String nameToRemove) {
        System.out.println("CSV File Path: " + csvFile);
        File inputFile = new File(csvFile);
        System.out.println("Absolute File Path: " + inputFile.getAbsolutePath());

        if (!inputFile.exists()) {
            System.out.println("ERROR: File does NOT exist: " + inputFile.getAbsolutePath());
            return;
        }
        if (!inputFile.canWrite()) {
            System.out.println("ERROR: Cannot write to file (permissions issue): " + inputFile.getAbsolutePath());
            return;
        }

        try {
            File tempFile = File.createTempFile("temp", ".csv", new File("."));
            System.out.println("Temp File Path: " + tempFile.getAbsolutePath());

            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                String currentLine;
                boolean headerWritten = false;

                while ((currentLine = reader.readLine()) != null) {
                    if (!headerWritten) {
                        writer.write(currentLine);
                        writer.newLine();
                        headerWritten = true;
                        continue;
                    }

                    String[] fields = currentLine.split(",");

                    if (!fields[0].equalsIgnoreCase(nameToRemove)) {
                        writer.write(currentLine);
                        writer.newLine();
                    }
                }
            }


            System.out.println("Attempting to delete: " + inputFile.getAbsolutePath());
            boolean deleteSuccess = inputFile.delete();
            System.out.println("Delete returned: " + deleteSuccess);

            if (!deleteSuccess) {
                System.out.println("Could not delete the original file: " + inputFile.getAbsolutePath());
                return;
            }

            System.out.println("Attempting to rename: " + tempFile.getAbsolutePath() + " to " + inputFile.getAbsolutePath());
            boolean renameSuccess = tempFile.renameTo(inputFile);
            System.out.println("Rename returned: " + renameSuccess);

            if (!renameSuccess) {
                System.out.println("Could not rename the temp file: " + tempFile.getAbsolutePath());
            } else {
                System.out.println("Record removed successfully.");
            }

        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void remove(Scanner scanner) {
        System.out.println("Enter the name of the student to remove:");
        String nameToRemove = scanner.nextLine();
        removeRecord(nameToRemove);
    }

    public void tanggal(String[] args) throws IOException {
        String csvFilePath = "students.csv";
        try (FileWriter writer = new FileWriter(csvFilePath)) {
            writer.write("Name,Age,Grade\n");
            writer.write("John,18,A\n");
            writer.write("Jane,19,B\n");
            writer.write("Peter,17,C\n");
        }
        Scanner scanner = new Scanner(System.in);
        Olidan olidan = new Olidan(csvFilePath);
        olidan.remove(scanner);
        scanner.close();
    }
}