import java.util.HashMap;
import java.util.Scanner;

public class Task25 {
    public static void main(String[] args) {
        HashMap <Integer, String> mp = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter roll number and name. type -1 to exit");

        while(true) {
            int rollNu = sc.nextInt();
            if(rollNu == -1) break;
            String name = sc.nextLine();

            mp.put(rollNu, name);
        }

        System.out.println("Enter id you want to retrieve:");
        int id = sc.nextInt();

        System.out.println(id + " " + mp.get(id));
        sc.close();
    }
}
