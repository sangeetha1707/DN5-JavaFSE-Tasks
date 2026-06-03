import java.util.Scanner;
import java.util.Random;

public class GuessGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int randomNumber = r.nextInt(100) + 1;
        int guess;

        do {
            System.out.print("Guess a number (1-100): ");
            guess = sc.nextInt();

            if(guess > randomNumber)
                System.out.println("Too High");
            else if(guess < randomNumber)
                System.out.println("Too Low");
            else
                System.out.println("Correct Guess!");
        } while(guess != randomNumber);

        sc.close();
    }
}
/*
Guess a number (1-100): 60
Too Low
Guess a number (1-100): 80
Too High
Guess a number (1-100): 65
Too High
Guess a number (1-100): 64
Too High
Guess a number (1-100): 63
Too High
Guess a number (1-100): 62
Correct Guess!
*/