package calculator;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CalculatorApp {
    public static void main(String[] args) {
        LinkedHashMap<Character, Operation> validOperations = new LinkedHashMap<Character, Operation>();
        validOperations.put('*', new Multiplication());
        validOperations.put('/', new Division());
        validOperations.put('+', new Addition());
        validOperations.put('-', new Subtraction());

        Calculator calc = new Calculator(validOperations);

        while (true) {
            calc.doEverything();
            System.out.println("\n");
        }

        // calc.close();
    }
}