package calculator;

import java.util.LinkedHashMap;

import calculator.operation.Operation;
import calculator.operation.Multiplication;
import calculator.operation.Division;
import calculator.operation.Addition;
import calculator.operation.Subtraction;
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

    public void evaluateString(final String userInput) {

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
                } catch (Exception e) {
                    System.err.println("Exception occured: ");
                    System.err.println(e.getMessage());
                }
            }

        }
        this.result = Double.parseDouble(mathString);
    }

    public String toString() {
        return String.format("%s = %.2f", this.currentUserInput, this.result);
    }

    public double getResult() {
        return this.result;
    }
}