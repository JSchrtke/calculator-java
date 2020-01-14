package calculator;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    HashMap<Character, Operation> validOperations;
    Operation operation;
    MathExpression calculation;
    Scanner scanner = new Scanner(System.in);
    double firstNumber = 0;
    double secondNumber = 0;
    char operationKey = '+';

    public Calculator(HashMap<Character, Operation> validOperations) {
        this.validOperations = validOperations;
    }

    public void doEverything() {

        getInput();

        calculation = new MathExpression(firstNumber, secondNumber, operation);

        System.out.println(calculation.toString());
    }

    public void getInput() {
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
    }

    public void close() {
        scanner.close();
    }
}