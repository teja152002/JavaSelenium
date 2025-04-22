package javaCode;

import java.util.Scanner;

public class Main {
	public static int countCharacterOccurrences(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the name:");
		String name = scanner.nextLine();

		System.out.println("Enter the characters to count (without spaces):");
		String searchChars = scanner.next();

		for (char ch : searchChars.toCharArray()) {
			int count = countCharacterOccurrences(name, ch);
			System.out.println("The character '" + ch + "' appears " + count + " times in the product name.");
		}

		scanner.close();
	}
}
