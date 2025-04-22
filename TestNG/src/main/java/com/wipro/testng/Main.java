package com.wipro.testng;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        findUncommonCharacters(str1, str2);

        scanner.close();
    }

    public static void findUncommonCharacters(String str1, String str2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char ch : str1.toCharArray()) {
            set1.add(ch);
        }
        for (char ch : str2.toCharArray()) {
            set2.add(ch);
        }

        HashSet<Character> uncommon = new HashSet<>();


        for (char ch : set1) {
            if (!set2.contains(ch)) {
                uncommon.add(ch);
            }
        }

        for (char ch : set2) {
            if (!set1.contains(ch)) {
                uncommon.add(ch);
            }
        }

        if (uncommon.isEmpty()) {
            System.out.println("No uncommon characters found.");
        } else {
            System.out.print("Uncommon characters: ");
            for (char ch : uncommon) {
                System.out.print(ch + " ");
            }
        }
    }
}











































