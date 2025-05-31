public class task12 {
    public static int add(int a, int b) {
        return a+b;
    }

    public static double add(double a, double b) {
        return a+b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        System.out.println("SUm of 90 and 10 is: " + add(90, 10));
        System.out.println("Sum of 9.5 and 19.8 is: " + add(9.5, 19.8));
        System.out.println("Sum of 1,2,3 is: " + add(1,2,3));

    }
}
