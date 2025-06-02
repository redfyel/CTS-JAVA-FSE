import java.util.Scanner;

public class Task15 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        StringBuilder s = new StringBuilder(sc.nextLine());

        int i = 0, j = s.length()-1;
        while(i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
           
            // swapping
            char temp = left;
            s.setCharAt(i, right);
            s.setCharAt(j, temp);


            i++;
            j--;
        }

        System.out.println("Reversed string: " + s);
        sc.close();


    }
}
