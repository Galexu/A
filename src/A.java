import java.io.*;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Stuff\\Desktop\\Grabar Datos\\50\\sim1\\Preguntas.txt";
        String outputFilePath = "D:\\Stuff\\Desktop\\Grabar Datos\\50\\sim1\\Preguntas1.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            String previousLine = "";
            int skipLines = 0;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Elena")) {
                    skipLines = 3;
                }
                if (skipLines > 0) {
                    skipLines--;
                    continue;
                }
                if (line.matches("^(\\d+|a\\)|b\\)|c\\)).*")) {
                    writer.write(previousLine);
                    writer.newLine();
                    previousLine = line;
                } else {
                    previousLine += " " + line;
                }
            }
            if (skipLines == 0) {
                writer.write(previousLine); // Write the last line
            }
        } catch (IOException e) {
            System.err.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }
}