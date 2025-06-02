import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string to store in file: ");
        String input = sc.nextLine();

        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write(input);
            System.out.println("Successfully wriiten into output.txt");
        } catch (IOException e) {
            System.out.println("some error occured "+ e.getMessage());
        } finally {
            sc.close();
        }
    }    
}
