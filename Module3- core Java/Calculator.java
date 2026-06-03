import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("Choose Operation (+,-,*,/): ");
        char op = sc.next().charAt(0);

        switch(op) {
            case '+':
                System.out.println("Result = " + (num1 + num2));
                break;
            case '-':
                System.out.println("Result = " + (num1 - num2));
                break;
            case '*':
                System.out.println("Result = " + (num1 * num2));
                break;
            case '/':
                System.out.println("Result = " + (num1 / num2));
                break;
            default:
                System.out.println("Invalid Operation");
        }

        sc.close();
    }
}
/*
Enter first number: 4
Enter second number: 5
Choose Operation (+,-,*,/):
*
Result = 20.0
*/