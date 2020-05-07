package calculatortest;

import static org.junit.Assert.*;

import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {
    private void calc(String input, double expected) {
        Calculator c = new Calculator();
        c.evaluateString(input);
        assertEquals(expected, c.getResult(), 1e-6);
    }

    @Test(expected = NumberFormatException.class)
    public void emptyInputThrowsNumberFormatException() {
        calc("", 0);
    }

    @Test
    public void singleNumberIsSimplyEvaluated() {
        calc("12.25", 12.25);
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZeroIsError() {
        calc("1/0", 0);
    }
}
