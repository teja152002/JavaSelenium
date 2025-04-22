package com.wipro.milestone.Java_Selenium;


import java.util.Scanner;
class Palindrome{
    static int reverse(int n){
        int rev = 0;
        while(n!=0){
            int rem = n%10;
            rev = (rev*10) + rem;
            n = n/10;
        }
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        int reverse = reverse(n);
        if(n == reverse){
            System.out.println("Given number is Palindrome!");
        }else{
            System.out.println("Given number is not a Palindrome!");
        }
    }
}
