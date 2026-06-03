import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> students = new ArrayList<>();

        System.out.print("How many names to enter: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++) {

            System.out.print("Enter name " + i + ": ");
            students.add(sc.nextLine());
        }

        System.out.println("Student Names:");

        for(String name : students) {
            System.out.println(name);
        }

        sc.close();
    }
}

/*
How many names to enter: 3
Enter name 1: Ram
Enter name 2: Ravi
Enter name 3: Kumar
Student Names:
Ram
Ravi
Kumar
*/