/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic;


import java.util.Scanner;

/** This class calls the method to perform 
 * arithmetic operations based on user input
 * execute the code check the output
 * @author Kshitij Ale
 * 
 */

public class Arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        // Consume the newline character
        scanner.nextLine();

        System.out.print("Enter the arithmetic operation (PLUS, MINUS, TIMES, DIVIDE): ");
        String operationStr = scanner.nextLine().toUpperCase();

        try {
            // Convert the input String to the Operation enum
            Operation operation = Operation.valueOf(operationStr);

            // Create an instance of ArithmeticBase
            ArithmeticBase arithmeticBase = new ArithmeticBase();
            arithmeticBase.setX(num1);
            arithmeticBase.setY(num2);

            
            double result = arithmeticBase.calculate(operation);

            // Print the result
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation!");
        }
    }
}