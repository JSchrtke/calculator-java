package calculator;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) { // TODO make a proper menu thing for this
            String userInput = scanner.nextLine();
            calc.evaluateString(userInput);
            System.out.println(calc.toString());
        }

        // scanner.close();
    }
}