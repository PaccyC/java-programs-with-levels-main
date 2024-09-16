package com.paccy;

import java.util.Arrays;
import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of grades that you want to calculate the average for: ");
        int n= sc.nextInt();

       double[] grades = new double[n];

       for (int i = 0; i < n; i++) {
           System.out.println("Please enter the grade you want to calculate for: ");
           grades[i]=sc.nextDouble();
       }
        int sum=0;
       for (int i = 0; i < n; i++) {
           sum+=grades[i];
       }
        double average=  ((double) sum/n);

       switch ((int) average){
           case 80 :
               System.out.println("Very good");
       }
    }
}
