package finalAssessmentJava;

import java.util.Scanner;

public class MinMaxNumber {
	public static void findSecondMinMax(int[] arr) {
		if (arr == null || arr.length < 2) {
			System.out.println("Array should have at least 2 numbers!");
			return;
		}
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num < firstMin) {
				secondMin = firstMin;
				firstMin = num;
			} else if (num < secondMin && num != firstMin) {
				secondMin = num;
			}

			if (num > firstMax) {
				secondMax = firstMax;
				firstMax = num;
			} else if (num > secondMax && num != firstMax) {
				secondMax = num;
			}
		}

		if (secondMin == Integer.MAX_VALUE || secondMax == Integer.MIN_VALUE) {
			System.out.println("Not valid numbers found for 2nd min or max");
		} else {
			System.out.println("2nd Min Number: " + secondMin);
			System.out.println("2nd Max Number: " + secondMax);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number elements present in array: ");
		int n = sc.nextInt();
		System.out.println("Enter elements to an array: ");
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		findSecondMinMax(arr);
	}
}
