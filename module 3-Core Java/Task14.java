import java.util.Scanner;

public class Task14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbe rof elements: ");
        int n = sc.nextInt();
        int sum = 0;
        float avg = 0.0f;
        int arr[] = new int[n];
        for(int i : arr) {
            System.out.println("Enter element: ");
            i = sc.nextInt();

            sum += i;
        }

        avg = sum / (n * 1.0f);
        System.out.println("sum : " + sum);
        System.out.println("average: " + avg);
        sc.close();
    }
}
