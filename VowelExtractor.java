import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VowelExtractor {

    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        int vowelWordCount = 0;
        int totalVowelCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words
                for (String word : words) {
                    // Count vowels in the word
                    totalVowelCount += countVowels(word);

                    // Check if the word starts with a vowel
                    if (startsWithVowel(word)) {
                        writer.write(word + " ");
                        vowelWordCount++;
                    }
                }
            }

            // Write the total counts to the output file
            writer.write("\nTotal Words Starting with Vowel: " + vowelWordCount);
            writer.write("\nTotal Vowels: " + totalVowelCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean startsWithVowel(String word) {
        // Convert the first character of the word to lower case and check if it's a vowel
        if (word.length() > 0) {
            char firstChar = Character.toLowerCase(word.charAt(0));
            return firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u';
        }
        return false;
    }

    private static int countVowels(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }
}
