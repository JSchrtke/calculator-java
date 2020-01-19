package calculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	private void calc(String input, double expected) {
		Calculator c = new Calculator();
		c.evaluateString(input);
		assertEquals(expected, c.getResult(), 1e-6);
	}

	@Test
	public void emptyInputIsIgnored() {
		calc("", 0);
	}

	@Test
	public void singleNumberIsSimplyEvaluated() {
		calc("12.25", 12.25);
	}

	@Test
	public void divisionByZeroIsError() {
		calc("1/0", 0);
		// TODO output is always a double, Calculator does not even address invalid input
	}
}
