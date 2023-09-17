

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCounter {
    static String inputText = "hello";
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Word Counter");


        System.out.println("Enter '1' to input text, '2' to provide a file:");
        int choice = sc.nextInt();
        sc.nextLine();


        if (choice == 1) {

            System.out.println("Enter your text:");
            inputText = sc.nextLine();
        } else if (choice == 2) {

            System.out.println("Enter the path to the file:");
            String filePath = sc.nextLine();
            inputText = readFile(filePath);
        } else {
            System.out.println("Invalid choice.");
            return;
        }


        String[] words = inputText.split("\\s");


        int wordCount = 0;


        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }


        System.out.println("Total words: " + wordCount);
    }


    private static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return content.toString();
    }
}
