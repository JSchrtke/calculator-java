package calculator;

public abstract class Operator {

    abstract public double applyTo(double leftOperand, double rightOperand);

    abstract public String toString();

}
