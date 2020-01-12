package calculator;

public class DivisionOperator extends Operator {

    @Override
    public double applyTo(double leftOperand, double rightOperand) throws ArithmeticException {
        if (rightOperand == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return leftOperand / rightOperand;
    }

    @Override
    public String toString() {
        return "/";
    }

}
