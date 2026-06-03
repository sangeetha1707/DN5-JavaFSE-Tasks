public class OperatorPrecedence {
    public static void main(String[] args) {

        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;

        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("(10 + 5) * 2 = " + result2);
    }
}
/*
10 + 5 * 2 = 20
(10 + 5) * 2 = 30

Explanation:
 result1 = 10 + 5 * 2
Step 1: 5 * 2 = 10   (* has higher precedence than +)
Step 2: 10 + 10 = 20

 result2 = (10 + 5) * 2
Step 1: (10 + 5) = 15   (Parentheses have highest precedence)
Step 2: 15 * 2 = 30
*/