/**
 * Name: (REDACTED)
 * Course: CSCI 241 - Computer Science I
 * Section: 002
 * Assignment: 6
 *
 * Project/Class Description:
 * This program takes in a credit card number that the user inputs and performs the Luhn Test on
 * the number to see if the card is a valid number or not. It then outputs the validity of the card.
 *
 * Known bugs:
 * (none)
 */
import java.util.*;

public class CreditCard
{
    // Main method to execute the program
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        // Asks and test validity of an inputted credit card three (3) times
        for(int i = 0; i < 3; i++) {
            // Asks the user to input a credit card number and stores the value in 'creditCard'
            System.out.print("Enter a credit card number as a long integer: ");
            long creditCard = input.nextLong();

            // Prints out if the inputted credit card is valid/invalid
            if((sumOfEvensDoubled(creditCard) + sumOfOddPlaces(creditCard)) % 10 == 0) {
                System.out.println(creditCard + " is a valid number.\n");
            } else {
                System.out.println(creditCard + " is an invalid number.\n");
            }
        }
    }

    // Calculates the sum of the even digits and doubles it
    public static int sumOfEvensDoubled(long x) {
        // Initalizes a variable to hold the sum of the digits
        int sum = 0;

        // Iterates through every even-numbered place in the credit card
        for(int i = 0; x > 0; i++) {
            // Calculates double of the last even numbered digit in the number
            int tempNum = 2 * (int)((x % 100) / 10);

            // Checks if doubling the digit is 2 digits and if it is, it performs the algorithm 
            // to shrink it to one digit
            if(tempNum >= 10) {
                sum += shrinkToOneDigit(tempNum);
            } else {
                sum += tempNum;
            }

            // Makes x smaller so that the calculations on the next even digit can be performed
            // or if the loop is at the last even digit, ends the loop
            x = x / 100;
        }

        // Returns the result of the sum of the digits doubled
        return sum;
    }

    // In the sumOfEvensDoubled method, if doubling a number results in a two-digit number, 
    // the algorithm says to return the sum of the digits
    public static int shrinkToOneDigit(int x) {
        return (int)(x / 10) + (int)(x % 10);
    }

    // Takes the sum of all the odd numbered digits in the credit card
    public static int sumOfOddPlaces(long x) {
        // Initalizes a sum variable to hold the sum of the odd-placed digits
        int sum = 0;

        // Iterates through every odd-numbered place in the credit card
        for(int i = 0; x > 0; i++) {
            // Calculates how much to add to the sum and adds that value to the sum
            sum += (int)(x % 10);

            // Makes x smaller so that the loop can do calculations on the next odd-placed digit
            // or ends the loop if at the last odd-placed digit
            x = x / 100;
        }

        // Returns the sum after the loop is completed
        return sum;
    }
}
