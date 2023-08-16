package recursion;

import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

//        printNumbers(n);
//        printSum(1, n, 0);
//        int ans = calculateFactorialIterativeWay(n);
//        System.out.println(ans);

        int a = 0, b = 1;
        System.out.print(a + " " + b);

//        printFibonacciUsingRecursion(a, b, n - 2);
        printFibonacciUsingLoop(a, b, 10);
    }

    //print 5 to 1
    private static void printNumbers(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
    }

    //print sum of n natural numbers
    private static void printSum(int i, int n, int sum){
        if (i == n){
            sum += i;
            System.out.println(sum);
            return;
        }
        sum += i;
        printSum(i + 1, n, sum);
    }

    //print factorial of n number using recursion
    public static int calculateFactorialRecursionWay(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        int factorial_nm1 = calculateFactorialRecursionWay(n - 1);
        return n * factorial_nm1;
    }

    // print factorial using iterate or loop
    public static int calculateFactorialIterativeWay(int n){
        if (n == 0 || n == 1){
            return 1;
        }
        int i, fact = 1;

        for (i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void printFibonacciUsingRecursion(int a, int b, int n){
        if (n == 0){
            return;
        }

        int c = a + b;
        System.out.print(" " +c);
        printFibonacciUsingRecursion(b, c, n - 1);
    }

    public static void printFibonacciUsingLoop(int a, int b, int n) {
        if (n == 0){
            return;
        }
        int c, i;
        for (i = 2; i < n; ++i){
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

    public static int calculatePowerOfX(int x, int n){
        if (x == 0){
            return 0;
        }
        if (n == 0){
            return 1;
        }

        // x power n minus 1 = (x^n-1)
        int xPnm1 = calculatePowerOfX(x, n-1);
        return x * xPnm1;
    }

}
