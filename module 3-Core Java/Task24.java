import java.util.ArrayList;
import java.util.Scanner;

public class Task24 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();

        System.out.println("Enter names. type \'bye\'to stop");
        Scanner sc = new Scanner(System.in);

        while(true) {
            String name = sc.nextLine();

            if(name.equals("bye")) {
                break;
            } else {
                names.add(name);
            }
        }

        System.out.println("names entered: ");
        for(String name: names) {
            System.out.print(name + " ");
        }

        System.out.println("\nTotal names entered: " + names.size());
        System.out.println("First name entered: " + (names.size() > 0 ? names.get(0) : "No names entered"));

        sc.close();
    }
}
