// Simple Calculator
import java.util.*;

public class Task2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number 1 : ");
        int num1 = sc.nextInt();

        System.out.println("Enter number 2: ");
        int num2 = sc.nextInt();

        System.out.println("Enter operation(+,-, *, /): ");
        char operator = sc.next().charAt(0);

        if(operator == '+') {
            System.out.println("Addition: " + (num1 + num2));
        } else if(operator == '-') {
            System.out.println("Subtraction: " + (num1 - num2));
        } else if(operator == '/') {
            System.out.println("Division: " + (num1 / num2));
        } else if(operator == '*') {
            System.out.println("Multiplication: " + (num1 * num2));
        }

        sc.close();
    }
}