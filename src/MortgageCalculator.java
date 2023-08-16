package com.jobayer;

import java.text.NumberFormat;
import java.util.Scanner;

public class MainApplication
{
    final static byte MONTH_IN_YEAR = 12;
    final static byte PERCENT = 100;

    public static void main(String[] args) {

        int principle = (int) readNumber("Principle: ", 1000, 1_00_000);
        float annualInterest = (float) readNumber("Annual interest rate: ", 1, 30);
        byte years = (byte) readNumber("Period (Years): ", 1, 30);

        printMortgage(principle, annualInterest, years);
        printPaymentSchedule(principle, annualInterest, years);
    }

    private static void printMortgage(int principle, float annualInterest, byte years) {
        double mortgage = calculateMortgage(principle, annualInterest, years);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE:");
        System.out.println("--------");
        System.out.println("Mortgage: " + mortgageFormatted);
    }

    private static void printPaymentSchedule(int principle, float annualInterest, byte years) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("----------------");
        for (short month = 1; month <= years * MONTH_IN_YEAR; month++){
            double balance = calculateBalance(principle, annualInterest, years, month);
            System.out.println(NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    public static double readNumber(String prompt, int min, int max){
        Scanner scan = new Scanner(System.in);
        double value;
        while (true){
            System.out.print(prompt);
            value = scan.nextFloat();
            if (value > min && value < max)
                break;
            System.out.println("Enter a value between " + min + "and " + max);
        }
        return value;
    }

    public static double calculateBalance(int principle, float annualInterest, byte years, short numberOfPaymentsMade) {
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);
        float   monthlyInterestRate = annualInterest / PERCENT / MONTH_IN_YEAR;

        double balance = principle
                * (Math.pow(1 + monthlyInterestRate, numberOfPayments) - Math.pow(1 + monthlyInterestRate, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

        return balance;
    }

    public static double calculateMortgage(int principle, float annualInterest, byte years) {
        short numberOfPayments = (short) (years * MONTH_IN_YEAR);
        float   monthlyInterestRate = annualInterest / PERCENT / MONTH_IN_YEAR;

        double mortgage = principle * (monthlyInterestRate * Math.pow( 1 + monthlyInterestRate, numberOfPayments))
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) -1 );
        return mortgage;
    }
}
