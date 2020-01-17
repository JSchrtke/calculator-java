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

        final String userInput = getInput();
        String mathString = userInput;

        for (Operation operation : this.validOperations.values()) {
            String currentSignature = operation.getSignatureRegex();

            while (RegexTools.stringContainsRegex(mathString, currentSignature)) {
                try {
                    String mathSubString = RegexTools.extractRegexFromString(currentSignature, mathString);
                    String evaluatedSubString = String
                            .valueOf(MathExpression.fromString(mathSubString, operation).getResult());
                    mathString = RegexTools.replaceRegexInString(currentSignature, evaluatedSubString, mathString);
                } catch (Exception e) {
                    System.err.println("Exception occured: ");
                    System.err.println(e.getMessage());
                }
            }

        }

        // calculation = new MathExpression(firstNumber, secondNumber, operation);

        // System.out.println(calculation.toString());
        System.out.printf("%s = %s", userInput, mathString);
    }

    public String getInput() {
        String result = scanner.nextLine();
        return result;
    }

    public void close() {
        scanner.close();
    }
}