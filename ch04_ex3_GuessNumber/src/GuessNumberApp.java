/*Exercise 4-3: Modify the Guess the Number Application 
 * SDE194: Dr. Darin Mills 
 * Deanna R.I. Burke 
 */

import java.util.Scanner;

public class GuessNumberApp {
    
    public static void main(String[] args) {
        final int LIMIT = 10;

        System.out.println("Guess the number!");
        System.out.println("I'm thinking of a number from 1 to " + LIMIT);
        System.out.println();

        // get a random number between 1 and the limit
        double d = Math.random() * LIMIT; // d is >= 0.0 and < limit
        int number = (int) d;             // convert double to int
        number++;                         // int is >= 1 and <= limit

        Scanner sc = new Scanner(System.in);            
        
      //added 'guess' variable outside of loop.
        int guess =0;
        int count = 1;
        //modified the loop below to uses boolean expression to check. 
        //while (true) {
        while (guess != number) {
            System.out.print("Your guess: ");
            //variable was declared outside of loop, declaration no longer needed here.
            //int guess = Integer.parseInt(sc.nextLine());
            guess = Integer.parseInt(sc.nextLine());
            
            if (guess < 1 || guess > LIMIT) {
                System.out.println("Invalid guess. Try again.");
                //deleted or commented out continue statement 
                //continue;
                // moved else if statement up and deleted else statement 
            } else if (guess < number) {
                System.out.println("Too low.");
                //added increment counter within loop to execute only if 
                //guess is too low
                count++;
            } else if (guess > number) {
                System.out.println("Too high.");
                //moved the increment counter within loop so it only executes 
                //if guess is too high 
                count++;
            }            
           
        }
        // moved the correct guess notification outside of the loop
        System.out.println("You guessed it in "+count+" tries!\n");

        
        
        
        System.out.println("Bye!");
    }   
}