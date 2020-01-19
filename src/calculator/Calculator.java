package calculator;

import java.util.LinkedHashMap;

import calculator.operation.Operation;
import calculator.operation.Multiplication;
import calculator.operation.Division;
import calculator.operation.Addition;
import calculator.operation.Subtraction;
import regextools.RegexMismatchException;
import regextools.RegexTools;

public class Calculator {
    private LinkedHashMap<Character, Operation> validOperations;
    private double result;
    private String currentUserInput;

    public Calculator() {
        this.validOperations = new LinkedHashMap<Character, Operation>();
        this.validOperations.put('*', new Multiplication());
        this.validOperations.put('/', new Division());
        this.validOperations.put('-', new Subtraction());
        this.validOperations.put('+', new Addition());
        this.result = 0;
        this.currentUserInput = "";
    }

    public void evaluateString(final String userInput) throws NumberFormatException {

        this.currentUserInput = userInput;
        String mathString = userInput;

        for (Operation operation : this.validOperations.values()) {
            String currentSignature = operation.getSignatureRegex();

            while (RegexTools.stringContainsRegex(mathString, currentSignature)) {
                try {
                    String mathSubString = RegexTools.extractRegexFromString(currentSignature, mathString);
                    String evaluatedSubString = String
                            .valueOf(MathExpression.fromString(mathSubString, operation).getResult());
                    mathString = RegexTools.replaceRegexInString(currentSignature, evaluatedSubString, mathString);
                } catch (RegexMismatchException rme) {
                    System.err.println(rme.getMessage());
                    mathString = "";
                }
            }

        }
        this.result = Double.parseDouble(mathString);
    }

    public String toString() {
        String result;
        try {
            result = String.format("%s = %.2f", this.currentUserInput, getResult());
        } catch (ArithmeticException ae) {
            result = ae.getMessage();
        }
        return result;
    }

    public double getResult() throws ArithmeticException {
        if (Double.isInfinite(this.result)) {
            throw new ArithmeticException("Zero division!");
        } else if (Double.isNaN(this.result)) {
            throw new ArithmeticException("Not a number!");
        } else {
            return this.result;
        }
    }
}