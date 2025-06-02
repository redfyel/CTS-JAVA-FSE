import java.util.Scanner;

public class Task20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers:  ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        try {
            int res = num1/ num2;
            System.out.println("Division Quotient: " + res);
        } catch (ArithmeticException e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println("checking if this prints despite any error!");
        sc.close();
    }
}
