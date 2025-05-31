public class Task8 {
    public static void main(String[] args) {
        int result = 10 + 5 * 2 - 10 / 2 + 9 * 7 + 8 * 9 - 10 / 2;
        System.out.println("the expression: " + " 10 + 5 * 2 - 10 / 2 + 9 * 7 + 8 * 9 - 10 / 2");
        System.out.println("the result : " + result);
    }
}

// 10 + 5 * 2 - 10 / 2 + 9 * 7 + 8 * 9 - 10 / 2
// 10 + (5 * 2) - (10 / 2) + (9 * 7) + (8 * 9) - (10 / 2)
// 10 + 10 - 5 + 63 + 72 - 5

// order of operator precedence:
// 1. Parentheses
// 2. Multiplication and Division (from left to right)
// 3. Addition and Subtraction (from left to right)

// 10 + 10 - 5 + 63 + 72 - 5 
// = 10 + 10 = 20
// = 20 - 5 = 15
// = 15 + 63 = 78
// = 78 + 72 = 150
// = 150 - 5 = 145
