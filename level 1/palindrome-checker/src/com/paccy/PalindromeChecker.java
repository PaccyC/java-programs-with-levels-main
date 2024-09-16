package com.paccy;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to be checked: ");
        String input= scanner.nextLine();

        StringBuilder reversedString= new StringBuilder();

        for (int i=input.length()-1;i>=0;i--){
            reversedString.append(input.charAt(i));
        }
        if(input.equals(reversedString.toString())){
            System.out.println("Yes, the word is a palindrome.");
        }
        else {
            System.out.println("No, the word is not a palindrome.");
        }
    }
}
