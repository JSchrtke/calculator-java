package calculator;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double result;
        Operator operator;
        MathExpression calculation;

        Scanner scanner = new Scanner(System.in);
        HashMap<Character, Operator> validOperators = new HashMap<Character, Operator>();
        double firstNumber = 0;
        double secondNumber = 0;
        char operatorKey = '+';

        validOperators.put('+', new AdditionOperator());
        validOperators.put('-', new SubtractionOperator());
        validOperators.put('*', new MultiplicationOperator());
        validOperators.put('/', new DivisionOperator());

        do {
            try {
                System.out.println("Enter first number: ");
                firstNumber = scanner.nextDouble();
                System.out.println("Enter second number: ");
                secondNumber = scanner.nextDouble();
                System.out.println("Enter operator: ");
                operatorKey = scanner.next().charAt(0);
                if (!validOperators.containsKey(operatorKey)) {
                    throw new InputMismatchException("No valid operator!");
                }
                operator = validOperators.get(operatorKey);
                break;
            } catch (InputMismatchException ime) {
                System.err.println("Invalid input!");
                System.err.println(ime.getMessage());
                scanner.next(); // flush in stream // TODO can I get rid of this somehow?
                continue;
            }

        } while (true);

        calculation = new MathExpression(firstNumber, secondNumber, operator);

        try {
            result = calculation.evaluate();
            System.out.printf("%.2f %s %.2f = %.2f", firstNumber, operator.toString(), secondNumber, result);
        } catch (ArithmeticException ae) {
            System.err.println(ae.getMessage());
        } finally {
            scanner.close();
        }
    }
}