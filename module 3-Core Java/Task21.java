import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class Task21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age: ");
        int age = sc.nextInt();

        try {
            if (age < 18) {
                throw new InvalidAgeException("Age must be 18 or older");
            } else {
                System.out.println("welcome, you are old enough!");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Caught you! " + e.getMessage());
        } finally {
            sc.close();
        }

    }
}