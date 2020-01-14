package calculator;

import java.util.HashMap;

public class CalculatorApp {
    public static void main(String[] args) {
        HashMap<Character, Operation> validOperations = new HashMap<Character, Operation>();
        validOperations.put('+', new Addition());
        validOperations.put('-', new Subtraction());
        validOperations.put('*', new Multiplication());
        validOperations.put('/', new Division());

        Calculator calc = new Calculator(validOperations);

        calc.doEverything();

        calc.close();
    }
}