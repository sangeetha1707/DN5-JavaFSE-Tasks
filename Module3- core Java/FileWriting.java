import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter text: ");
            String text = sc.nextLine();

            FileWriter fw = new FileWriter("output.txt");

            fw.write(text);

            fw.close();

            System.out.println("Data written successfully");

        } catch(IOException e) {

            System.out.println("Error writing file");

        }

        sc.close();
    }
}

/*
Enter text: Hello Java
Data written successfully
*/