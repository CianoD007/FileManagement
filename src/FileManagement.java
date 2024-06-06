import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileManagement {
    public static void main(String[] args) {
        // Input and output file paths
        String inputFile = "studentsEN.txt";
        String outputFile = "grade5_students.txt";

        try (
                // Initialize FileReader and BufferedReader for reading
                FileReader fileReader = new FileReader(inputFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Initialize FileWriter and PrintWriter for writing
                FileWriter fileWriter = new FileWriter(outputFile);
                PrintWriter printWriter = new PrintWriter(fileWriter);
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line by tab character
                String[] parts = line.split("\t");

                // Check if the grade is 5
                if (parts.length == 3 && parts[2].equals("5")) {
                    // Write the line to the output file
                    printWriter.println(line);
                }
            }

            System.out.println("Grade 5 students have been written to " + outputFile);
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}
