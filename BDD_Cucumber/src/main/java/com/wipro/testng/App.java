package com.wipro.testng;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Result {
    // Method to count vowels in a word
    private static int countVowels(String word) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    // Method to extract hidden word
    public static void extractHiddenWord(List<String> messages) {
        StringBuilder hiddenMessage = new StringBuilder();
        Pattern pattern = Pattern.compile("^[a-zA-Z ]+$"); // Ensuring only alphabets & spaces allowed

        for (String line : messages) {
            // Input validation: Check if only alphabets and spaces are present
            if (!pattern.matcher(line).matches()) {
                System.out.println("Invalid input");
                return;
            }

            // Trim extra spaces and split words correctly
            String[] words = line.trim().split("\\s+");

            // Constraint check: Each line should have exactly 8 words
            if (words.length != 8) {
                System.out.println("Invalid input");
                return;
            }

            StringBuilder binaryRepresentation = new StringBuilder();

            for (String word : words) {
                int vowelCount = countVowels(word);
                binaryRepresentation.append((vowelCount % 2 == 1) ? "1" : "0");
            }

            // Convert binary string to ASCII character
            int charCode = Integer.parseInt(binaryRepresentation.toString(), 2);
            hiddenMessage.append((char) charCode);
        }

        System.out.println(hiddenMessage.toString());
    }
}

public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int messagesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> messages = IntStream.range(0, messagesCount)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        Result.extractHiddenWord(messages);
        bufferedReader.close();
    }
}
