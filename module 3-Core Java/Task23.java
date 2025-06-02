import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task23 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            System.out.println("contents of output.txt: \n\n");
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("some error occurred: " + e.getMessage());
        } finally {
            System.out.println("\n\nEnd of file reading.");
        }
    }
}
