import java.util.Scanner;

public class Task13 {
    public static int fibonacci(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fibonacci(n-1) + fibonacci(n-2); 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n:" );
        int n = sc.nextInt();
        System.out.println("the nth Fibonacci number is: " + fibonacci(n));

        sc.close();
    }
}
