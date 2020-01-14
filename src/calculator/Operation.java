package calculator;

public abstract class Operation {

    abstract public double applyTo(double leftOperand, double rightOperand) throws ArithmeticException;

    abstract public String toString();

}
