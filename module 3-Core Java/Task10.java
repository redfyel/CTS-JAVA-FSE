import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Random random = new Random();
        int chosenNum = random.nextInt(1, 101); 

        Scanner sc = new Scanner(System.in);
        int userNum = -1;

        while(chosenNum != userNum) {
            System.out.println("Guess number between 1 and 100");

            userNum = sc.nextInt();

            if(userNum == chosenNum){
                System.out.println("you Cool!! you got it right:)");

            } else if(userNum < chosenNum) {
                System.out.println("too low!");
            } else {
                System.out.println("too high");
            }
        }

        sc.close();
    }
}
