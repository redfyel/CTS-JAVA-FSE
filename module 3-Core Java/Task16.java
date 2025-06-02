import java.util.Scanner;

public class Task16 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        StringBuilder s = new StringBuilder(sc.nextLine());

        StringBuilder rev = new StringBuilder(s);

        int i = 0, j = rev.length()-1;
        while(i <= j) {
            char left = rev.charAt(i);
            char right = rev.charAt(j);
           
            // swapping
            char temp = left;
            rev.setCharAt(i, right);
            rev.setCharAt(j, temp);


            i++;
            j--;
        }

        System.out.println(s.toString().equals(rev.toString()));
        sc.close();


    }
}
