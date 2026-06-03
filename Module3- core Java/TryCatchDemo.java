import java.util.Scanner;

public class TryCatchDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter first number: ");
            int a = sc.nextInt();

            System.out.print("Enter second number: ");
            int b = sc.nextInt();

            int result = a / b;

            System.out.println("Result = " + result);

        } catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        }

        sc.close();
    }
}

/*
Enter first number: 10
Enter second number: 0
Cannot divide by zero
*/