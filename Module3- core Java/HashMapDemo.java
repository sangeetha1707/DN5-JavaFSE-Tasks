import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer,String> students = new HashMap<>();

        System.out.print("How many students: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            students.put(id, name);
        }

        System.out.print("Enter ID to search: ");
        int searchId = sc.nextInt();

        System.out.println("Name = " + students.get(searchId));

        sc.close();
    }
}

/*
How many students: 2
Enter ID: 101
Enter Name: Ram
Enter ID: 102
Enter Name: Ravi
Enter ID to search: 102
Name = Ravi
*/