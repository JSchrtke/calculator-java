package calculator;
// TODO 23+4-2*5 causes Exception

// TODO I found a mistake, I think. At least in the Multiplication class, you
//  have "([0-9]+(\\.[0-9])*\\s*\\*\\s*[0-9]+\\.*[0-9]*)". The number parts
//  probably shoudl be "[0-9]+(\\.[0-9]+)?" (? instead of the *). This way you
//  won't match 0.1.1, but you will match 1.11.

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