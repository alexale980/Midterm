/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * This class takes an enum input (PLUS, MINUS, TIMES, DIVIDE)
 * from the user and executes the arithmetic operation.
 * It demonstrates the advantages of using enum over String for
 * representing arithmetic operations.
 * @author Kshitij Ale
 */

package arithmetic;

import java.util.Scanner;

// Enum to represent arithmetic operations
enum Operation {
    PLUS, MINUS, TIMES, DIVIDE
}

public class ArithmeticBase {
    private double x, y;

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double calculate(Operation operation) {
        switch (operation) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                if (y != 0) {
                    return x / y;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            default:
                throw new AssertionError("Unknown operation: " + operation);
        }
    }

   
    public double calculate(String operationStr) {
        switch (operationStr.toUpperCase()) {
            case "PLUS":
                return x + y;
            case "MINUS":
                return x - y;
            case "TIMES":
                return x * y;
            case "DIVIDE":
                return x / y;
            default:
                throw new AssertionError("Unknown operation " + this);
        }
    }

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

            // Perform the calculation using the enum
            double result = arithmeticBase.calculate(operation);

            // Print the result
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid operation!");
        }
    }
}
