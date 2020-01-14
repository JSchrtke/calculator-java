package calculator;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Operation operation;
        MathExpression calculation;

        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Operation> validOperations = new HashMap<Character, Operation>();
        double firstNumber = 0;
        double secondNumber = 0;
        char operationKey = '+';

        validOperations.put('+', new Addition());
        validOperations.put('-', new Subtraction());
        validOperations.put('*', new Multiplication());
        validOperations.put('/', new Division());

        do {
            try {
                System.out.println("Enter first number: ");
                firstNumber = scanner.nextDouble();
                System.out.println("Enter second number: ");
                secondNumber = scanner.nextDouble();
                System.out.println("Enter operator: ");
                operationKey = scanner.next().charAt(0);
                if (!validOperations.containsKey(operationKey)) {
                    throw new InputMismatchException("No valid operator!");
                }
                operation = validOperations.get(operationKey);
                break;
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input!");
                System.err.println(ime.getMessage());
                scanner.nextLine(); // TODO remove this after getting input from string
                continue;
            }

        } while (true);

        calculation = new MathExpression(firstNumber, secondNumber, operation);

        System.out.println(calculation.toString());
        scanner.close();
    }
}