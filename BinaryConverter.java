/*Program Name:BinaryConverter.java
 * Authors: Austin P
 * Date last Updated: 8/28/2024
 * Purpose: This program is meant to check if the number you inputted is a binary number and converts it to a decimal number
 * and throws all non-binary number inputs
 */
import java.util.Scanner;

public class BinaryConverter {

    // Method that throws all non-binary numbers and is able to be used 
    // because it is a static method and doesn't need to be enclosed by the BinaryConverter class
    public static class BinaryFormatException extends Exception {
        public BinaryFormatException(String message) {
            super(message);
        }
    }

     // Converts a binary string to its decimal equivalent
     // This method throws any exceptions that aren't binary inputs
    public static int bin2Dec(String binaryNumber) throws BinaryFormatException {
        int decimalNumber = 0;

        // Check if the string contains only '0' or '1' at every single digit
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (binaryNumber.charAt(i) != '0' && binaryNumber.charAt(i) != '1') {
                throw new BinaryFormatException("Invalid binary string: " + binaryNumber);
            }
        }

        // Convert binary string to decimal by checking each digit and then converting accordingly 
        for (int i = 0; i < binaryNumber.length(); i++) {
            decimalNumber = decimalNumber * 2 + (binaryNumber.charAt(i) - '0');
        }

        return decimalNumber;
    }

    public static void main(String[] args) {
        // Open the Scanner object to allow for an input stream
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binaryNumber = input.nextLine();

        try {
            int decimalNumber = bin2Dec(binaryNumber);
            System.out.println("The decimal equivalent of " + binaryNumber + " is " + decimalNumber);
        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }
        // Close the Scanner object to close the input stream
        input.close(); 
    }
}